package com.smart.controller.major;

import com.smart.dao.major.MajorDao;
import com.smart.pojo.*;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MajorServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 这个是设置编码格式，上同
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 主页
        // 建总Map用于存放所有
        Map<String,Object> mapMax = new HashMap<>();

        // 1.查教学情况
        MajorDao majorDao = new MajorDao();
        ArrayList<Teaching_situation> teaList = majorDao.queryTeaSitu();

        // 2.查带头人
        ArrayList<Major_leader> leaList = majorDao.queryMajLea();
        // 查学院和人数
        ArrayList<String> college = new ArrayList<>();
        ArrayList<Integer> leader_num = new ArrayList<>();
        for (Major_leader major_leader : leaList) {
            college.add(major_leader.getCollege());
            leader_num.add(major_leader.getLeader_num());
        }
        // 都放入map
        Map<String,Object> leaMap =new HashMap<>();
        leaMap.put("college",college);
        leaMap.put("leader_num",leader_num);

        // 3.带头人饼图
        Leader_situation leader_situation = majorDao.queryLeaSitu();
        Map<String,Object> leasMap =new HashMap<>();
        leasMap.put("PhD_num",leader_situation.getPhD_num());
        leasMap.put("master_num",leader_situation.getMaster_num());
        leasMap.put("other_num",leader_situation.getOther_num());

        // 4.学校情况
        School_situation school_situation = majorDao.querySchSitu();
        Map<String,Object> schsMap =new HashMap<>();
        schsMap.put("major_num",school_situation.getMajor_num());
        schsMap.put("tea_stu_rate",school_situation.getTea_stu_rate());
        schsMap.put("degree_rate",school_situation.getDegree_rate());
        schsMap.put("postdoc_station",school_situation.getPostdoc_station());
        schsMap.put("stress_subject",school_situation.getStress_subject());

        // 5.查人事情况
        Personnel_situation personnel_situation = majorDao.queryPerSitu();
        Map<String,Object> persMap =new HashMap<>();
        persMap.put("teacher_num",personnel_situation.getTeacher_num());
        persMap.put("teacher_this",personnel_situation.getTeacher_this());
        persMap.put("teacher_outer",personnel_situation.getTeacher_outer());
        persMap.put("teacher_ftime_num",personnel_situation.getTeacher_ftime_num());
        persMap.put("teacher_ftime_this",personnel_situation.getTeacher_ftime_this());
        persMap.put("teacher_ftime_outer",personnel_situation.getTeacher_ftime_outer());
        persMap.put("experiment_num",personnel_situation.getExperiment_num());
        persMap.put("experiment_title",personnel_situation.getExperiment_title());
        persMap.put("experiment_ntitle",personnel_situation.getExperiment_ntitle());
        persMap.put("course_num",personnel_situation.getCourse_num());
        persMap.put("course_experiment",personnel_situation.getCourse_experiment());
        persMap.put("course_theory",personnel_situation.getCourse_theory());

        // 放入总Map
        mapMax.put("teaList",teaList);
        mapMax.put("leaMap",leaMap);
        mapMax.put("leasMap",leasMap);
        mapMax.put("schsMap",schsMap);
        mapMax.put("persMap",persMap);


        System.out.println(mapMax);
        // 将mapMax转化为Json2
        JSONArray result = JSONArray.fromObject(mapMax);
        System.out.println(result);


        //将JSON串返回
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();

    }
}
