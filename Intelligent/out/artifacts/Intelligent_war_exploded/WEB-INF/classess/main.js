// 从后台获取数据
$(document).ready(function() {

    showChart();
    // 先显示一次，再每隔3s刷新一次
    setInterval(function () {
        showChart();
    }, 30000);//每过30s调用一次接口

    function showChart() {
        $.ajax({
            url: 'MajorServlet',
            type: 'POST',     // 请求类型，常用的有 GET 和 POST
            data: {
                // 请求参数
            },
            success: function (result) { // 接口调用成功回调函数

                // result 为服务器返回的数据
                // 将Json字符串转化为Json对象
                result = JSON.parse(result);

                // 1.教学情况列表
                var teaSitu=result[0].teaList;
                var htm="";
                for(var i = 0; i<teaSitu.length; i++){
                    htm += "<ul class=\"ul_con\"><li>" + teaSitu[i].major_name + "</li><li><marquee>" + teaSitu[i].advantage_major + "</marquee></li><li>"
                        + teaSitu[i].total_credit + "</li><li>" + teaSitu[i].set_time + "</li><li>" + teaSitu[i].parctice_rate +
                        "</li></ul>"
                }
                $("#teaSitu").html(htm); // 插入html


                // 2.专业带头人柱状图
                var colLea=result[0].leaMap;
                //指定图表的配置项和数据
                var dataAxis = colLea["college"];
                var data = colLea["leader_num"];

                var yMax = 15;
                var dataShadow = [];

                for (var i = 0; i < data.length; i++) {
                    dataShadow.push(yMax);
                }

                option = {
                    title: {
                        text: '',
                        subtext: ''
                    },
                    grid:{
                        x:40,
                        y:40,
                        x2:20,
                        y2:20,

                    },
                    xAxis: {
                        data: dataAxis,
                        axisLabel: {
                            /*inside: true,*/
                            interval:0,
                            rotate:30,
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
                        z: 10
                    },
                    yAxis: {
                        type: 'value',
                        name: '单位:人',
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

                    dataZoom: [
                        {
                            type: 'inside'
                        }
                    ],
                    series: [
                        { // For shadow
                            type: 'bar',
                            itemStyle: {
                                color: 'rgba(0,0,0,0.05)'
                            },
                            barGap: '-100%',
                            barCategoryGap: '40%',
                            data: dataShadow,
                            animation: false
                        },
                        {
                            type: 'bar',
                            itemStyle: {
                                color: new echarts.graphic.LinearGradient(
                                    0, 0, 0, 1,
                                    [
                                        {offset: 0, color: '#0efdff'},
                                        {offset: 0.5, color: '#188df0'},
                                        {offset: 1, color: '#188df0'}
                                    ]
                                )
                            },
                            emphasis: {
                                itemStyle: {
                                    color: new echarts.graphic.LinearGradient(
                                        0, 0, 0, 1,
                                        [
                                            {offset: 0, color: '#2378f7'},
                                            {offset: 0.7, color: '#2378f7'},
                                            {offset: 1, color: '#0efdff'}
                                        ]
                                    )
                                }
                            },
                            data: data
                        }
                    ]
                };

                // 获取dom容器
                var myChart = echarts.init(document.getElementById('chartmain'));
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);

                // 3.带头人饼图
                var leaSitu=result[0].leasMap;
                option = {
                    title: {
                        text: '数据情况统计',
                        subtext: '',
                        left: 'right',
                        textStyle: {
                            color: '#fff',
                            fontSize: 12
                        }
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: '{a} <br/>{b} : {c} ({d}%)'
                    },
                    legend: {
                        // orient: 'vertical',
                        // top: 'middle',
                        type: 'scroll',
                        orient: 'vertical',
                        right: 10,
                        top: 40,
                        bottom: 20,
                        left: 'right',
                        data: ['博士', '硕士', '其他'],
                        textStyle: {
                            color: '#fff',
                            fontSize: 12
                        }

                    },
                    grid:{
                        x:'-10%',
                        y:40,
                        x2:20,
                        y2:20,
                    },
                    color : [ '#09d0fb', '#f88cfb', '#95f8fe' ],
                    series: [
                        {
                            type: 'pie',
                            radius: '65%',
                            center: ['50%', '50%'],
                            selectedMode: 'single',
                            data: [
                                {value: leaSitu["PhD_num"], name: '博士',},
                                {value: leaSitu["master_num"], name: '硕士'},
                                {value: leaSitu["other_num"], name: '其他'}
                            ],
                            emphasis: {
                                itemStyle: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
                //获取dom容器
                var myChart = echarts.init(document.getElementById('chartmain_bing'));
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);


                // 4.学校情况
                var schSitu=result[0].schsMap;
                $("#ss1").text(schSitu["major_num"]);
                $("#ss3").text(schSitu["tea_stu_rate"]);
                $("#ss4").text(schSitu["stress_subject"]);
                $("#ss5").text(schSitu["degree_rate"]);
                $("#ss6").text(schSitu["postdoc_station"]);

                // 5.人事情况
                var perSitu=result[0].persMap;
                $("#ps11").html(perSitu["teacher_num"]);
                $("#ps12").html(perSitu["teacher_this"]);
                $("#ps13").html(perSitu["teacher_outer"]);
                $("#ps21").html(perSitu["teacher_ftime_num"]);
                $("#ps22").html(perSitu["teacher_ftime_this"]);
                $("#ps23").html(perSitu["teacher_ftime_outer"]);
                $("#ps31").html(perSitu["experiment_num"]);
                $("#ps32").html(perSitu["experiment_title"]);
                $("#ps33").html(perSitu["experiment_ntitle"]);
                $("#ps41").html(perSitu["course_num"]);
                $("#ps42").html(perSitu["course_experiment"]);
                $("#ps43").html(perSitu["course_theory"]);


            }
        });
    }
});