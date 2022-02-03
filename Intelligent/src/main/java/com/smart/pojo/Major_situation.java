package com.smart.pojo;

public class Major_situation {
    private int id;
    private String major_name;
    private int establish_time;
    private int teacher;
    private int teacher_foreign;
    private int teacher_senior;
    private int student_bachelor;
    private int student_networth;
    private int graduates;
    private Float employment_rate;

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

    public int getEstablish_time() {
        return establish_time;
    }

    public void setEstablish_time(int establish_time) {
        this.establish_time = establish_time;
    }

    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    public int getTeacher_foreign() {
        return teacher_foreign;
    }

    public void setTeacher_foreign(int teacher_foreign) {
        this.teacher_foreign = teacher_foreign;
    }

    public int getTeacher_senior() {
        return teacher_senior;
    }

    public void setTeacher_senior(int teacher_senior) {
        this.teacher_senior = teacher_senior;
    }

    public int getStudent_bachelor() {
        return student_bachelor;
    }

    public void setStudent_bachelor(int student_bachelor) {
        this.student_bachelor = student_bachelor;
    }

    public int getStudent_networth() {
        return student_networth;
    }

    public void setStudent_networth(int student_networth) {
        this.student_networth = student_networth;
    }

    public int getGraduates() {
        return graduates;
    }

    public void setGraduates(int graduates) {
        this.graduates = graduates;
    }

    public Float getEmployment_rate() {
        return employment_rate;
    }

    public void setEmployment_rate(Float employment_rate) {
        this.employment_rate = employment_rate;
    }

    @Override
    public String toString() {
        return "Major_situation{" +
                "id=" + id +
                ", major_name='" + major_name + '\'' +
                ", establish_time=" + establish_time +
                ", teacher=" + teacher +
                ", teacher_foreign=" + teacher_foreign +
                ", teacher_senior=" + teacher_senior +
                ", student_bachelor=" + student_bachelor +
                ", student_networth=" + student_networth +
                ", graduates=" + graduates +
                ", employment_rate=" + employment_rate +
                '}';
    }
}
