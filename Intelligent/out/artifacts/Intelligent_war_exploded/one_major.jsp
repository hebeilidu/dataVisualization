<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>西安邮电大学_专业画像</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/echarts.min.js"></script>
    <script type="text/javascript" src="js/one_major.js"></script>
    <script type="text/javascript" src="js/jquery.liMarquee.js"></script>
    <script type="text/javascript" src="js/jquery.cxselect.min.js"></script>
    <script type="text/javascript" src="https://cdn.bootcdn.net/ajax/libs/lodash.js/4.17.15/lodash.js"></script>
    <link rel="stylesheet" href="css/comon0.css">
</head>
<body>
<div style="background:#000d4a url(images/bg.jpg) center top;">
    <div class="loading">
        <div class="loadbox"> <img src="images/loading.gif"> 页面加载中... </div>
    </div>
    <div class="back"></div>
    <div class="head">
        <div class="weather"><span id="showTime"></span></div>
        <h1><span id="major" style="color:rgba(14,253,255,1);"></span>专业——专业画像</h1>

    </div>
    <script>
        var t = null;
        t = setTimeout(time, 1000);/*開始运行*/
        function time() {
            clearTimeout(t);/*清除定时器*/
            dt = new Date();
            var y = dt.getFullYear();
            var mt = dt.getMonth() + 1;
            var day = dt.getDate();
            var h = dt.getHours();
            var m = dt.getMinutes();
            var s = dt.getSeconds();
            document.getElementById("showTime").innerHTML = y + "年" + mt + "月" + day + "日" + h + "时" + m + "分" + s + "秒";
            t = setTimeout(time, 1000);
        }

    </script>

    <div class="mainbox">
        <ul class="clearfix">
            <li>
                <div class="boxall" style="height:385px;">
                    <div class="alltitle">本专业教师情况</div>
                    <div class="navboxall" id="echart5"></div>
                </div>
                <div class="boxall" style="height:290px;">
                    <div class="alltitle">专任教师年龄结构</div>
                    <div class="navboxall" id="echart2"></div>
                </div>
                <div class="boxall" style="height:245px;">
                    <div class="alltitle">教学情况一览</div>
                    <div class="navboxall" id="echart1"></div>
                </div>
            </li>
            <li>
                <div class="boxall" style="height:230px">
                    <div class="clearfix navboxall" style="height: 100%">
                        <div class="alltitle">本专业基本情况</div>
                        <div class="pulll_left num">
                            <div class="numbt" >本科在校生总人数:<span id="ms1"></span></div>
                            <div class="numbt" >专业授课教师数:<span id="ms2" ></span></div>
                            <div class="numbt" >总学时数:<span id="ms3"></span></div>
                        </div>
                        <div class="pulll_right ">
                            <div class="numbt1">所属单位:<span id="ms4" style="font-size: 26px"></span></div>
                            <div class="numbt1">专业代码:<span id="ms5"></span></div>
                            <div class="numbt1">总学分数:<span id="ms6"></span></div>
                        </div>
                    </div>
                </div>
                <div class="boxall" style="height:350px">
                    <div class="alltitle">专业授课教师结构</div>
                    <div class="navboxall zc" id="echart4"></div>
                    <div class="navboxall xw" id="echart6"></div>
                </div>
                <div class="boxall" style="height:340px">
                    <div class="alltitle">本专业本科生招生情况</div>
                    <div class="navboxall zc" id= "echart3"></div>
                    <div class="navboxall xw" id= "echart11"></div>
                </div>
            </li>
            <li>
                <div class="boxall" style="height:300px">
                    <div class="alltitle">专业实验室使用情况</div>
                    <div class="navboxall" id="echart9">

                    </div>
                </div>

                <div class="boxall" style="height: 300px">
                    <div class="alltitle">专业实验教学情况</div>
                    <div class="navboxall" id="echart10">

                    </div>

                </div>

                <div class="boxall" style="height:320px">
                    <div class="alltitle">19级应届毕业生概览</div>
                    <div class="numbt">应届毕业生数：<span id="gn"></span></div>
                    <div class="navboxall zc" id="echart8"></div>
                    <div class="navboxall xw" id="echart7"></div>
                </div>


            </li>
        </ul>

    </div>
</div>

<script>
    $(function () {
        $('.wrap,.adduser').liMarquee({
            direction: 'up',/*身上滚动*/
            runshort: false,/*内容不足时不滚动*/
            scrollamount: 20/*速度*/
        });
    });

</script>

</body>
</html>



