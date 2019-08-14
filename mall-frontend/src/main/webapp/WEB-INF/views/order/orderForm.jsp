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
            <form method="post" action="${pageContext.servletContext.contextPath}/order">
                <c:forEach items='${productList}' var='vo' varStatus='status'>
                    상품번호 <input readonly type = "text" value="${vo.productNumber}"> ,
                    옵션 <input readonly type = "text" value="${vo.optionStr}"> ,
                    수량 <input readonly type = "text" name = "goodsList[${status.index}].orderDetailsCount" value="${vo.count}">
                    가격 <input readonly type = "text" value="${vo.productPrice}">
                    <input readonly type = "hidden" name = "goodsList[${status.index}].optionNumber" value="${vo.optionNumber}">



                    <br>
                    <c:set var = 'priceSum' value = '${priceSum + (vo.productPrice*vo.count)}'/>
                </c:forEach>
                <br> 총 가격 : ${priceSum} <br><br>
                <input type="hidden" name = "userNumber" value="${authUserInfo.userNumber}"> <br>
                받는사람이름 : <input type="text" name = "ordererName" value="${authUserInfo.userName}"> <br>
                우편번호 : <input type="text" name = "orderPostNumber" value="${authUserInfo.userPostNumber}"> <br>
                주소 : <input type="text" name = "orderAddr" value="${authUserInfo.userAddr}"> <br>
                전화번호 : <input type="text" name = "ordererPhone" value="${authUserInfo.userPhone}"> <br>
                메시지 : <input type="text" name = "orderMessage" value=""> <br>
                <c:if test="${not empty productList}">
                    <br><input type="submit" value="주문">
                </c:if>
            </form>
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
