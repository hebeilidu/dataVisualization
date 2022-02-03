package com.smart.controller.major;

import com.smart.dao.major.MajorDao;
import com.smart.dao.user.StudentDao;
import com.smart.util.MD5Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorRateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 这个是设置编码格式，上同
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 学生与本学院授课教师之比曲线图
        // 先查专业
        MajorDao majorDao = new MajorDao();
        ArrayList<String> major = majorDao.queryMajor();

        // 循环根据专业查比率
        ArrayList<Float> rate = new ArrayList<>();
        MajorDao rateDao = new MajorDao();
        for (String m : major) {
            rate.add(rateDao.queryRate(m));
        }

        // 建总Map用于存放 专业 和 比率
        Map<String,Object> mapMax = new HashMap<>();

        // 建list存比率
        List<Map<String,Object>> listRate =new ArrayList<>();
        Map<String,Object> map =new HashMap<>();
        map.put("name","比率");
        map.put("data",rate);
        listRate.add(map);

        // 将专业和比率放入Map
        mapMax.put("major",major);
        mapMax.put("rate",listRate);




        // 将mapMax转化为Json
        JSONArray result = JSONArray.fromObject(mapMax);


        //将JSON串返回
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();

        }
    }

