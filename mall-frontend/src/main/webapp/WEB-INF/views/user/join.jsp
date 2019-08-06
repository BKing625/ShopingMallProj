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

    <%--        <p id="profile-name" class="profile-name-card"></p>--%>
    <form method="post" action="${pageContext.servletContext.contextPath}/user/join" class="form-signin"
          name="joinForm" onsubmit="return validateForm();">
        <div>이름<span style="color: red;"> *</span><br/>
            <input type="text" id="userName" name="userName" class="form-control"/></div>

        <div>아이디(Email)<span style="color: red;"> *</span><br/>
            <input type="email" id="userId" name="userId" class="form-control"/></div>

        <div>비밀번호<span style="color: red;"> *</span><br/>
            <input type="password" id="userPassword" name="userPassword" class="form-control"/></div>

        <div>성별<br/>
            <fieldset class="form-control">
                <label>남</label><input type="radio" name="userGender" value="MALE">
                <label>여</label><input type="radio" name="userGender" value="FEMALE"></fieldset>
        </div>

        <div>키<br/>
            <input type="number" id="userTall" name="userTall" class="form-control"/></div>
        <div>생일<br/>
            <input type="date" id="userBirth" name="userBirth" class="form-control" /></div>
        <div>우편번호<br/>
            <input type="text" id="userPostNumber" name="userPostNumber" class="form-control"/></div>

        <div>주소<br/>
            <input type="text" id="userAddr" name="userAddr" class="form-control"/></div>

        <div>전화번호<br/>
            <input type="tel" id="userPhone" name="userPhone" class="form-control"/></div>
        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">가입</button>
    </form><!-- /form -->

    <!-- /.card-container -->
</div>
<!-- /.container -->

<!-- Footer -->
<c:import url='/WEB-INF/views/includes/footer.jsp'/>
<!-- /.Footer -->
</body>
</html>