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
            <form method="post" action="${pageContext.servletContext.contextPath}/order/pre">
            <c:forEach items='${bucketList}' var='vo' varStatus='status'>
                상품번호 <input readonly type = "text" name="productSimpleViewDtoList[${status.index}].productNumber" value="${vo.productNumber}"> ,
                옵션 <input readonly type = "text" name="productSimpleViewDtoList[${status.index}].optionStr" value="${vo.optionStr}"> ,
                수량 <input readonly type = "text" name = "productSimpleViewDtoList[${status.index}].count" value="${vo.count}">
                가격 <input readonly type = "text" name = "productSimpleViewDtoList[${status.index}].productPrice" value="${vo.productPrice}">
                <input readonly type = "hidden" name = "productSimpleViewDtoList[${status.index}].optionNumber" value="${vo.optionNumber}">
               <a href = "${pageContext.servletContext.contextPath}/bucket/delete/${vo.bucketNumber}">삭제</a> <br> <br> <br>
                <c:set var = 'priceSum' value = '${priceSum + (vo.productPrice*vo.count)}'/>
            </c:forEach>
                <c:if test="${not empty bucketList}">
                <br> 가격 : ${priceSum} <input type="submit" value="주문">
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
