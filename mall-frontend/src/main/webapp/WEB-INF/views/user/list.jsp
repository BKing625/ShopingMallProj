<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Shop Homepage - Start Bootstrap Template</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.servletContext.contextPath }/assets/css/shop-homepage.css" rel="stylesheet">

</head>
<body onload="setOptions()">
<!-- Navigation -->
<c:import url='/WEB-INF/views/includes/navigation.jsp'>
    <c:param name="active" value="shopping"/>
</c:import>
<!-- /.Navigation -->

<div class="container">
    <div class="row">
        <c:import url='/WEB-INF/views/includes/menubar.jsp'/>



        <div class="col-lg-9">
            상세보기 : 화살표 클릭
<c:forEach items='${userList}' var='userInfo' varStatus='status'>
            <details>
                <summary> <a> 회원번호 : ${userInfo.userNumber}, ID : ${userInfo.userId} </a> </summary>
                    이름 : ${userInfo.userName}, 가입일 : ${userInfo.userJoinDate}, 성별 : ${userInfo.userGender},
                <br>키 : ${userInfo.userTall}, 생일 : ${userInfo.userBirth}, 우편번호 : ${userInfo.userPostNumber}, 주소 : ${userInfo.userAddr},
                <br>전화번호 : ${userInfo.userPhone}
                <br><br>
            </details>
</c:forEach>
        </div>
        <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->
</div>
<!-- /.container -->

<!-- Footer -->
<c:import url='/WEB-INF/views/includes/footer.jsp'/>
<!-- /.Footer -->
</body>

</html>
