package com.smart.pojo;

public class Major_leader {

    private int id;
    private String college;
    private int major_num;
    private int leader_num;
    private int senior_num;
    private String senior_rate;
    private int phd_num;
    private String phd_rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getMajor_num() {
        return major_num;
    }

    public void setMajor_num(int major_num) {
        this.major_num = major_num;
    }

    public int getLeader_num() {
        return leader_num;
    }

    public void setLeader_num(int leader_num) {
        this.leader_num = leader_num;
    }

    public int getSenior_num() {
        return senior_num;
    }

    public void setSenior_num(int senior_num) {
        this.senior_num = senior_num;
    }

    public String getSenior_rate() {
        return senior_rate;
    }

    public void setSenior_rate(String senior_rate) {
        this.senior_rate = senior_rate;
    }

    public int getPhd_num() {
        return phd_num;
    }

    public void setPhd_num(int phd_num) {
        this.phd_num = phd_num;
    }

    public String getPhd_rate() {
        return phd_rate;
    }

    public void setPhd_rate(String phd_rate) {
        this.phd_rate = phd_rate;
    }

    @Override
    public String toString() {
        return "Major_leader{" +
                "college='" + college + '\'' +
                ", major_num=" + major_num +
                ", leader_num=" + leader_num +
                ", senior_num=" + senior_num +
                ", senior_rate='" + senior_rate + '\'' +
                ", phd_num=" + phd_num +
                ", phd_rate='" + phd_rate + '\'' +
                '}';
    }
}
