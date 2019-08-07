<%--
  Created by IntelliJ IDEA.
  User: bking
  Date: 2019-08-06
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <style>
        .horizon-div{
            float: left;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>폼 추가/삭제 예제</title>

    <script type="text/javascript">

        var count = 0;


        function addForm() {

            var addedFormDiv = document.getElementById("addedFormDiv");


            var str = "";

            str += "<br>값1-" + count + " <input type='text' name='tb1_" + count + "'>";

            str += "<br>값2-" + count + " <input type='text' name='tb2_" + count + "'>";

            str += "<br>값3-" + count + " <input type='text' name='tb3_" + count + "'><BR>";

            // 추가할 폼(에 들어갈 HTML)


            var addedDiv = document.createElement("div"); // 폼 생성

            addedDiv.id = "added_" + count; // 폼 Div에 ID 부여 (삭제를 위해)

            addedDiv.innerHTML = str; // 폼 Div안에 HTML삽입

            addedFormDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입


            count++;

            document.baseForm.count.value = count;

            // 다음 페이지에 몇개의 폼을 넘기는지 전달하기 위해 히든 폼에 카운트 저장

        }


        function delForm() {

            var addedFormDiv = document.getElementById("addedFormDiv");


            if (count > 1) { // 현재 폼이 두개 이상이면

                var addedDiv = document.getElementById("added_" + (--count));

                // 마지막으로 생성된 폼의 ID를 통해 Div객체를 가져옴

                addedFormDiv.removeChild(addedDiv); // 폼 삭제

            } else { // 마지막 폼만 남아있다면

                document.baseForm.reset(); // 폼 내용 삭제

            }

        }

        function delForm2() {

            var addedFormDiv2 = document.getElementById("addedFormDiv2");


            if (count > 1) { // 현재 폼이 두개 이상이면

                var addedDiv = document.getElementById("added_" + (--count));

                // 마지막으로 생성된 폼의 ID를 통해 Div객체를 가져옴

                addedFormDiv2.removeChild(addedDiv); // 폼 삭제

            } else { // 마지막 폼만 남아있다면

                document.baseForm.reset(); // 폼 내용 삭제

            }

        }

        function addForm2() {
            var addedFormDiv2 = document.getElementById("addedFormDiv2");

            var addedDiv = document.createElement("div");

            addedDiv.id = "added_" + count; // 폼 Div에 ID 부여 (삭제를 위해)
            addedDiv.className = 'horizon-div';
            //addedDiv.innerHTML = "<input type='text' value='"+count+"'>";
            var strstr = addedDiv.id;
            addedDiv.innerHTML = "<input type='button' value='옵션추가' onclick='addForm3(\""+addedDiv.id + "\")'>";
            //addedFormDiv2.innerText += "<input type='text' id='"+count+"'>  ";
            addedFormDiv2.appendChild(addedDiv);
            //addedFormDiv2.innerHTML += "<input type='text' id='"+count+"'>  ";
            count++;
            console.log("---");

        }

        function addForm3(divid) {
            console.log(divid);
            var addedFormDiv2 = document.getElementById(divid);

            var addedDiv = document.createElement("div");

            addedDiv.id = "addeded_" + count; // 폼 Div에 ID 부여 (삭제를 위해)
            //addedDiv.className = 'horizon-div';
            addedDiv.innerHTML = "<input type='text' value='"+count+"'>";


            //addedFormDiv2.innerText += "<input type='text' id='"+count+"'>  ";
            addedFormDiv2.appendChild(addedDiv);
            //addedFormDiv2.innerHTML += "<input type='text' id='"+count+"'>  ";
          //  count++;
            console.log("---");

        }
    </script>

</head>

<body onload="">

<div>
    <form name="baseForm" action="" method="post">

        <input type="hidden" name="count" value="0">

        <div id="addedFormDiv"></div>
        <BR> <!-- 폼을 삽입할 DIV -->

        <input type="Button" value="추가" onclick="addForm()">

        <input type="Button" value="삭제" onclick="delForm()">

        <input type="Submit" value="완료">

    </form>

    <form>

        <input type="button" value="삭제" onclick="delForm2()">
        <div id="addedFormDiv2"><input type="button" value="test" onclick="addForm2()"></div>
    </form>
</div>


</body>

</html>
