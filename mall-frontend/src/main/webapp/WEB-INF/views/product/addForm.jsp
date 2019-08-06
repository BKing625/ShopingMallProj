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
    <link href="${pageContext.servletContext.contextPath }/assets/css/shop-login.css" rel="stylesheet">


    <script type="text/javascript">
        function validateForm() {
            //$(".has-error").removeClass("has-error");
            if (isEmpty(document.getElementById('userName').value.trim())) {
                alert('이름을 입력해주세요');
               // document.getElementById('userName').parentNode.className += " has-error";
                return false;
            }
            if (isEmpty(document.getElementById('userId').value.trim())) {
                alert('아이디를 입력해 주세요');
                //document.getElementById('${idForError}').parentNode.className += " has-error";
                return false;
            }
            <%--if (!validateEmail(document.getElementById('userId').value.trim())) {--%>
            <%--    alert('아이디는 이메일 양식으로 입력해 주세요');--%>
            <%--    //document.getElementById('${idForError}').parentNode.className += " has-error";--%>
            <%--    return false;--%>
            <%--}--%>
            if (isEmpty(document.getElementById('userPassword').value.trim())) {
                alert('비밀번호를 입력해주세요');
                document.getElementById('userPassword').parentNode.className += " has-error";
                return false;
            }

            return true;
        }

        function isEmpty(str) {
            return (str.length === 0 || !str.trim());
        }

        function validateEmail(email) {
            var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,15}(?:\.[a-z]{2})?)$/i;
            console.log(re.test(email));
            return re.test(email);
        }
    </script>
</head>
<body>
<!-- Navigation -->
<c:import url='/WEB-INF/views/includes/navigation.jsp'>
    <c:param name="active" value="join"/>
</c:import>
<!-- /.Navigation -->

<div class="container">

    <!-- 파일을 전송하기 위한 enctype -->

    <form name="productFrm" action="product_process.jsp?flag=insert" enctype="multipart/form-data" method="post">

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

                <td><input type="text" name="price"></td>

            </tr>

            <tr>

                <td>설 명</td>

                <td><textarea name="detail" rows="3" cols="30"></textarea></td>

            </tr>

            <tr>

                <td>재고량</td>

                <td><input type="text" name="stock"></td>

            </tr>

            <tr>

                <td>이미지</td>

                <td>

                    <img name="preview" src="../images/product/noimage.jpg" style="width:100%"><br/>

                    <input type="file" name="image" size="30" onchange="filePreview()">

                </td>

            </tr>

            <tr>

                <td colspan="2">

                    <br/>

                    <input type="submit" value="상품 등록">

                    <input type="reset" value="새로 입력" onclick="resetInsertData()">

                </td>

            </tr>

        </table>

    </form>




    <!-- /.card-container -->
</div>
<!-- /.container -->

<!-- Footer -->
<c:import url='/WEB-INF/views/includes/footer.jsp'/>
<!-- /.Footer -->
</body>
</html>