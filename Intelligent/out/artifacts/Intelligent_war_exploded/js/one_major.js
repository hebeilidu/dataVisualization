 $(window).load(function(){  
             $(".loading").fadeOut()
            })  
$(function () {
    var major_name = GetRequest();

    function GetRequest() {
        var url = location.search; //获取url中"?"符后的字串
        var theRequest = new Object();
        if (url.indexOf("?") != -1) {
            var str = url.substr(1);
            strs = str.split("&");
            for (var i = 0; i < strs.length; i++) {
                theRequest[strs[i].split("=")[0]] = decodeURIComponent(strs[i].split("=")[1]);
            }
        }
        return theRequest;
    }

    showChart();
    function showChart() {
        $.ajax({
            url: 'OneMajorServlet',
            type: 'POST',     // 请求类型，常用的有 GET 和 POST
            data: {"major_name":major_name['major_name']},
            success: function (result) { // 接口调用成功回调函数
                // result 为服务器返回的数据
                // 将Json字符串转化为Json对象
                result = JSON.parse(result);

                // 1.本专业基本情况
                $("#major").html(result[0].major_name);
                $("#ms1").html(result[0].student_num);
                $("#ms2").html(result[0].teacher_num);
                $("#ms3").html(result[0].period_num);
                $("#ms4").html(result[0].college);
                $("#ms5").html(result[0].major_code);
                $("#ms6").html(result[0].credit_num);
                $("#gn").html(result[0].graduate);

                echarts_1();
                echarts_2();
                echarts_3();
                echarts_4();
                echarts_5();
                echarts_6();
                echarts_7();
                echarts_8();
                echarts_9();
                echarts_10();
                echarts_11();
                zb1();
                zb2();
                zb3();

                function echarts_1() {
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('echart1'));
                    option = {
                        tooltip: {
                            trigger: 'item',
                            formatter: "{b} : {c} ({d}%)"
                        },
                        legend: {
                            right: 0,
                            top: 30,
                            height: 160,
                            itemWidth: 9,
                            itemHeight: 10,
                            itemGap: 10,
                            textStyle: {
                                color: 'rgba(255,255,255,.6)',
                                fontSize: 12
                            },
                            orient: 'vertical',
                            data: ['必修课', '选修课', '集中实践', '课外活动']
                        },
                        calculable: true,
                        series: [
                            {
                                name: ' ',
                                color: ['#62c98d', '#2f89cf', '#4cb9cf', '#53b666', '#62c98d', '#205acf', '#c9c862', '#c98b62', '#c962b9', '#7562c9', '#c96262', '#c25775', '#00b7be'],
                                type: 'pie',
                                radius: [30, 70],
                                center: ['35%', '50%'],
                                roseType: 'radius',
                                label: {
                                    normal: {
                                        show: true
                                    },
                                    emphasis: {
                                        show: true
                                    }
                                },

                                lableLine: {
                                    normal: {
                                        show: true
                                    },
                                    emphasis: {
                                        show: true
                                    }
                                },
                    
                                data: [
                                    {value: result[0].reqCourse_credits, name: '必修课'},
                                    {value: result[0].eleCourse_credits, name: '选修课'},
                                    {value: result[0].intePractice_credits, name: '集中实践'},
                                    {value: result[0].extraActiv_credits, name: '课外活动'},

                                ]
                            },
                        ]
                    };

                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize", function () {
                        myChart.resize();
                    });
                }

                function echarts_2() {
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('echart2'));

                    option = {
                        tooltip: {
                            trigger: 'item',
                            formatter: "{b} : {c} ({d}%)"
                        },
                        legend: {

                            top: '15%',
                            data: ['35岁及以下', '36-45岁', '46-55岁', '56岁及以上'],
                            icon: 'circle',
                            textStyle: {
                                color: 'rgba(255,255,255,.6)',
                            }
                        },
                        calculable: true,
                        series: [{
                            name: '',
                            color: ['#62c98d', '#2f89cf', '#4cb9cf', '#53b666', '#62c98d', '#205acf', '#c9c862', '#c98b62', '#c962b9', '#c96262'],
                            type: 'pie',
                            //起始角度，支持范围[0, 360]
                            startAngle: 0,
                            //饼图的半径，数组的第一项是内半径，第二项是外半径
                            radius: [51, 100],
                            //支持设置成百分比，设置成百分比时第一项是相对于容器宽度，第二项是相对于容器高度
                            center: ['50%', '45%'],

                            //是否展示成南丁格尔图，通过半径区分数据大小。可选择两种模式：
                            // 'radius' 面积展现数据的百分比，半径展现数据的大小。
                            //  'area' 所有扇区面积相同，仅通过半径展现数据大小
                            roseType: 'area',
                            //是否启用防止标签重叠策略，默认开启，圆环图这个例子中需要强制所有标签放在中心位置，可以将该值设为 false。
                            avoidLabelOverlap: false,
                            label: {
                                normal: {
                                    show: true,
                                    //  formatter: '{c}辆'
                                },
                                emphasis: {
                                    show: true
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: true,
                                    length2: 1,
                                },
                                emphasis: {
                                    show: true
                                }
                            },




                            data: [
                                {value: result[0].teanum_under35, name: '35岁及以下',},
                                {value: result[0].teanum_36to45, name: '36-45岁',},
                                {value: result[0].teanum_46to55, name: '46-55岁',},
                                {value: result[0].teanum_over56, name: '56岁及以上',},


                                {value: 0, name: "", label: {show: false}, labelLine: {show: false}},
                                {value: 0, name: "", label: {show: false}, labelLine: {show: false}},
                                {value: 0, name: "", label: {show: false}, labelLine: {show: false}},
                                {value: 0, name: "", label: {show: false}, labelLine: {show: false}},
                                {value: 0, name: "", label: {show: false}, labelLine: {show: false}},


                            ]
                        }]
                    };

                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize", function () {
                        myChart.resize();
                    });
                }

                function echarts_3() {
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('echart3'));
                    option = {
                        // backgroundColor: '#00265f',
                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'shadow'
                            }
                        },
                        grid: {
                            top: '20%',
                            right: '5%',
                            left: '5%',
                            bottom: '5%',
                            containLabel:true
                        },
                        xAxis: [{
                            type: 'category',
                            data: ['招生计划数', '实际录取数', '第一志愿录取数', '实际报到数'],
                            axisLine: {
                                lineStyle: {
                                    color: '#2F4BA8'
                                }
                            },
                            axisLabel: {
                                margin: 10,
                                color: '#e2e9ff',
                                textStyle: {
                                    fontSize: 12
                                },
                            },
                        }],
                        yAxis: [{
                            axisLabel : {
                                formatter: function(){
                                    return "";
                                }
                            },
                            axisLine:{
                                show:false
                            },
                            axisTick:{
                                show:false
                            },
                            splitLine:{
                                show:false
                            },
                        }],
                        series: [{
                            type: 'bar',
                            data: [result[0].enrollment_planned, result[0].enrollment_actual, result[0].enrollment_first, result[0].enrollment_register],
                            barWidth: '20px',
                            markLine: {

                                symbolSize: 0,
                                label: {
                                    show: false
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                        offset: 0,
                                        color: '#437DFF' // 0% 处的颜色
                                    }, {
                                        offset: 1,
                                        color: '#8D41FF' // 100% 处的颜色
                                    }], false),
                                    barBorderRadius: [30, 30, 30, 30],
                                    // shadowColor: 'rgba(0,160,221,1)',
                                    // shadowBlur: 4,
                                }
                            },
                            label: {
                                normal: {
                                    show: true,
                                    lineHeight: 30,
                                    width: 50,
                                    height: 30,
                                    //backgroundColor: '#2F4BA8',
                                    borderRadius: 200,
                                    position: ['-14', '-30'],
                                    distance: 1,
                                    formatter: [
                                        '    {d|}',
                                        ' {a|{c}}     \n',
                                        '    {b|}'
                                    ].join(''),
                                    rich: {

                                        a: {
                                            color: '#fff',
                                            align: 'center',
                                        },

                                    }
                                }
                            }
                        }]
                    };
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize", function () {
                        myChart.resize();
                    });
                }
                function echarts_11() {
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('echart11'));
                    var data = [
                        {
                            name: '第一志愿专业录取率',
                            value: result[0].first_volun_rate
                        },{
                            name: '报到率',
                            value: result[0].registration_rate
                        }]



                    var titleArr= [], seriesArr=[];
                    colors=[['#389af4', '#dfeaff'],['#a181fc', '#e3d9fe']]
                    data.forEach(function(item, index){
                        titleArr.push(
                            {
                                text:item.name,
                                left: index * 40 + 29 +'%',
                                top: '85%',
                                textAlign: 'center',
                                textStyle: {
                                    fontWeight: 'normal',
                                    fontSize: '14',
                                    color: colors[index][0],
                                    textAlign: 'center',
                                },
                            }
                        );
                        seriesArr.push(
                            {
                                name: item.name,
                                type: 'pie',
                                clockWise: false,
                                radius: [60, 70],
                                itemStyle:  {
                                    normal: {
                                        color: colors[index][0],
                                        shadowColor: colors[index][0],
                                        shadowBlur: 0,
                                        label: {
                                            show: false
                                        },
                                        labelLine: {
                                            show: false
                                        },
                                    }
                                },
                                hoverAnimation: false,
                                center: [index * 40 + 30 +'%', '50%'],
                                data: [{
                                    value: item.value,
                                    label: {
                                        normal: {
                                            formatter: function(params){
                                                return params.value+'%';
                                            },
                                            position: 'center',
                                            show: true,
                                            textStyle: {
                                                fontSize: '20',
                                                fontWeight: 'bold',
                                                color: colors[index][0]
                                            }
                                        }
                                    },
                                }, {
                                    value: 100-item.value,
                                    name: 'invisible',
                                    itemStyle: {
                                        normal: {
                                            color: colors[index][1]
                                        },
                                        emphasis: {
                                            color: colors[index][1]
                                        }
                                    }
                                }]
                            }
                        )
                    });


                    option = {
                        //backgroundColor: "#fff",
                        title:titleArr,
                        series: seriesArr
                    }
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize", function () {
                        myChart.resize();
                    });
                }
                function echarts_4() {
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('echart4'));
                    //let bgColor = '#fff';
                    let title = '授课教师数';
                    let color = ['#F8456B', '#E271DE', '#0E7CE2'];
                    let echartData = [{
                        name: "教授",
                        value: result[0].title_professor
                    },
                        {
                            name: "副教授",
                            value: result[0].title_asprofessor
                        },
                        {
                            name: "其他",
                            value: result[0].title_other
                        }
                    ];

                    let formatNumber = function (num) {
                        let reg = /(?=(\B)(\d{3})+$)/g;
                        return num.toString().replace(reg, ',');
                    }
                    let total = echartData.reduce((a, b) => {
                        return a + b.value * 1
                    }, 0);

                    option = {
                        // backgroundColor: bgColor,
                        color: color,
                        // tooltip: {
                        //     trigger: 'item'
                        // },
                        title: [{
                            text: '{name|' + title + '}\n{val|' + formatNumber(total) + '}',
                            top: 'center',
                            left: 'center',
                            textStyle: {
                                rich: {
                                    name: {
                                        fontSize: 14,
                                        fontWeight: 'normal',
                                        color: '#fff',
                                        padding: [10, 0]
                                    },
                                    val: {
                                        fontSize: 32,
                                        fontWeight: 'bold',
                                        color: '#fff',
                                    }
                                }
                            }
                        }
                        ],

                        series: [{
                            type: 'pie',
                            radius: ['37%', '50%'],
                            center: ['50%', '50%'],
                            data: echartData,
                            hoverAnimation: false,
                            itemStyle: {
                                normal: {
                                    //borderColor: color,
                                    // borderWidth: 2
                                }
                            },
                            labelLine: {
                                normal: {
                                    length: 20,
                                    length2: 98,
                                    lineStyle: {
                                        color: '#e6e6e6'
                                    }
                                }
                            },
                            label: {
                                normal: {
                                    formatter: params => {
                                        return (
                                            '{icon|●}{name|' + params.name + '}{value|' +
                                            formatNumber(params.value) + '}'
                                        );
                                    },
                                    padding: [0, -100, 25, -100],
                                    rich: {
                                        icon: {
                                            fontSize: 16
                                        },
                                        name: {
                                            fontSize: 14,
                                            padding: [0, 10, 0, 4],
                                            color: '#fff'
                                        },
                                        value: {
                                            fontSize: 18,
                                            fontWeight: 'bold',
                                            color: '#fff'
                                        }
                                    }
                                }
                            },
                        }]
                    }

                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize", function () {
                        myChart.resize();
                    });
                }

                function echarts_6() {
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('echart6'));
                    data = [{
                        name: "博士",
                        value: result[0].degree_doctor
                    },
                        {
                            name: "硕士",
                            value: result[0].degree_master
                        },
                        {
                            name: "其他",
                            value: result[0].degree_other
                        }
                    ];
                    xAxisData = [];
                    seriesData1 = [];
                    sum = 0;
                    barTopColor = ["#02c3f1", "#53e568", "#a154e9"];
                    barBottomColor = ["rgba(2,195,241,0.1)", "rgba(83, 229, 104, 0.1)", "rgba(161, 84, 233, 0.1)"];
                    data.forEach(item => {
                        xAxisData.push(item.name);
                        seriesData1.push(item.value);
                        sum += item.value;
                    });
                    option = {
                        //backgroundColor: '#061326',

                        grid: {
                            top: '10%',
                            bottom: '40%'
                        },
                        xAxis: {
                            data: xAxisData,
                            axisTick: {
                                show: false
                            },
                            axisLine: {
                                show: false
                            },
                            axisLabel: {
                                show: true,
                                margin: 25,
                                align: 'center',
                                formatter: function (params, index) {
                                    return '{a|' + (seriesData1[index] / sum * 100).toFixed(2) + '%}' + '\n' + '{b|' + params + '}';
                                },
                                textStyle: {
                                    fontSize: 14,
                                    color: '#ffffff',
                                    rich: {
                                        a: {
                                            fontSize: 12,
                                            color: '#ffffff'
                                        },
                                        b: {
                                            height: 20,
                                            fontSize: 14,
                                            color: '#ffffff'
                                        }
                                    }
                                }
                            },
                            interval: 0
                        },
                        yAxis: {
                            splitLine: {
                                show: false
                            },
                            axisTick: {
                                show: false
                            },
                            axisLine: {
                                show: false
                            },
                            axisLabel: {
                                show: false
                            }
                        },
                        series: [{
                            name: '柱顶部',
                            type: 'pictorialBar',
                            symbolSize: [26, 10],
                            symbolOffset: [0, -5],
                            z: 12,
                            itemStyle: {
                                normal: {
                                    color: function (params) {
                                        return barTopColor[params.dataIndex];
                                    }
                                }
                            },
                            label: {
                                show: true,
                                position: 'top',
                                fontSize: 16
                            },
                            symbolPosition: 'end',
                            data: seriesData1,
                        }, {
                            name: '柱底部',
                            type: 'pictorialBar',
                            symbolSize: [26, 10],
                            symbolOffset: [0, 5],
                            z: 12,
                            itemStyle: {
                                normal: {
                                    color: function (params) {
                                        return barTopColor[params.dataIndex];
                                    }
                                }
                            },
                            data: seriesData1
                        }, {
                            name: '第一圈',
                            type: 'pictorialBar',
                            symbolSize: [47, 16],
                            symbolOffset: [0, 11],
                            z: 11,
                            itemStyle: {
                                normal: {
                                    color: 'transparent',
                                    borderColor: '#3ACDC5',
                                    borderWidth: 2
                                }
                            },
                            data: seriesData1
                        }, {
                            name: '第二圈',
                            type: 'pictorialBar',
                            symbolSize: [62, 22],
                            symbolOffset: [0, 17],
                            z: 10,
                            itemStyle: {
                                normal: {
                                    color: 'transparent',
                                    borderColor: barTopColor[0],
                                    borderWidth: 2
                                }
                            },
                            data: seriesData1
                        }, {
                            type: 'bar',
                            itemStyle: {
                                normal: {
                                    color: function (params) {
                                        return new echarts.graphic.LinearGradient(
                                            0, 0, 0, 1,
                                            [{
                                                offset: 1,
                                                color: barTopColor[params.dataIndex]
                                            },
                                                {
                                                    offset: 0,
                                                    color: barBottomColor[params.dataIndex]
                                                }
                                            ]
                                        );
                                    },
                                    opacity: 0.8
                                }
                            },
                            z: 16,
                            silent: true,
                            barWidth: 26,
                            barGap: '-100%', // Make series be overlap
                            data: seriesData1
                        }]
                    }

                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize",function(){
                        myChart.resize();
                    });
                }
                function echarts_7() {
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('echart7'));
                    var  getvalue=[result[0].employment_rate];

                    option = {
                        title: {
                            text: getvalue+'%',
                            textStyle: {
                                color: '#FF1CAE',
                                fontSize: 24
                            },
                            subtext: '毕业生初次就业率',
                            subtextStyle: {
                                color: '#fff',
                                fontSize: 11
                            },
                            itemGap: 20,
                            right: '25%',
                            top: '33%'
                        },
                        tooltip: {
                            formatter: function (params) {
                                return '<span style="color: #fff;">毕业生初次就业率：'+ getvalue + '%</span>';
                            }
                        },
                        angleAxis: {
                            max: 100,
                            clockwise: true, // 逆时针
                            // 隐藏刻度线
                            show: false
                        },
                        radiusAxis: {
                            type: 'category',
                            show: true,
                            axisLabel: {
                                show: false,
                            },
                            axisLine: {
                                show: false,

                            },
                            axisTick: {
                                show: false
                            },
                        },
                        polar: {
                            center: ['50%', '45%'],
                            radius: '120%' //图形大小
                        },
                        series: [{
                            type: 'bar',
                            data: getvalue,
                            showBackground: true,
                            backgroundStyle: {
                                color: '#D8BFD8',
                            },
                            coordinateSystem: 'polar',
                            roundCap: true,
                            barWidth: 10,
                            itemStyle: {
                                normal: {
                                    opacity: 1,
                                    color:  new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                        offset: 0,
                                        color: '#CC3299'
                                    }, {
                                        offset: 1,
                                        color: '#871F78'
                                    }]),
                                    shadowBlur: 5,
                                    shadowColor: '#8E236B',
                                }
                            },
                        }]
                    }

                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize",function(){
                        myChart.resize();
                    });
                }
                function echarts_8() {
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('echart8'));
                    var  getvalue=[result[0].graduation_rate];

                    option = {
                        title: {
                            text: getvalue+'%',
                            textStyle: {
                                color: '#28BCFE',
                                fontSize: 24
                            },
                            subtext: '毕业率',
                            subtextStyle: {
                                color: '#fff',
                                fontSize: 11,
                                //right:10
                            },
                            itemGap: 20,
                            left: 'center',
                            top: '33%'
                        },
                        tooltip: {
                            formatter: function (params) {
                                return '<span style="color: #fff;">毕业率：'+ getvalue + '%</span>';
                            }
                        },
                        angleAxis: {
                            max: 100,
                            clockwise: true, // 逆时针


                            // 隐藏刻度线
                            show: false
                        },
                        radiusAxis: {
                            type: 'category',
                            show: true,
                            axisLabel: {
                                show: false,
                            },
                            axisLine: {
                                show: false,

                            },
                            axisTick: {
                                show: false
                            },
                        },
                        polar: {
                            center: ['50%', '45%'],
                            radius: '120%' //图形大小
                        },
                        series: [{
                            type: 'bar',
                            data: getvalue,
                            showBackground: true,
                            backgroundStyle: {
                                color: '#ADEAEA',
                            },
                            coordinateSystem: 'polar',
                            roundCap: true,
                            barWidth: 10,
                            itemStyle: {
                                normal: {
                                    opacity: 1,
                                    color:  new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                        offset: 0,
                                        color: '#007FFF'
                                    }, {
                                        offset: 1,
                                        color: '#7F00FF'
                                    }]),
                                    shadowBlur: 5,
                                    shadowColor: '#6B238E',
                                }
                            },
                        }]
                    }

                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize",function(){
                        myChart.resize();
                    });
                }
                function echarts_9() {
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('echart9'));
                    let data = {
                        female: {
                            name: '基础实验室',
                            data: [{
                                value: result[0].lab_basic_num,
                                label: '数量'
                            }, {
                                value: result[0].lab_basic_course,
                                label: '承担实验课程门数'
                            }]
                        },
                        male: {
                            name: '专业实验室',
                            data: [{
                                value: result[0].lab_prof_num,
                                label: '数量'
                            }, {
                                value: result[0].lab_prof_course,
                                label: '承担实验课程门数'
                            }]
                        }
                    };
                    let yAxisData = new Set();
                    let legendData = [];
                    _.forEach(data, (d) => {
                        legendData.push(d.name);
                        _.forEach(d.data, (item) => {
                            yAxisData.add(item.label);
                        });
                    });

                    let top = 30;
                    let bottom = 60;

                    yAxisData = [...yAxisData];

                    option = {
                        tooltip: {
                            show: true,
                            trigger: 'axis',
                            axisPointer: {
                                type: 'shadow'
                            }
                        },
                        legend: {
                            left: 'center',
                            bottom: 24,
                            itemWidth: 15,
                            itemHeight: 11,
                            itemGap: 20,
                            borderRadius: 4,
                            textStyle: {
                                color: '#fff',
                                fontSize: 14
                            },
                            data: legendData
                        },
                        grid: [{
                            left: '8%',
                            width: '28%',
                            containLabel: true,
                            bottom
                        }, {
                            left: '52%',
                            width: '0%',
                            bottom: bottom + 16
                        }, {
                            right: '8%',
                            width: '28%',
                            containLabel: true,
                            bottom
                        }].map(item => _.merge({
                            top
                        }, item)),
                        xAxis: [{
                            type: 'value',
                            inverse: true,
                            axisLabel: {
                                show: true
                            },
                            axisLine: {
                                show: false
                            },
                            axisTick: {
                                show: false
                            },
                            splitLine: {
                                show: false
                            }
                        }, {
                            gridIndex: 1,
                            show: true
                        }, {
                            gridIndex: 2,
                            type: 'value',
                            axisLabel: {
                                show: true
                            },
                            axisLine: {
                                show: false
                            },
                            axisTick: {
                                show: false
                            },
                            splitLine: {
                                show: false
                            }
                        }].map((item) => _.merge(item, {
                            axisLabel: {
                                color: '#949AA8',
                                margin: 0
                            },
                            splitLine: {
                                lineStyle: {
                                    color: '#E0E0E0',
                                    type: 'dashed'
                                }
                            },
                        })),
                        yAxis: [{
                            position: 'right',
                            axisLabel: {
                                show: false
                            },
                            axisLine: {
                                show: true
                            }
                        },
                            {
                                gridIndex: 1,
                                position: 'center',
                                axisLabel: {
                                    align: 'center',
                                    padding: [8, 0, 0, 0],
                                    fontSize: 12,
                                    color: `#fff`
                                },
                                axisLine: {
                                    show: false
                                }
                            },
                            {
                                gridIndex: 2,
                                position: 'left',
                                axisLabel: {
                                    show: false
                                },
                                axisLine: {
                                    show: true
                                }
                            }
                        ].map((item) => {
                            return _.merge(item, {
                                type: 'category',
                                inverse: false,
                                axisLine: {
                                    lineStyle: {
                                        color: '#E0E0E0'
                                    }
                                },
                                axisTick: {
                                    show: false
                                },
                                data: yAxisData
                            });
                        }),
                        series: [{
                            name: _.get(data, 'male.name'),
                            label: {
                                position: 'left'
                            },
                            itemStyle: {
                                color: '#01C5B2',
                                barBorderRadius: [4, 0, 0, 4]
                            },
                            data: _.map(_.get(data, 'male.data'), d => d.value)
                        },
                            {
                                xAxisIndex: 2,
                                yAxisIndex: 2,
                                name: _.get(data, 'female.name'),
                                label: {

                                    position: 'right'
                                },
                                itemStyle: {
                                    color: '#FB6F6C',
                                    barBorderRadius: [0, 4, 4, 0]
                                },
                                data: _.map(_.get(data, 'female.data'), d => d.value)
                            }
                        ].map(item => _.merge(item, {
                            type: 'bar',
                            barWidth: 11,
                            label: {
                                show: true,
                                fontFamily: 'Rubik-Medium',
                                fontSize: 14,
                                distance: 10
                            }
                        }))
                    };
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize",function(){
                        myChart.resize();
                    });
                }
                function echarts_10() {
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('echart10'));
                    var getxb1 = result[0].credit_experiment; //实验教学学分
                    var getxb2 = result[0].credit_nexperiment; //非实验教学学分
                    var total = parseInt(getxb1)+parseInt(getxb2);

                    // 百分比
                    var getxb11 = 100*(getxb1/total).toFixed(4);
                    var getxb22 = 100*(getxb2/total).toFixed(4);

                    var xbzb = [getxb11, getxb22];

                    var rich = {
                        name: {
                            color: "#fff",
                            fontSize: 12,
                            padding: [6, 10],
                            align: 'left'
                        },
                        percent: {
                            color: "#fff",
                            align: 'center',
                            fontSize: 13,
                            padding: [5, 10]
                        },
                        hr: {
                            borderColor: '#fff',
                            width: '100%',
                            borderWidth: 0.5,
                            height: 0,
                        }
                    }

                    option = {
                        tooltip: {
                            trigger: 'item',
                            formatter: '{b}:{c}分'
                        },
                        series: [{
                            name: '学分占比',
                            type: "pie",
                            radius: ['50%', '65%'],
                            startAngle: 180,
                            center: ['center', '50%'],
                            roseType: "radius",
                            labelLine: {
                                normal: {
                                    length: 10,
                                    length2: 10,
                                    lineStyle: {
                                        color: '#C8C8C8'
                                    }
                                }
                            },
                            label: {
                                normal: {
                                    formatter: params => {
                                        return '{name|' + params.name + '}\n{hr|}\n{percent|' + params.value + '分}  {percent|' + xbzb[params.dataIndex] + '%} '
                                    },
                                    rich: rich,
                                    distanceToLabelLine: 0,
                                    padding: [-1, 0, 0, 0]
                                }
                            },
                            data: [{
                                value: getxb1,
                                name: "实验教学学分",
                                itemStyle: {
                                    normal: {
                                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                            offset: 0,
                                            color: '#4C8DFA'
                                        }, {
                                            offset: 1,
                                            color: '#5CCFFF'
                                        }], false),
                                    }
                                }
                            }, {
                                value: 170 - getxb1,
                                name: "非实验教学学分",
                                itemStyle: {
                                    normal: {
                                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                            offset: 0,
                                            color: '#FFD18B'
                                        }, {
                                            offset: 1,
                                            color: '#FDAD59'
                                        }], false),
                                    }
                                }
                            }, ]
                        }, ]
                    };
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize",function(){
                        myChart.resize();
                    });
                }
                function echarts_5() {
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('echart5'));


                    var lightBlue = {
                        type: 'linear',
                        x: 0,
                        y: 0,
                        x2: 0,
                        y2: 1,
                        colorStops: [{
                            offset: 0,
                            color: 'rgba(41, 121, 255, 1)'
                        }, {
                            offset: 1,
                            color: 'rgba(0, 192, 255, 1)'
                        }],
                        globalCoord: false
                    }

                    var option = {
                        tooltip: {
                            show: false
                        },
                        grid: {
                            top: '0%',
                            left: '140',
                            right: '14%',
                            bottom: '0%',
                        },
                        xAxis: {
                            min: 0,
                            max: 100,
                            splitLine: {
                                show: false
                            },
                            axisTick: {
                                show: false
                            },
                            axisLine: {
                                show: false
                            },
                            axisLabel: {
                                show: false
                            }
                        },
                        yAxis: {
                            data: ['硕、博学位教师','35岁以下青年教师','高级职称教师','其中低年级授课教授','授课教授比例'],
                            //offset: 15,
                            axisTick: {
                                show: false
                            },
                            axisLine: {
                                show: false
                            },
                            axisLabel: {
                                color: 'rgba(255,255,255,.6)',
                                fontSize: 14
                            }
                        },
                        series: [{
                            type: 'bar',
                            label: {
                                show: true,
                                zlevel: 10000,
                                position: 'right',
                                padding: 10,
                                color: '#49bcf7',
                                fontSize: 14,
                                formatter: '{c}%'

                            },
                            itemStyle: {
                                color:'#49bcf7'
                            },
                            barWidth: '15',
                            data: [result[0].masters_degree_rate, result[0].tea_under35_rate, result[0].seniorTea_rate, result[0].junior_prof_rate, result[0].professors_rate],



                            z: 10
                        }, {
                            type: 'bar',
                            barGap: '-100%',
                            itemStyle: {
                                color:'#fff',
                                opacity: 0.1
                            },
                            barWidth: '15',
                            data: [100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100],
                            z: 5
                        }],
                    };
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    window.addEventListener("resize",function(){
                        myChart.resize();
                    });
                }



                function zb1() {
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('zb1'));
                    var v1=1626//男消费
                    var v2=79//女消费
                    var v3=v1+v2//总消费
                    option = {
                        series: [{

                            type: 'pie',
                            radius: ['60%', '70%'],
                            color:'#49bcf7',
                            label: {
                                normal: {
                                    position: 'center'
                                }
                            },
                            data: [{
                                value: v2,
                                name: '女消费',
                                label: {
                                    normal: {
                                        formatter: v2 +'',
                                        textStyle: {
                                            fontSize: 20,
                                            color:'#fff',
                                        }
                                    }
                                }
                            }, {
                                value: v1,
                                name: '男消费',
                                label: {
                                    normal: {
                                        formatter : function (params){
                                            return '占比'+Math.round( v2/v3*100)+ '%'
                                        },
                                        textStyle: {
                                            color: '#aaa',
                                            fontSize: 12
                                        }
                                    }
                                },
                                itemStyle: {
                                    normal: {
                                        color: 'rgba(255,255,255,.2)'
                                    },
                                    emphasis: {
                                        color: '#fff'
                                    }
                                },
                            }]
                        }]
                    };
                    myChart.setOption(option);
                    window.addEventListener("resize",function(){
                        myChart.resize();
                    });
                }
                function zb2() {
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('zb2'));
                    var v1=431//男消费
                    var v2=18//女消费
                    var v3=v1+v2//总消费
                    option = {

//animation: false,
                        series: [{
                            type: 'pie',
                            radius: ['60%', '70%'],
                            color:'#cdba00',
                            label: {
                                normal: {
                                    position: 'center'
                                }
                            },
                            data: [{
                                value: v1,
                                name: '男消费',
                                label: {
                                    normal: {
                                        formatter: v1 +'',
                                        textStyle: {
                                            fontSize: 20,
                                            color:'#fff',
                                        }
                                    }
                                }
                            }, {
                                value: v2,
                                name: '女消费',
                                label: {
                                    normal: {
                                        formatter : function (params){
                                            return '占比'+Math.round( v1/v3*100)+ '%'
                                        },
                                        textStyle: {
                                            padding:10,
                                            color: '#aaa',
                                            fontSize: 12
                                        }
                                    }
                                },
                                itemStyle: {
                                    normal: {
                                        color: 'rgba(255,255,255,.2)'
                                    },
                                    emphasis: {
                                        color: '#fff'
                                    }
                                },
                            }]
                        }]
                    };
                    myChart.setOption(option);
                    window.addEventListener("resize",function(){
                        myChart.resize();
                    });
                }
                function zb3() {
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('zb3'));
                    var v1 = 2//男消费
                    var v2 = 325//女消费
                    var v3 = v1 + v2;//总消费
                    option = {
                        series: [{

                            type: 'pie',
                            radius: ['60%', '70%'],
                            color: '#62c98d',
                            label: {
                                normal: {
                                    position: 'center'
                                }
                            },
                            data: [{
                                value: v2,
                                name: '女消费',
                                label: {
                                    normal: {
                                        formatter: v2 + '',
                                        textStyle: {
                                            fontSize: 20,
                                            color: '#fff',
                                        }
                                    }
                                }
                            }, {
                                value: v1,
                                name: '男消费',
                                label: {
                                    normal: {
                                        formatter: function (params) {
                                            return '占比' + Math.round(v2 / v3 * 100) + '%'
                                        },
                                        textStyle: {
                                            color: '#aaa',
                                            fontSize: 12
                                        }
                                    }
                                },
                                itemStyle: {
                                    normal: {
                                        color: 'rgba(255,255,255,.2)'
                                    },
                                    emphasis: {
                                        color: '#fff'
                                    }
                                },
                            }]
                        }]
                    };
                    myChart.setOption(option);
                    window.addEventListener("resize", function () {
                        myChart.resize();
                    });

                }
            }
        });
    }

})



		
		
		


		









