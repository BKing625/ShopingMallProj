<%--
  Created by IntelliJ IDEA.
  User: bking
  Date: 2019-08-06
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>

<%--<head>--%>
<%--    <style>--%>
<%--        .horizon-div{--%>
<%--            float: left;--%>
<%--        }--%>
<%--    </style>--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

<%--    <title>폼 추가/삭제 예제</title>--%>

<%--    <script type="text/javascript">--%>

<%--        var count = 0;--%>


<%--        function addForm() {--%>

<%--            var addedFormDiv = document.getElementById("addedFormDiv");--%>


<%--            var str = "";--%>

<%--            str += "<br>값1-" + count + " <input type='text' name='tb1_" + count + "'>";--%>

<%--            str += "<br>값2-" + count + " <input type='text' name='tb2_" + count + "'>";--%>

<%--            str += "<br>값3-" + count + " <input type='text' name='tb3_" + count + "'><BR>";--%>

<%--            // 추가할 폼(에 들어갈 HTML)--%>


<%--            var addedDiv = document.createElement("div"); // 폼 생성--%>

<%--            addedDiv.id = "added_" + count; // 폼 Div에 ID 부여 (삭제를 위해)--%>

<%--            addedDiv.innerHTML = str; // 폼 Div안에 HTML삽입--%>

<%--            addedFormDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입--%>


<%--            count++;--%>

<%--            document.baseForm.count.value = count;--%>

<%--            // 다음 페이지에 몇개의 폼을 넘기는지 전달하기 위해 히든 폼에 카운트 저장--%>

<%--        }--%>


<%--        function delForm() {--%>

<%--            var addedFormDiv = document.getElementById("addedFormDiv");--%>


<%--            if (count > 1) { // 현재 폼이 두개 이상이면--%>

<%--                var addedDiv = document.getElementById("added_" + (--count));--%>

<%--                // 마지막으로 생성된 폼의 ID를 통해 Div객체를 가져옴--%>

<%--                addedFormDiv.removeChild(addedDiv); // 폼 삭제--%>

<%--            } else { // 마지막 폼만 남아있다면--%>

<%--                document.baseForm.reset(); // 폼 내용 삭제--%>

<%--            }--%>

<%--        }--%>

<%--        function delForm2() {--%>

<%--            var addedFormDiv2 = document.getElementById("addedFormDiv2");--%>


<%--            if (count > 1) { // 현재 폼이 두개 이상이면--%>

<%--                var addedDiv = document.getElementById("added_" + (--count));--%>

<%--                // 마지막으로 생성된 폼의 ID를 통해 Div객체를 가져옴--%>

<%--                addedFormDiv2.removeChild(addedDiv); // 폼 삭제--%>

<%--            } else { // 마지막 폼만 남아있다면--%>

<%--                document.baseForm.reset(); // 폼 내용 삭제--%>

<%--            }--%>

<%--        }--%>

<%--        function addForm2() {--%>
<%--            var addedFormDiv2 = document.getElementById("addedFormDiv2");--%>

<%--            var addedDiv = document.createElement("div");--%>

<%--            addedDiv.id = "added_" + count; // 폼 Div에 ID 부여 (삭제를 위해)--%>
<%--            addedDiv.className = 'horizon-div';--%>
<%--            //addedDiv.innerHTML = "<input type='text' value='"+count+"'>";--%>
<%--            var strstr = addedDiv.id;--%>
<%--            addedDiv.innerHTML = "<input type='button' value='옵션추가' onclick='addForm3(\""+addedDiv.id + "\")'>";--%>
<%--            //addedFormDiv2.innerText += "<input type='text' id='"+count+"'>  ";--%>
<%--            addedFormDiv2.appendChild(addedDiv);--%>
<%--            //addedFormDiv2.innerHTML += "<input type='text' id='"+count+"'>  ";--%>
<%--            count++;--%>
<%--            console.log("---");--%>

<%--        }--%>

<%--        function addForm3(divid) {--%>
<%--            console.log(divid);--%>
<%--            var addedFormDiv2 = document.getElementById(divid);--%>

<%--            var addedDiv = document.createElement("div");--%>

<%--            addedDiv.id = "addeded_" + count; // 폼 Div에 ID 부여 (삭제를 위해)--%>
<%--            //addedDiv.className = 'horizon-div';--%>
<%--            addedDiv.innerHTML = "<input type='text' value='"+count+"'>";--%>


<%--            //addedFormDiv2.innerText += "<input type='text' id='"+count+"'>  ";--%>
<%--            addedFormDiv2.appendChild(addedDiv);--%>
<%--            //addedFormDiv2.innerHTML += "<input type='text' id='"+count+"'>  ";--%>
<%--          //  count++;--%>
<%--            console.log("---");--%>

<%--        }--%>
<%--    </script>--%>

<%--</head>--%>

<%--<body onload="">--%>

<%--<div>--%>
<%--    <form name="baseForm" action="" method="post">--%>

<%--        <input type="hidden" name="count" value="0">--%>

<%--        <div id="addedFormDiv"></div>--%>
<%--        <BR> <!-- 폼을 삽입할 DIV -->--%>

<%--        <input type="Button" value="추가" onclick="addForm()">--%>

<%--        <input type="Button" value="삭제" onclick="delForm()">--%>

<%--        <input type="Submit" value="완료">--%>

<%--    </form>--%>

<%--    <form>--%>

<%--        <input type="button" value="삭제" onclick="delForm2()">--%>
<%--        <div id="addedFormDiv2"><input type="button" value="test" onclick="addForm2()"></div>--%>
<%--    </form>--%>
<%--</div>--%>


<%--</body>--%>

<%--</html>--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Shop Homepage - Start Bootstrap Template</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.servletContext.contextPath }/assets/css/shop-item.css" rel="stylesheet">
</head>

<body>
<!-- Navigation -->
<c:import url='/WEB-INF/views/includes/navigation.jsp'>
    <c:param name="active" value="shopping" />
</c:import>
<!-- /.Navigation -->

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-3">
            <h1 class="my-4">Shop Name</h1>
            <div class="list-group">
                <a href="#" class="list-group-item active">Category 1</a>
                <a href="#" class="list-group-item">Category 2</a>
                <a href="#" class="list-group-item">Category 3</a>
            </div>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

            <div class="card mt-4">
                <img class="card-img-top img-fluid"
                     src="http://placehold.it/900x400" alt="">
                <div class="card-body">
                    <h3 class="card-title">Product Name</h3>
                    <h4>$24.99</h4>
                    <p class="card-text">
                        Lorem ipsum dolor sit amet, consectetur
                        adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque
                        facere, soluta. Totam id dolores, sint aperiam sequi pariatur
                        praesentium animi perspiciatis molestias iure, ducimus!
                    </p>
                    <span class="text-warning">&#9733; &#9733; &#9733; &#9733;
							&#9734;</span> 4.0 stars
                </div>
            </div>
            <!-- /.card -->

            <div class="card card-outline-secondary my-4">
                <div class="card-header">Product Reviews</div>
                <div class="card-body">
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                        Omnis et enim aperiam inventore, similique necessitatibus neque
                        non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
                        Sequi mollitia, necessitatibus quae sint natus.
                    </p>
                    <small class="text-muted">Posted by Anonymous on 3/1/17</small>
                    <hr>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                        Omnis et enim aperiam inventore, similique necessitatibus neque
                        non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
                        Sequi mollitia, necessitatibus quae sint natus.
                    </p>
                    <small class="text-muted">Posted by Anonymous on 3/1/17</small>
                    <hr>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                        Omnis et enim aperiam inventore, similique necessitatibus neque
                        non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
                        Sequi mollitia, necessitatibus quae sint natus.
                    </p>
                    <small class="text-muted">Posted by Anonymous on 3/1/17</small>
                    <hr>
                    <a href="#" class="btn btn-success">Leave a Review</a>
                </div>
            </div>
            <!-- /.card -->

        </div>
        <!-- /.col-lg-9 -->

    </div>

</div>
<!-- /.container -->

<!-- Footer -->
<c:import url='/WEB-INF/views/includes/footer.jsp' />
<!-- /.Footer -->
</body>

</html>

