<%--
  Created by IntelliJ IDEA.
  User: bking
  Date: 2019-08-06
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-lg-3">
    <h1 class="my-4">PJMall</h1>
    <div class="list-group">
        <a href="${pageContext.servletContext.contextPath }/" class="list-group-item">상품</a>
        <a href="${pageContext.servletContext.contextPath }/basket" class="list-group-item">장바구니</a>
        <c:if test='${"ROLE_ADMIN" == userRole}'>
        <a href="${pageContext.servletContext.contextPath }/product/add" class="list-group-item">상품추가</a>
        </c:if>
    </div>
</div>
