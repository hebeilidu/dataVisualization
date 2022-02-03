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

public class OneMajorServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 这个是设置编码格式，上同
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String major_name = request.getParameter("major_name");

        Map<String, Object> mapMax = new HashMap<>();
        MajorDao majorDao = new MajorDao();
        ArrayList<One_major> majorList = majorDao.queryAllPortrait_Info(major_name);
        mapMax.put("major_name",majorList.get(0).getMajor_name());
        mapMax.put("student_num",majorList.get(0).getStudent_num());
        mapMax.put("college",majorList.get(0).getCollege());
        mapMax.put("teacher_num",majorList.get(0).getTeacher_num());
        mapMax.put("major_code",majorList.get(0).getMajor_code());
        mapMax.put("period_num",majorList.get(0).getPeriod_num());
        mapMax.put("credit_num",majorList.get(0).getCredit_num());
        mapMax.put("title_professor",majorList.get(0).getTitle_professor());
        mapMax.put("title_asprofessor",majorList.get(0).getTitle_asprofessor());
        mapMax.put("title_other",majorList.get(0).getTitle_other());
        mapMax.put("degree_doctor",majorList.get(0).getDegree_doctor());
        mapMax.put("degree_master",majorList.get(0).getDegree_master());
        mapMax.put("degree_other",majorList.get(0).getDegree_other());
        mapMax.put("enrollment_planned",majorList.get(0).getEnrollment_planned());
        mapMax.put("enrollment_actual",majorList.get(0).getEnrollment_actual());
        mapMax.put("enrollment_first",majorList.get(0).getEnrollment_first());
        mapMax.put("enrollment_register",majorList.get(0).getEnrollment_register());
        mapMax.put("lab_basic_num",majorList.get(0).getLab_basic_num());
        mapMax.put("lab_basic_course",majorList.get(0).getLab_basic_course());
        mapMax.put("lab_prof_num",majorList.get(0).getLab_prof_num());
        mapMax.put("lab_prof_course",majorList.get(0).getLab_prof_course());
        mapMax.put("credit_experiment",majorList.get(0).getCredit_experiment());
        mapMax.put("credit_nexperiment",majorList.get(0).getCredit_nexperiment());
        mapMax.put("graduate",majorList.get(0).getGraduate());
        mapMax.put("graduation_rate",majorList.get(0).getGraduation_rate());
        mapMax.put("employment_rate",majorList.get(0).getEmployment_rate());
        mapMax.put("professors_rate",majorList.get(0).getProfessors_rate());//授课教授比例
        mapMax.put("junior_prof_rate",majorList.get(0).getJunior_prof_rate());//低年级授课教授比例
        mapMax.put("seniorTea_rate",majorList.get(0).getSeniorTea_rate());//高级职称教师比例
        mapMax.put("masters_degree_rate",majorList.get(0).getMasters_degree_rate()); //硕博学位教师比例
        mapMax.put("tea_under35_rate",majorList.get(0).getTea_under35_rate());//35岁以下青年教师比例
        mapMax.put("teanum_under35",majorList.get(0).getTeanum_under35());
        mapMax.put("teanum_36to45",majorList.get(0).getTeanum_36to45());
        mapMax.put("teanum_46to55",majorList.get(0).getTeanum_46to55());
        mapMax.put("teanum_over56",majorList.get(0).getTeanum_over56());
        mapMax.put("first_volun_rate",majorList.get(0).getFirst_volun_rate());
        mapMax.put("registration_rate",majorList.get(0).getRegistration_rate());
        mapMax.put("reqCourse_credits",majorList.get(0).getReqCourse_credits());
        mapMax.put("eleCourse_credits",majorList.get(0).getEleCourse_credits());
        mapMax.put("intePractice_credits",majorList.get(0).getIntePractice_credits());
        mapMax.put("extraActiv_credits",majorList.get(0).getExtraActiv_credits());

        // 将mapMax转化为Json
        JSONArray result = JSONArray.fromObject(mapMax);

        //将JSON串返回
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();

    }
}
