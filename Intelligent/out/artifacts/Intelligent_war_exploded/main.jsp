<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <html>
    <head>
        <meta charset="utf-8">
        <meta name="description" content="">
        <meta name="keywords" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <title>西安邮电大学专业画像</title>
        <link type="text/css" href="css/public.css" rel="stylesheet">
        <link type="text/css" href="css/icon.css" rel="stylesheet">
        <link type="text/css" href="css/index1.css" rel="stylesheet">
        <script src="http://cdn.staticfile.org/jquery/2.1.4/jquery.min.js"></script>
        <script type="text/javascript">
            document.documentElement.style.fontSize = document.documentElement.clientWidth /768*100 + 'px';
        </script>
        <script src="js/echarts.min.js"></script>
    </head>
    <style>
        .abc{

        }
    </style>

<body>
<div class="bg">
    <div class="title">学校画像</div>
    <div class="leftMain">
        <div class="leftMain_top">
            <div class="leftMain_topIn">
                <ul>
                    <li>
                        <div class="liIn">
                            <h3>专业授课教师总数</h3>
                            <p class="shu"><span class="shu1" id="ps11"></span><i><font size="2">人</font></i></p>
                            <div class="zi"><span class="span1"><font size="2">本校：<span id="ps12"></span>人</font></span><span><font size="2">外校：<span id="ps13"></span>人</font></span></div>
                            <span class="border_bg_leftTop"></span>
                            <span class="border_bg_rightTop"></span>
                            <span class="border_bg_leftBottom"></span>
                            <span class="border_bg_rightBottom"></span>
                        </div>
                    </li>
                    <li>
                        <div class="liIn">
                            <h3>专业专任教师总数</h3>
                            <p class="shu"><span class="shu2" id="ps21"></span><i><font size="2">人</font></i></p>
                            <div class="zi"><span class="span1"><font size="2">本校：<span id="ps22"></span>人</font></span><span><font size="2">外校：<span id="ps23"></span>人</font></span></div>
                            <span class="border_bg_leftTop"></span>
                            <span class="border_bg_rightTop"></span>
                            <span class="border_bg_leftBottom"></span>
                            <span class="border_bg_rightBottom"></span>
                        </div>
                    </li>
                    <li>
                        <div class="liIn">
                            <h3>各专业实验系列职称人员总数</h3>
                            <p class="shu"><span class="shu3" id="ps31"></span><i><font size="2">人</font></i></p>
                            <div class="zi"><span class="span1"><font size="2">有职称：<span id="ps32"></span>人</font></span><span><font size="2">无职称：<span id="ps33"></span>人</font></span></div>
                            <span class="border_bg_leftTop"></span>
                            <span class="border_bg_rightTop"></span>
                            <span class="border_bg_leftBottom"></span>
                            <span class="border_bg_rightBottom"></span>
                        </div>
                    </li>
                    <li>
                        <div class="liIn">
                            <h3>各专业授课教师承担课程门数</h3>
                            <p class="shu"><span class="shu4" id="ps41"></span><i><font size="2">门</font></i></p>
                            <div class="zi"><span class="span1"><font size="2">实验课：<span id="ps42"></span>门</font></span><span><font size="2">理论课：<span id="ps43"></span>门</font></span></div>
                            <span class="border_bg_leftTop"></span>
                            <span class="border_bg_rightTop"></span>
                            <span class="border_bg_leftBottom"></span>
                            <span class="border_bg_rightBottom"></span>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="leftMain_middle">
            <div class="leftMain_middle_left">
                <div class="leftMain_middle_leftIn">
                    <h3>各教学单位专业带头人情况</h3>
                    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                    <div class="biaoge" style="width:100%; height:30vh" id="chartmain"></div>

                    <span class="border_bg_leftTop"></span>
                    <span class="border_bg_rightTop"></span>
                    <span class="border_bg_leftBottom"></span>
                    <span class="border_bg_rightBottom"></span>
                </div>
            </div>
            <div class="leftMain_middle_right">
                <div class="leftMain_middle_rightIn">
                    <h3>专业带头人学位结构</h3>
                    <div class="biaoge" style="width:100%; height:30vh" id="chartmain_bing"></div>
                    <span class="border_bg_leftTop"></span>
                    <span class="border_bg_rightTop"></span>
                    <span class="border_bg_leftBottom"></span>
                    <span class="border_bg_rightBottom"></span>
                </div>
            </div>
        </div>
        <div class="leftMain_middle">
            <div class="leftMain_middle_left">
                <div class="leftMain_middle_leftIn">
                    <h3>近5年毕业生就业率</h3>
                    <div class="biaoge" style="width:100%; height:25vh" id="chartmain_zhe"></div>
                    <script type="text/javascript">
                        //window.onload = function (){
                        //指定图表的配置项和数据

                        option = {
                            title: {
                                text: ''
                            },
                            tooltip: {
                                trigger: 'axis'
                            },
                            legend: {
                                textStyle: {
                                    color: '#fff',
                                    fontSize: 12,
                                },
                                right:'10%',
                                data: ['本科生', '研究生']
                            },
                            grid:{
                                x:40,
                                y:20,
                                x2:20,
                                y2:40,
                            },
                            toolbox: {
                                feature: {
                                    //saveAsImage: {}
                                }
                            },
                            xAxis: {
                                type: 'category',
                                boundaryGap: false,
                                axisLabel: {
                                    /*inside: true,*/
                                    interval:0,
                                    textStyle: {
                                        color: '#fff',
                                        fontSize: 12

                                    }
                                },
                                axisTick: {
                                    show: false,
                                },
                                axisLine: {
                                    show: true,
                                    symbol:['none', 'arrow'],
                                    symbolOffset: 12,
                                    lineStyle:{
                                        color: '#fff',
                                    }
                                },
                                data: ['2015', '2016', '2017', '2018', '2019']
                            },
                            yAxis: {
                                type: 'value',
                                scale:true,
                                min:'85',

                                axisLine: {
                                    show: true,
                                    symbol: ['none', 'arrow'],
                                    symbolOffset: 12,
                                    lineStyle:{
                                        color: '#fff',
                                    }
                                },
                                axisTick: {
                                    show: false
                                },
                                axisLabel: {
                                    textStyle: {
                                        color: '#fff',
                                        fontSize: 12
                                    }
                                }
                            },
                            series: [
                                {
                                    name: '本科生',
                                    type: 'line',
                                    stack: '总量',
                                    data: [90.54, 91.64, 92.83, 93.07, 93.68],
                                    itemStyle: {
                                        normal: {
                                            color: "#0efdff",//折线点的颜色
                                            lineStyle: {
                                                color: "#0efdff",//折线的颜色
                                                width:2,
                                            }
                                        },
                                    }
                                },
                                {
                                    name: '研究生',
                                    type: 'line',
                                    stack: '',
                                    data: [95.4,95.89, 96.3, 98.07, 96.2]
                                },
                            ]
                        };
                        //获取dom容器
                        var myChart = echarts.init(document.getElementById('chartmain_zhe'));
                        // 使用刚指定的配置项和数据显示图表。
                        myChart.setOption(option);
                        //};
                    </script>
                    <span class="border_bg_leftTop"></span>
                    <span class="border_bg_rightTop"></span>
                    <span class="border_bg_leftBottom"></span>
                    <span class="border_bg_rightBottom"></span>
                </div>
            </div>
            <div class="leftMain_middle_right">
                <div class="leftMain_middle_rightIn">
                    <h3>各专业毕业生初次就业率</h3>
                    <div class="biaoge biaoge_pai" style="width:100%; height:25vh">
                        <div class="biaoge_paiIn">
                            <ul>
                                <li>
                                    <div class="liIn">
                                        <div class="liIn_left"><span class="bot"></span><span class="zi">行政管理</span></div>
                                        <div class="liIn_line"><div class="line_lineIn" style="width:100%;"></div></div>
                                        <p class="num">100%</p>
                                    </div>
                                </li>
                                <li>
                                    <div class="liIn liIn2">
                                        <div class="liIn_left"><span class="bot"></span><span class="zi">物联网工程</span></div>
                                        <div class="liIn_line"><div class="line_lineIn" style="width:98.48%;"></div></div>
                                        <p class="num">98.48%</p>
                                    </div>
                                </li>
                                <li>
                                    <div class="liIn liIn3">
                                        <div class="liIn_left"><span class="bot"></span><span class="zi">自动化</span></div>
                                        <div class="liIn_line"><div class="line_lineIn" style="width:97.93%;"></div></div>
                                        <p class="num">97.93%</p>
                                    </div>
                                </li>
                                <li>
                                    <div class="liIn liIn4">
                                        <div class="liIn_left"><span class="bot"></span><span class="zi">应用物理学</span></div>
                                        <div class="liIn_line"><div class="line_lineIn" style="width:97.92%;"></div></div>
                                        <p class="num">97.92%</p>
                                    </div>
                                </li>
                                <li>
                                    <div class="liIn liIn5">
                                        <div class="liIn_left"><span class="bot"></span><span class="zi">通信工程</span></div>
                                        <div class="liIn_line"><div class="line_lineIn" style="width:95.99%;"></div></div>
                                        <p class="num">95.99%</p>
                                    </div>
                                </li>
                                <li>
                                    <div class="liIn liIn6">
                                        <div class="liIn_left"><span class="bot"></span><span class="zi">电子信息工程</span></div>
                                        <div class="liIn_line"><div class="line_lineIn" style="width:95.79%;"></div></div>
                                        <p class="num">95.79%</p>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <span class="border_bg_leftTop"></span>
                    <span class="border_bg_rightTop"></span>
                    <span class="border_bg_leftBottom"></span>
                    <span class="border_bg_rightBottom"></span>
                </div>
            </div>
        </div>
    </div>
    <div class="rightMain">
        <div class="rightMain_top">
            <div class="rightMain_topIn">
                <h3>学科专业基本情况</h3>
                <div class="biaoge biaoge_bi" style="width:100%; height:25vh">
                    <ul>
                        <li>
                            <div class="liIn">
                                <p class="shu shu1" id="ss1"></p>
                                <p class="zi">本科专业总数</p>
                            </div>
                        </li>
                        <li>
                            <div class="liIn">
                                <p class="shu shu3" id="ss3"></p>
                                <p class="zi">生师比</p>
                            </div>
                        </li>
                        <li>
                            <div class="liIn">
                                <p class="shu shu4" id="ss4"></p>
                                <p class="zi">重点学科数</p>
                            </div>
                        </li>
                        <li>
                            <div class="liIn">
                                <p class="shu shu5" id="ss5"></p>
                                <p class="zi">本科毕业生学位授予率</p>
                            </div>
                        </li>
                        <li>
                            <div class="liIn">
                                <p class="shu shu2" id="ss2"></p>
                                <p class="zi"></p>
                            </div>
                        </li>
                        <li>
                            <div class="liIn">
                                <p class="shu shu6" id="ss6"></p>
                                <p class="zi">博士后流动站</p>
                            </div>
                        </li>
                    </ul>

                </div>


                <span class="border_bg_leftTop"></span>
                <span class="border_bg_rightTop"></span>
                <span class="border_bg_leftBottom"></span>
                <span class="border_bg_rightBottom"></span>
            </div>
        </div>
        <div class="rightMain_bottom">
            <div class="rightMain_bottomIn">
                <h3>各专业教学情况一览</h3>
                <div class="biaoge biaoge_list" style="width:100%; height:46vh">
                    <div class="biaoge_listIn">
                        <ul class="ul_title">
                            <li>专业名称</li>
                            <li>优势专业</li>
                            <li>总学分</li>
                            <li>设立时间</li>
                            <li>实践教学比</li>
                        </ul>
                        <div class="ul_list">
                            <div class="ul_listIn" id="teaSitu">
                            </div>
                        </div>
                    </div>

                </div>
                <span class="border_bg_leftTop"></span>
                <span class="border_bg_rightTop"></span>
                <span class="border_bg_leftBottom"></span>
                <span class="border_bg_rightBottom"></span>
            </div>
        </div>
    </div>
    <div style="clear:both;"></div>
</div>


<!--数字增长累加动画-->
<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="js/jquery.numscroll.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    $(".shu1").numScroll();
    $(".shu2").numScroll();
    $(".shu3").numScroll();
    $(".shu4").numScroll();
    $(".shu5").numScroll();
    $(".shu6").numScroll();

    /*$(".num2").numScroll({
        time:5000
    });*/
</script>

<script>
    var username = '<%= request.getSession().getAttribute("username")%>'
    if (!username.includes(null)) {
    } else {
        alert("请您先登录！");
        window.location.href = "login.jsp";
    }

</script>
<%--ajax请求后台数据--%>
<script language="JavaScript" src="js/main.js">
</script>
</body>
</html>

