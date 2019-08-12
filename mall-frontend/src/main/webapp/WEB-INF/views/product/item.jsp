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

    <script type="text/javascript">
        var oList=[];




        var optionLayer=0;
        var MAX_OP_LAYER=4;
        function optionChanged(opLayer) {

            //console.log(this.selected);
            var optionsDiv = document.getElementById("options__");
            //optionsDiv.appendChild("a")

            //num = new Array("2)첫번째목록","2)두번째목록","2)세번째목록");
            //vnum = new Array("1","2","3");
            //var newOption = document.createElement("option");
            //newOption.text = "Kiwi";
            //optionsDiv.add(newOption);
            //optionsDiv.options[0].text = "1";
            //optionsDiv.options[1].text="2";
            var curSelEl = document.getElementById("option_layer_"+opLayer);
            var selectedValue = curSelEl.options[curSelEl.selectedIndex].value;
            console.log(selectedValue);
            for(var i=opLayer+1;i<5;i++){
                var delEl = document.getElementById("option_layer_"+i);
                if(delEl)
                    delEl.remove();
            }

            var addSelTag = document.createElement("select");
            addSelTag.id = "option_layer_"+(opLayer+1);
            //addSelTag.onchange = "optionChanged("+(opLayer+1)+")";
            //addSelTag.id = "option_layer_"+(opLayer+1);

           //addSelTag.innerHTML = '<select id="option_layer_1" onchange="optionChanged(0)">';
            // "<input type='button' value='내역추가' onclick='addOptionDetail(\"" + count + "\")'>" +
            // "<input type='button' value='내역삭제' onclick='delOptionDetail(\"" + count + "\")'>"
            addSelTag.addEventListener("change", function(){
                optionChanged(opLayer+1);
            });
            optionsDiv.appendChild(addSelTag);

            var dummy1 = document.createElement("option");
            dummy1.text = '옵션선택';
            dummy1.value = -1;
            var dummy2 = document.createElement("option");
            dummy2.text = '------';
            dummy2.value = -1;
            document.getElementById(addSelTag.id).add(dummy1);
            document.getElementById(addSelTag.id).add(dummy2);

            var flag = false;
            oList.forEach(function (value, index) {
                if(value.parentOptionNum==selectedValue) {
                    //console.log(value, index);
                    var newOption = document.createElement("option");
                    newOption.text = value.optionDetail;
                    newOption.value = value.optionNumber;
                    document.getElementById(addSelTag.id).add(newOption);
                    flag = true;
                }
            });

            if(!flag){
                optionsDiv.removeChild(addSelTag);
            }


        }


        function setOptions() {
            <c:forEach items='${optionList}' var = "opt">

            oList.push( {
                optionNumber : ${opt.optionNumber},
                optionDetail : '${opt.optionDetail}',
                <c:if test="${not empty opt.parentOptionNumber}">
                parentOptionNum : ${opt.parentOptionNumber}
                </c:if>
            });
            </c:forEach>

            oList.forEach(function (value, index) {
                if(!value.parentOptionNum) {
                    console.log(value, index);
                    var newOption = document.createElement("option");
                    newOption.text = value.optionDetail;
                    newOption.value = value.optionNumber;
                    document.getElementById("option_layer_0").add(newOption);
                }
            });


        }
    </script>
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
            <div class="card h-100">
                <a href="${pageContext.servletContext.contextPath }/product/${productVo.productNumber}"><img
                        class="card-img-top"
                        src="${pageContext.servletContext.contextPath }/images/${productVo.productNumber}"
                        style=" height: 400px; width: 900px; object-fit: contain" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="${pageContext.servletContext.contextPath }/product/${productVo.productNumber}">${productVo.productName}</a>
                    </h4>
                    <h5>&#8361; ${productVo.productPrice}</h5>
                    <p class="card-text">${productVo.productTitle}</p>
                </div>
                <div id="options__" class="col-lg-6">
                    <select id="option_layer_0" onchange="optionChanged(0)">
                        <option value="-1">옵션선택</option>
                        <option value="-1">------</option>
                    </select>
                </div>
            </div>
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
