<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" >
	<link rel="stylesheet" href="css/font-awesome.min.css">
</head>
<body>
<div class="container">
	<button class="btn btn-primary btn-sm mb-1 mt-1" ><i class="fa fa-plus"></i> 增加</button>
	<table class="table table-sm table-hover">
		<thead class="thead-dark">
		<tr>
			<th>工号</th><th>姓名</th><th>月薪</th><th>出生日期</th><th>操作</th>
		</tr>
		</thead>

		<tbody>
		<c:forEach items="${empList }" var="emp" >
			<tr>
				<td>${emp.e_id }</td>
				<td>${emp.e_name}</td>
				<td>${emp.e_sal}</td>
				<td>${emp.e_birth}</td>
				<td>
					<a href="#" class="btn btn-success btn-sm" >修改</a>
					<a href="#" class="btn btn-danger btn-sm">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>


	</table>
</div>

<script src="js/jquery-3.4.1.min.js" ></script>
<script src="js/popper.min.js" ></script>
<script src="js/bootstrap.min.js" ></script>
</body>
</html>



