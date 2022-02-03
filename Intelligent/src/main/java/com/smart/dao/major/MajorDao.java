package com.smart.dao.major;

import com.smart.pojo.*;
import com.smart.util.DBHelper;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MajorDao {

    // 查专业概况(测试)
    public ArrayList<Major_situation> queryMajorSitu(){

        ArrayList<Major_situation> list = new ArrayList<Major_situation>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet set = null;

        String sql = "select * from major_situation";
        // 获取连接对象
        try {
            connection = DBHelper.getConn();
            ps = connection.prepareStatement(sql);
            set = ps.executeQuery();    // 执行查询

            while(set.next()){
                Major_situation res = new Major_situation();
                res.setMajor_name(set.getString(2));
                res.setEstablish_time(set.getInt(3));
                res.setTeacher(set.getInt(4));
                res.setTeacher_foreign(set.getInt(5));
                res.setTeacher_senior(set.getInt(6));
                res.setStudent_bachelor(set.getInt(7));
                res.setStudent_networth(set.getInt(8));
                res.setGraduates(set.getInt(9));
                res.setEmployment_rate(set.getFloat(10));

                list.add(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
                ps.close();
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    // 查学生与本学院授课教师之比
    public Float queryRate(String major){

        Float res = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet set = null;

        String sql = "select convert (decimal(10,2),student_bachelor*1.0/teacher*1.0) from major_situation where major_name ="+ "'" + major + "'";
        // 获取连接对象
        try {
            connection = DBHelper.getConn();
            ps = connection.prepareStatement(sql);
            set = ps.executeQuery();    // 执行查询

            while(set.next()){
                res=set.getFloat(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
                ps.close();
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    // 查专业
    public ArrayList<String> queryMajor(){

        ArrayList<String> list = new ArrayList<String>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet set = null;

        String sql = "select major_name from major_situation";
        // 获取连接对象
        try {
            connection = DBHelper.getConn();
            ps = connection.prepareStatement(sql);
            set = ps.executeQuery();    // 执行查询

            while(set.next()){
                list.add(set.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
                ps.close();
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    // 查教学情况
    public ArrayList<Teaching_situation> queryTeaSitu(){

        ArrayList<Teaching_situation> list = new ArrayList<Teaching_situation>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet set = null;

        String sql = "select * from teaching_situation";
        // 获取连接对象
        try {
            connection = DBHelper.getConn();
            ps = connection.prepareStatement(sql);
            set = ps.executeQuery();    // 执行查询

            while(set.next()){
                Teaching_situation res = new Teaching_situation();
                res.setId(set.getInt(1));
                res.setMajor_name(set.getString(2));
                res.setAdvantage_major(set.getString(3));
                res.setSet_time(set.getInt(4));
                res.setTotal_period(set.getInt(5));
                res.setTotal_credit(set.getFloat(6));
                res.setParctice_rate(set.getString(7));

                list.add(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
                ps.close();
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    // 查带头人
    public ArrayList<Major_leader> queryMajLea(){

        ArrayList<Major_leader> list = new ArrayList<Major_leader>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet set = null;

        String sql = "select * from major_leader";
        // 获取连接对象
        try {
            connection = DBHelper.getConn();
            ps = connection.prepareStatement(sql);
            set = ps.executeQuery();    // 执行查询

            while(set.next()){
                Major_leader res = new Major_leader();
                res.setId(set.getInt(1));
                res.setCollege(set.getString(2));
                res.setMajor_num(set.getInt(3));
                res.setLeader_num(set.getInt(4));
                res.setSenior_num(set.getInt(5));
                res.setSenior_rate(set.getString(6));
                res.setPhd_num(set.getInt(7));
                res.setPhd_rate(set.getString(8));

                list.add(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
                ps.close();
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    // 查带头人饼图
    public Leader_situation queryLeaSitu(){

        Leader_situation leader_situation = new Leader_situation();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet set = null;

        String sql = "select * from leader_situation";
        // 获取连接对象
        try {
            connection = DBHelper.getConn();
            ps = connection.prepareStatement(sql);
            set = ps.executeQuery();    // 执行查询

            while(set.next()){
               leader_situation.setId(set.getInt(1));
               leader_situation.setPhD_num(set.getInt(2));
               leader_situation.setMaster_num(set.getInt(3));
               leader_situation.setOther_num(set.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
                ps.close();
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return leader_situation;

    }
    // 查学校情况
    public School_situation querySchSitu(){

        School_situation school_situation = new School_situation();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet set = null;

        String sql = "select * from school_situation";
        // 获取连接对象
        try {
            connection = DBHelper.getConn();
            ps = connection.prepareStatement(sql);
            set = ps.executeQuery();    // 执行查询

            while(set.next()){
                school_situation.setId(set.getInt(1));
                school_situation.setMajor_num(set.getInt(2));
                school_situation.setTea_stu_rate(set.getString(3));
                school_situation.setDegree_rate(set.getString(4));
                school_situation.setPostdoc_station(set.getInt(5));
                school_situation.setStress_subject(set.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
                ps.close();
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return school_situation;
    }

    // 查人事情况
    public Personnel_situation queryPerSitu(){

        Personnel_situation personnel_situation = new Personnel_situation();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet set = null;

        String sql = "select * from personnel_situation";
        // 获取连接对象
        try {
            connection = DBHelper.getConn();
            ps = connection.prepareStatement(sql);
            set = ps.executeQuery();    // 执行查询

            while(set.next()){
                personnel_situation.setId(set.getInt(1));
                personnel_situation.setTeacher_num(set.getInt(2));
                personnel_situation.setTeacher_this(set.getInt(3));
                personnel_situation.setTeacher_outer(set.getInt(4));
                personnel_situation.setTeacher_ftime_num(set.getInt(5));
                personnel_situation.setTeacher_ftime_this(set.getInt(6));
                personnel_situation.setTeacher_ftime_outer(set.getInt(7));
                personnel_situation.setExperiment_num(set.getInt(8));
                personnel_situation.setExperiment_title(set.getInt(9));
                personnel_situation.setExperiment_ntitle(set.getInt(10));
                personnel_situation.setCourse_num(set.getInt(11));
                personnel_situation.setCourse_experiment(set.getInt(12));
                personnel_situation.setCourse_theory(set.getInt(13));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
                ps.close();
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return personnel_situation;
    }
    //根据专业名查所有（专业画像信息）

    public ArrayList<One_major> queryAllPortrait_Info(String major){

        ArrayList<One_major> list = new ArrayList<One_major>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet set = null;

        String sql = "select * from one_major where major_name = "+ "'" + major + "'";

        // 获取连接对象
        try {
            connection = DBHelper.getConn();
            ps = connection.prepareStatement(sql);
            set = ps.executeQuery();    // 执行查询

            while(set.next()){
                One_major res = new One_major();
                res.setId(set.getInt(1));
                res.setMajor_name(set.getString(2));
                res.setStudent_num(set.getInt(3));
                res.setCollege(set.getString(4));
                res.setTeacher_num(set.getInt(5));
                res.setMajor_code(set.getString(6));
                res.setPeriod_num(set.getInt(7));
                res.setCredit_num(set.getInt(8));
                res.setTitle_professor(set.getInt(9));
                res.setTitle_asprofessor(set.getInt(10));
                res.setTitle_other(set.getInt(11));
                res.setDegree_doctor(set.getInt(12));
                res.setDegree_master(set.getInt(13));
                res.setDegree_other(set.getInt(14));
                res.setEnrollment_planned(set.getInt(15));
                res.setEnrollment_actual(set.getInt(16));
                res.setEnrollment_first(set.getInt(17));
                res.setEnrollment_register(set.getInt(18));
                res.setLab_basic_num(set.getInt(19));
                res.setLab_basic_course(set.getInt(20));
                res.setLab_prof_num(set.getInt(21));
                res.setLab_prof_course(set.getInt(22));
                res.setCredit_experiment(set.getString(23));
                res.setCredit_nexperiment(set.getString(24));
                res.setGraduate(set.getInt(25));
                res.setGraduation_rate(set.getString(26));
                res.setEmployment_rate(set.getString(27));
                res.setProfessors_rate(set.getString(28));
                res.setJunior_prof_rate(set.getString(29));
                res.setSeniorTea_rate(set.getString(30));
                res.setMasters_degree_rate(set.getString(31));
                res.setTea_under35_rate(set.getString(32));
                res.setTeanum_under35(set.getInt(33));
                res.setTeanum_36to45(set.getInt(34));
                res.setTeanum_46to55(set.getInt(35));
                res.setTeanum_over56(set.getInt(36));
                res.setFirst_volun_rate(set.getString(37));
                res.setRegistration_rate(set.getString(38));
                res.setReqCourse_credits(set.getInt(39));
                res.setEleCourse_credits(set.getInt(40));
                res.setIntePractice_credits(set.getInt(41));
                res.setExtraActiv_credits(set.getInt(42));


                list.add(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
                ps.close();
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

}
