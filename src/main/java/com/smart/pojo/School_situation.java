package com.smart.pojo;

public class School_situation {
    private int id;
    private int major_num;
    private String tea_stu_rate;
    private String degree_rate;
    private int postdoc_station;
    private int stress_subject;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "School_situation{" +
                "id=" + id +
                ", major_num=" + major_num +
                ", tea_stu_rate='" + tea_stu_rate + '\'' +
                ", degree_rate='" + degree_rate + '\'' +
                ", postdoc_station=" + postdoc_station +
                ", stress_subject=" + stress_subject +
                '}';
    }

    public int getMajor_num() {
        return major_num;
    }

    public void setMajor_num(int major_num) {
        this.major_num = major_num;
    }

    public String getTea_stu_rate() {
        return tea_stu_rate;
    }

    public void setTea_stu_rate(String tea_stu_rate) {
        this.tea_stu_rate = tea_stu_rate;
    }

    public String getDegree_rate() {
        return degree_rate;
    }

    public void setDegree_rate(String degree_rate) {
        this.degree_rate = degree_rate;
    }

    public int getPostdoc_station() {
        return postdoc_station;
    }

    public void setPostdoc_station(int postdoc_station) {
        this.postdoc_station = postdoc_station;
    }

    public int getStress_subject() {
        return stress_subject;
    }

    public void setStress_subject(int stress_subject) {
        this.stress_subject = stress_subject;
    }

}
