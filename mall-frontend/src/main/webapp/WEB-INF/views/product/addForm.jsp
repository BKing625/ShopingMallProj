<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Shop Homepage - Start Bootstrap Template</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.servletContext.contextPath }/assets/css/shop-login.css" rel="stylesheet">
    <style>
        .horizon-div {
            float: left;
        }
    </style>
    <script type="text/javascript">
        var count = 0;
        var detailCount = [0, 0, 0, 0];

        var MAX_DETAILS_NUM = 10;

        function addSubOption() {
            if (count > 3) return;
            var addedFormDiv = document.getElementById("options");

            // 추가할 폼(에 들어갈 HTML)
            var addedDiv = document.createElement("div"); // 폼 생성

            addedDiv.id = "option_" + count; // 폼 Div에 ID 부여 (삭제를 위해)
            addedDiv.className = 'horizon-div';
            addedDiv.innerHTML = "<input type='button' value='내역추가' onclick='addOptionDetail(\"" + count + "\")'>" +
                "<input type='button' value='내역삭제' onclick='delOptionDetail(\"" + count + "\")'>"; // 폼 Div안에 HTML삽입

            addedFormDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입

            addOptionDetail(count);
            count++;

            document.productForm.option_cnt.value = count;
            // 다음 페이지에 몇개의 폼을 넘기는지 전달하기 위해 히든 폼에 카운트 저장
        }

        function delSubOption() {

            var addedFormDiv = document.getElementById("options");

            if (count > 1) { // 현재 폼이 두개 이상이면
                var addedDiv = document.getElementById("option_" + (--count));
                // 마지막으로 생성된 폼의 ID를 통해 Div객체를 가져옴
                addedFormDiv.removeChild(addedDiv); // 폼 삭제

            } else { // 마지막 폼만 남아있다면
                document.productForm.reset(); // 폼 내용 삭제
            }

            document.productForm.option_cnt.value = count;
        }

        function addOptionDetail(optionNum) {
            if (detailCount[optionNum] > MAX_DETAILS_NUM) return;
            var addedFormDiv = document.getElementById("option_" + optionNum);

            // 추가할 폼(에 들어갈 HTML)
            var addedDiv = document.createElement("div"); // 폼 생성

            addedDiv.id = "option_" + optionNum + "_" + detailCount[optionNum]; // 폼 Div에 ID 부여 (삭제를 위해)
            addedDiv.innerHTML = "<input name = 'optionDetail_" + optionNum + "[" + detailCount[optionNum] + "]' type='text'>";

            addedFormDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입

            detailCount[optionNum]++;
            //count++;

            //document.productForm.count.value = count;
            // 다음 페이지에 몇개의 폼을 넘기는지 전달하기 위해 히든 폼에 카운트 저장
        }

        function delOptionDetail(optionNum) {
            if (detailCount[optionNum] <= 1) return;
            var addedFormDiv = document.getElementById("option_" + optionNum);

            var addedDiv = document.getElementById("option_" + optionNum + "_" + (--detailCount[optionNum]));
            // 마지막으로 생성된 폼의 ID를 통해 Div객체를 가져옴
            addedFormDiv.removeChild(addedDiv); // 폼 삭제
        }

    </script>

    <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#imgInp").on('change', function () {
                readURL(this);
            });
        });

        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#imageView').attr('src', e.target.result);
                };

                reader.readAsDataURL(input.files[0]);
            }
        }
    </script>


</head>
<body onload="addSubOption()">
<!-- Navigation -->
<c:import url='/WEB-INF/views/includes/navigation.jsp'>
    <c:param name="active" value="join"/>
</c:import>
<!-- /.Navigation -->

<div class="container">
    <div class="row">
        <c:import url='/WEB-INF/views/includes/menubar.jsp'/>
        <!-- 파일을 전송하기 위한 enctype -->
        <%--    enctype="multipart/form-data"--%>
        <div class="col-lg-9">
            <form name="productForm" action="${pageContext.servletContext.contextPath}/product/add" method="post"
                  enctype="multipart/form-data">
                <input type="hidden" name="option_cnt" value="0">
                <table style="width: 80%">

                    <tr>

                        <th colspan="2">** 상품 등록 **</th>

                    </tr>

                    <tr>

                        <td style="width:20%">상품명</td>

                        <td><input type="text" name="name"></td>

                    </tr>

                    <tr>

                        <td>가격</td>

                        <td><input type="number" name="price"></td>

                    </tr>

                    <tr>

                        <td>설 명</td>

                        <td><textarea name="detail" rows="3" cols="30"></textarea></td>

                    </tr>

                    <tr>

                        <td>옵션</td>

                        <td><input type="button" value="옵션추가" onclick="addSubOption()"><input type="button" value="옵션삭제"
                                                                                              onclick="delSubOption()">
                            <div id="options"></div>
                        </td>

                    </tr>

                    <tr>

                        <td>이미지</td>

                        <td>

                            <img id="imageView" src="../images/product/noimage.jpg"
                                 style="max-width: 30%; height: auto;"
                                 alt="상품이미지"><br/>

                            <%--                    <input id="imgInput" type="file" name="imgInput" size="30" onchange="fileChanged()">--%>

                            <input type='file' id="imgInp" name="imgInput" size="30"/>

                            <%--                    <img id="blah" src="#" alt="your image" />--%>

                        </td>

                    </tr>

                    <tr>

                        <td colspan="2">

                            <br/>

                            <input type="submit" value="상품 등록">

                        </td>

                    </tr>

                </table>

            </form>
        </div>
    </div>
    <!-- /.card-container -->
</div>
<!-- /.container -->

<!-- Footer -->
<c:import url='/WEB-INF/views/includes/footer.jsp'/>
<!-- /.Footer -->
</body>
</html>