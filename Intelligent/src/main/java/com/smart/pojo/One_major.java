package com.smart.pojo;

public class One_major {

    private int id;
    private String major_name;
    private int student_num;
    private String college;
    private int teacher_num;
    private String major_code;
    private int period_num;
    private int credit_num;
    private int title_professor;
    private int title_asprofessor;
    private int title_other;
    private int degree_doctor;
    private int degree_master;
    private int degree_other;
    private int enrollment_planned;
    private int enrollment_actual;
    private int enrollment_first;
    private int enrollment_register;
    private int lab_basic_num;
    private int lab_basic_course;
    private int lab_prof_num;
    private int lab_prof_course;
    private String credit_experiment;
    private String credit_nexperiment;
    private int graduate;
    private String graduation_rate;
    private String employment_rate;
    private  String professors_rate; //授课教授比例
    private  String junior_prof_rate;  //低年级授课教授比例
    private  String seniorTea_rate;  //高级职称教师比例
    private  String tea_under35_rate;  //35岁以下青年教师比例
    private String masters_degree_rate;   //硕博学位教师比例
    private  int teanum_under35;  //35岁以下教师数
    private  int teanum_36to45; //36-45岁以教师数
    private  int teanum_46to55; //46-55岁教师数
    private  int teanum_over56; //56岁以上教师数
    private  String first_volun_rate;   //第一志愿报考率
    private  String  registration_rate;   //报到率
    private  int reqCourse_credits;  //必修课学分
    private  int eleCourse_credits;  //选修课学分
    private  int intePractice_credits;  //集中实践学分
    private  int extraActiv_credits;  //课外活动学分

    @Override
    public String toString() {
        return "One_major{" +
                "id=" + id +
                ", major_name='" + major_name + '\'' +
                ", student_num=" + student_num +
                ", college='" + college + '\'' +
                ", teacher_num=" + teacher_num +
                ", major_code='" + major_code + '\'' +
                ", period_num=" + period_num +
                ", credit_num=" + credit_num +
                ", title_professor=" + title_professor +
                ", title_asprofessor=" + title_asprofessor +
                ", title_other=" + title_other +
                ", degree_doctor=" + degree_doctor +
                ", degree_master=" + degree_master +
                ", degree_other=" + degree_other +
                ", enrollment_planned=" + enrollment_planned +
                ", enrollment_actual=" + enrollment_actual +
                ", enrollment_first=" + enrollment_first +
                ", enrollment_register=" + enrollment_register +
                ", lab_basic_num=" + lab_basic_num +
                ", lab_basic_course=" + lab_basic_course +
                ", lab_prof_num=" + lab_prof_num +
                ", lab_prof_course=" + lab_prof_course +
                ", credit_experiment='" + credit_experiment + '\'' +
                ", credit_nexperiment='" + credit_nexperiment + '\'' +
                ", graduate=" + graduate +
                ", graduation_rate='" + graduation_rate + '\'' +
                ", employment_rate='" + employment_rate + '\'' +
                ", professors_rate='" + professors_rate + '\'' +
                ", junior_prof_rate='" + junior_prof_rate + '\'' +
                ", seniorTea_rate='" + seniorTea_rate + '\'' +
                ", tea_under35_rate='" + tea_under35_rate + '\'' +
                ", masters_degree_rate='" + masters_degree_rate + '\'' +
                ", teanum_under35=" + teanum_under35 +
                ", teanum_36to45=" + teanum_36to45 +
                ", teanum_46to55=" + teanum_46to55 +
                ", teanum_over56=" + teanum_over56 +
                ", first_volun_rate='" + first_volun_rate + '\'' +
                ", registration_rate='" + registration_rate + '\'' +
                ", reqCourse_credits=" + reqCourse_credits +
                ", eleCourse_credits=" + eleCourse_credits +
                ", intePractice_credits=" + intePractice_credits +
                ", extraActiv_credits=" + extraActiv_credits +
                '}';
    }

    public String getProfessors_rate() {
        return professors_rate;
    }

    public void setProfessors_rate(String professors_rate) {
        this.professors_rate = professors_rate;
    }

    public String getJunior_prof_rate() {
        return junior_prof_rate;
    }

    public void setJunior_prof_rate(String junior_prof_rate) {
        this.junior_prof_rate = junior_prof_rate;
    }

    public String getSeniorTea_rate() {
        return seniorTea_rate;
    }

    public void setSeniorTea_rate(String seniorTea_rate) {
        this.seniorTea_rate = seniorTea_rate;
    }

    public String getTea_under35_rate() {
        return tea_under35_rate;
    }

    public void setTea_under35_rate(String tea_under35_rate) {
        this.tea_under35_rate = tea_under35_rate;
    }

    public String getMasters_degree_rate() {
        return masters_degree_rate;
    }

    public void setMasters_degree_rate(String masters_degree_rate) {
        this.masters_degree_rate = masters_degree_rate;
    }

    public int getTeanum_under35() {
        return teanum_under35;
    }

    public void setTeanum_under35(int teanum_under35) {
        this.teanum_under35 = teanum_under35;
    }

    public int getTeanum_36to45() {
        return teanum_36to45;
    }

    public void setTeanum_36to45(int teanum_36to45) {
        this.teanum_36to45 = teanum_36to45;
    }

    public int getTeanum_46to55() {
        return teanum_46to55;
    }

    public void setTeanum_46to55(int teanum_46to55) {
        this.teanum_46to55 = teanum_46to55;
    }

    public int getTeanum_over56() {
        return teanum_over56;
    }

    public void setTeanum_over56(int teanum_over56) {
        this.teanum_over56 = teanum_over56;
    }

    public String getFirst_volun_rate() {
        return first_volun_rate;
    }

    public void setFirst_volun_rate(String first_volun_rate) {
        this.first_volun_rate = first_volun_rate;
    }

    public String getRegistration_rate() {
        return registration_rate;
    }

    public void setRegistration_rate(String registration_rate) {
        this.registration_rate = registration_rate;
    }

    public int getReqCourse_credits() {
        return reqCourse_credits;
    }

    public void setReqCourse_credits(int reqCourse_credits) {
        this.reqCourse_credits = reqCourse_credits;
    }

    public int getEleCourse_credits() {
        return eleCourse_credits;
    }

    public void setEleCourse_credits(int eleCourse_credits) {
        this.eleCourse_credits = eleCourse_credits;
    }

    public int getIntePractice_credits() {
        return intePractice_credits;
    }

    public void setIntePractice_credits(int intePractice_credits) {
        this.intePractice_credits = intePractice_credits;
    }

    public int getExtraActiv_credits() {
        return extraActiv_credits;
    }

    public void setExtraActiv_credits(int extraActiv_credits) {
        this.extraActiv_credits = extraActiv_credits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public int getStudent_num() {
        return student_num;
    }

    public void setStudent_num(int student_num) {
        this.student_num = student_num;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getTeacher_num() {
        return teacher_num;
    }

    public void setTeacher_num(int teacher_num) {
        this.teacher_num = teacher_num;
    }

    public String getMajor_code() {
        return major_code;
    }

    public void setMajor_code(String major_code) {
        this.major_code = major_code;
    }

    public int getPeriod_num() {
        return period_num;
    }

    public void setPeriod_num(int period_num) {
        this.period_num = period_num;
    }

    public int getCredit_num() {
        return credit_num;
    }

    public void setCredit_num(int credit_num) {
        this.credit_num = credit_num;
    }

    public int getTitle_professor() {
        return title_professor;
    }

    public void setTitle_professor(int title_professor) {
        this.title_professor = title_professor;
    }

    public int getTitle_asprofessor() {
        return title_asprofessor;
    }

    public void setTitle_asprofessor(int title_asprofessor) {
        this.title_asprofessor = title_asprofessor;
    }

    public int getTitle_other() {
        return title_other;
    }

    public void setTitle_other(int title_other) {
        this.title_other = title_other;
    }

    public int getDegree_doctor() {
        return degree_doctor;
    }

    public void setDegree_doctor(int degree_doctor) {
        this.degree_doctor = degree_doctor;
    }

    public int getDegree_master() {
        return degree_master;
    }

    public void setDegree_master(int degree_master) {
        this.degree_master = degree_master;
    }

    public int getDegree_other() {
        return degree_other;
    }

    public void setDegree_other(int degree_other) {
        this.degree_other = degree_other;
    }

    public int getEnrollment_planned() {
        return enrollment_planned;
    }

    public void setEnrollment_planned(int enrollment_planned) {
        this.enrollment_planned = enrollment_planned;
    }

    public int getEnrollment_actual() {
        return enrollment_actual;
    }

    public void setEnrollment_actual(int enrollment_actual) {
        this.enrollment_actual = enrollment_actual;
    }

    public int getEnrollment_first() {
        return enrollment_first;
    }

    public void setEnrollment_first(int enrollment_first) {
        this.enrollment_first = enrollment_first;
    }

    public int getEnrollment_register() {
        return enrollment_register;
    }

    public void setEnrollment_register(int enrollment_register) {
        this.enrollment_register = enrollment_register;
    }

    public int getLab_basic_num() {
        return lab_basic_num;
    }

    public void setLab_basic_num(int lab_basic_num) {
        this.lab_basic_num = lab_basic_num;
    }

    public int getLab_basic_course() {
        return lab_basic_course;
    }

    public void setLab_basic_course(int lab_basic_course) {
        this.lab_basic_course = lab_basic_course;
    }

    public int getLab_prof_num() {
        return lab_prof_num;
    }

    public void setLab_prof_num(int lab_prof_num) {
        this.lab_prof_num = lab_prof_num;
    }

    public int getLab_prof_course() {
        return lab_prof_course;
    }

    public void setLab_prof_course(int lab_prof_course) {
        this.lab_prof_course = lab_prof_course;
    }

    public String getCredit_experiment() {
        return credit_experiment;
    }

    public void setCredit_experiment(String credit_experiment) {
        this.credit_experiment = credit_experiment;
    }

    public String getCredit_nexperiment() {
        return credit_nexperiment;
    }

    public void setCredit_nexperiment(String credit_nexperiment) {
        this.credit_nexperiment = credit_nexperiment;
    }

    public int getGraduate() {
        return graduate;
    }

    public void setGraduate(int graduate) {
        this.graduate = graduate;
    }

    public String getGraduation_rate() {
        return graduation_rate;
    }

    public void setGraduation_rate(String graduation_rate) {
        this.graduation_rate = graduation_rate;
    }

    public String getEmployment_rate() {
        return employment_rate;
    }

    public void setEmployment_rate(String employment_rate) {
        this.employment_rate = employment_rate;
    }

}
