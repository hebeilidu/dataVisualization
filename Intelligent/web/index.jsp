<%--
  Created by IntelliJ IDEA.
  User: 10034
  Date: 2020/10/23
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<head>
    <title>西安邮电大学</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<jsp:include   page="top.jsp" flush="true"/>
<div class="main">
    <div class="box">
        <img src="images/main1.png">
        <p><a href="main.jsp">学校画像</a></p>
    </div>
    <div class="box">
        <img src="images/main2.png">
        <p><a href="selectmajor.jsp">专业画像</a></p>
    </div>

</div>
<jsp:include   page="foot.jsp" flush="true"/>
</body>
</html>
