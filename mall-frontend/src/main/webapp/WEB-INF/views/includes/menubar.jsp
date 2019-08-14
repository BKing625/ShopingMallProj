<%--
  Created by IntelliJ IDEA.
  User: bking
  Date: 2019-08-06
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var menuCount = 4;

   function menuStatusChange(idNum){
       for(var i = 0; i<menuCount;i++){
            var element = document.getElementById("menu_"+i);
            element.classList.remove("active");
       }

       document.getElementById("menu_"+idNum).classList.add("active");

   }

</script>

<div class="col-lg-3">
    <h1 class="my-4">PJMall</h1>
    <div class="list-group">
        <a id = "menu_0" href="${pageContext.servletContext.contextPath }/" class="list-group-item"  onclick="menuStatusChange(0)">상품</a>
        <a id = "menu_1" href="${pageContext.servletContext.contextPath }/bucket" class="list-group-item" onclick="menuStatusChange(1)">장바구니</a>
        <c:if test="${'ROLE_USER'==userRole}">
            <a id = "menu_4" href="${pageContext.servletContext.contextPath }/order/list/1" class="list-group-item"  onclick="menuStatusChange(2)">주문목록</a>
        </c:if>
        <c:if test='${"ROLE_ADMIN" == userRole}'>
            <a id = "menu_2" href="${pageContext.servletContext.contextPath }/product/add" class="list-group-item"  onclick="menuStatusChange(2)">상품추가</a>
            <a id = "menu_3" href="${pageContext.servletContext.contextPath }/user/list" class="list-group-item"  onclick="menuStatusChange(3)">유저정보</a>
        </c:if>
    </div>

</div>
