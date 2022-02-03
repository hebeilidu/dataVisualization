<%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/11/15
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>西安邮电大学</title>
    <link rel="stylesheet" type="text/css" href="css/top.css">
</head>
<body>
<div class="top" id="myDIV">
    <img src="images/xupt1.png" width="100" height="100" />
    <p>西安邮电大学教育教学大数据治理平台</p>
    <div class="top_righttop">
        <p>欢迎您：XXX</p>
    </div>
    <div class="top_rightbottom">
        <img src="images/zhuxiao.png" title="注销">
    </div>
    <div id="datetime">
        <script>
            setInterval("document.getElementById('datetime').innerHTML=new Date().toLocaleString();", 1000);
        </script>
    </div>
</div>
</body>
</html>
