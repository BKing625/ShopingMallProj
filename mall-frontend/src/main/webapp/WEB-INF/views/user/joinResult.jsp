<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>BK mall</title>
	<!-- Bootstrap core CSS -->
	<link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="${pageContext.servletContext.contextPath }/assets/css/shop-login.css" rel="stylesheet">
</head>
<body>
<!-- Navigation -->
<c:import url='/WEB-INF/views/includes/navigation.jsp'>
	<c:param name="active" value="join" />
</c:import>
	<div id="container">

		<div id="content">
			<div id="user">
				<p class="jr-success">
					${message}
					<br><br>
						<c:if test='${result == true}'>
					<a href="${pageContext.servletContext.contextPath }/user/login">로그인하기</a>
						</c:if>
						<c:if test='${result == false}'>
							<a href="${pageContext.servletContext.contextPath }/">메인화면으루!</a>
						</c:if>
				</p>
			</div>
		</div>

		<c:import url='/WEB-INF/views/includes/footer.jsp'/>
	</div>
</body>
</html>