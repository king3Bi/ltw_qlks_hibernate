<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Thống kê mật độ sử dụng phòng</title>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<script
		src="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/js/adminlte.min.js"></script>
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/css/adminlte.min.css">
	<script src='https://kit.fontawesome.com/a076d05399.js'
		crossorigin='anonymous'></script>
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/script.js"></script>
</head>
<body>
	<div class="wrapper">

		<jsp:include
			page="/WEB-INF/views/layouts/layout-admin/_header-admin.jsp"></jsp:include>
		<script>
			document.querySelector(".nav-sidebar").children[10].classList
					.add('menu-open');
			document.querySelector(".menu-open .nav-link").classList
					.add('active');
		</script>

		<div class="content-wrapper">
			<section class="content-header">
				<div class="container-fluid">
					<div class="col-11 ">
						<h1 class="h3 text-center text-gray-800 mb-0">Thống kê mật độ sử dụng phòng</h1>
					</div>
				</div>
			</section>

			<section class="content">

				<div class="container-fluid">
				
					<div class="row">
					    <div class="col">
					        <form id="option">
					            <input type="month" name="month" id="month" onchange="document.getElementById('option').submit();">
					            <a href="./" class="btn btn-primary">Tất cả</a>
					        </form>
					        {% if month %}
					        <script>
					            document.getElementById('month').value = '{{ month }}';
					        </script>
					        {% endif %}
					        <table class="table table-striped">
					            <thead>
					                <tr>
					                    <th>STT</th>
					                    <th>Phòng</th>
					                    <th>Số ngày thuê</th>
					                    <th>Tỷ lệ</th>
					                </tr>
					            </thead>
					            <tbody>
					            {% with usage_density = usage_density_stats_by_month['thong_ke'] %}
					            {% for room in usage_density %}
					                <tr>
					                    <td>{{ loop.index }}</td>
					                    <td>{{ room }}</td>
					                    <td>{{ usage_density[room] }}</td>
					                    {% if usage_density_stats_by_month['tong_mat_do'] > 0 %}
					                    <td>{{ '{:.2f} %'.format(100*usage_density[room]/usage_density_stats_by_month['tong_mat_do']) }}</td>
					                    {% else %}
					                    <td>00.00 %</td>
					                    {% endif %}
					                </tr>
					            {% endfor %}
					            {% endwith %}
					            </tbody>
					        </table>
					    </div>
					    <div class="col">
					        <canvas id="usageChart"></canvas>
					        <script>
					            let labels = [], info = [];
					
					            {% with usage_density = usage_density_stats_by_month['thong_ke'] %}
					            {% for room in usage_density %}
					                labels.push('{{ room }}');
					                info.push({{ usage_density[room] }});
					            {% endfor %}
					            {% endwith %}
					
					            var dynamicColors = function() {
					                var r = Math.floor(Math.random() * 255);
					                var g = Math.floor(Math.random() * 255);
					                var b = Math.floor(Math.random() * 255);
					                return `rgb(${r}, ${g}, ${b})`;
					             };
					
					            var colors = [];
					            for (let i = 0; i < labels.length; i++) {
					                colors.push(dynamicColors());
					            }
					
					            const data = {
					              labels: labels,
					              datasets: [{
					                label: 'Thống kê doanh thu theo mật độ sử dụng phòng',
					                data: info,
					                backgroundColor: colors,
					                hoverOffset: 4
					              }]
					            };
					
					            const config = {
					              type: 'pie',
					              data: data,
					            };
					
					            window.onload = function() {
					                let ctx = document.getElementById('usageChart').getContext('2d');
					                new Chart(ctx, config);
					            }
					        </script>
					    </div>
					</div>
				
				</div>
				
			</section>
		</div>
	</div>
</body>
</html>
		