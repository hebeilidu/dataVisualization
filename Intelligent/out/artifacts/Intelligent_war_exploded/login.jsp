<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>教育教学大数据治理系统_登录界面</title>
    <link href="css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
    <link href="css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="js/jquery_min.js"></script>
    <script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
</head>

<body>


<div class="header">
    <%--<h1 class="headerLogo"><a title="教育教学大数据治理系统" target="_blank" href="http://www.xiyou.edu.cn/index.htm"><img alt="logo" src="images/logo.gif"></a></h1>--%>
    <div style="text-align: center"><h1>基于深度学习的高校学生画像系统</h1></div>
    <div class="headerNav">

    </div>
</div>

<div class="banner">

    <div class="login-aside">
        <div id="o-box-up"></div>
        <div id="o-box-down"  style="table-layout:fixed;">

            <form id="login-form" class="registerform" action="LoginServlet" method="post">
                <div class="fm-item">
                    <label class="form-label">登录账号</label>
                    <input type="text" placeholder="请输入您的账号" maxlength="100" id="username" name="username" class="i-text" datatype="s6-18" errormsg="用户名至少6个字符,最多18个字符！"  >
                    <div class="ui-form-explain"></div>
                </div>

                <div class="fm-item">
                    <label class="form-label">登录密码：</label>
                    <input type="password" placeholder="请输入您的密码" maxlength="100" id="password" name="password" class="i-text" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！">
                    <div class="ui-form-explain"></div>
                </div>

                <div class="fm-item">
                    <label class="form-label">验证码</label>
                    <div style="height: 30px;">
                    <input type="text" name="verifycode"  id="verifycode" maxlength="100" autocomplete="off" class="yzm" placeholder="验证码" required/>
                    <img  src="CheckCodeServlet" id="checkCode">
                    </div>
                    <div id="check" class="error" style="visibility: hidden;color: red">*请输入正确的验证码</div>
                </div>
                &nbsp &nbsp
                <div class="fm-item">
                    <label class="form-label"></label>
                    <input type="button" onclick="checkIdentify();" tabindex="4" id="send-btn" class="btn-login">
                    <div class="ui-form-explain"></div>
                </div>

            </form>

        </div>

    </div>

    <div class="bd">
        <ul>
            <li style="background:url(themes/theme-pic1.jpg) #CCE1F3 center 0 no-repeat;"><a target="_blank" href="http://www.xiyou.edu.cn/index.htm"></a></li>
            <li style="background:url(themes/theme-pic2.jpg) #BCE0FF center 0 no-repeat;"><a target="_blank" href="http://www.xiyou.edu.cn/index.htm"></a></li>
        </ul>
    </div>

    <div class="hd"><ul></ul></div>
</div>
<script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });</script>
<script type="text/javascript">
    window.onload=function () {   //页面加载完后，才能进行操作
        var img=document.getElementById("checkCode");
        img.onclick=function () {
            //加时间戳
            var date=new Date().getTime();
            img.src="CheckCodeServlet?"+date;
        }
    }
</script>
<script>
    function checkIdentify() {
        var verifycode = $('#verifycode').val();
        var btn = $('#login_button');
        var form = $('#login-form');
        $.ajax({
            url: 'CheckServlet?verifycode='+verifycode,
            type: 'POST',
            data:{
            },
            success: function (result) {
                if(result == "true"){
                    $("#check").css("visibility","hidden");
                    form.submit();
                }else {
                    $("#check").css("visibility","visible");

                    var img=document.getElementById("checkCode");
                    var date=new Date().getTime();
                    img.src="CheckCodeServlet?"+date;
                }
            }
        });

    }
</script>
<script>
    var loginInfo = '<%= request.getAttribute("loginInfo")%>';
    if(!loginInfo.includes(null))
    {
        alert(loginInfo);
    }else{
    }
</script>

<div class="banner-shadow"></div>

<div class="footer">
    <p>Copyright@2020 西安邮电大学 教务处 版权所有</p>
</div>

</body>
</html>
