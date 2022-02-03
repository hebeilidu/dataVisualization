package com.smart.pojo;

public class Teaching_situation {


    private int id;
    private String major_name;
    private String advantage_major;
    private int set_time;
    private int total_period;
    private float total_credit;
    private String parctice_rate;

    public Teaching_situation() {


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

    public String getAdvantage_major() {
        return advantage_major;
    }

    public void setAdvantage_major(String advantage_major) {
        this.advantage_major = advantage_major;
    }

    public int getSet_time() {
        return set_time;
    }

    public void setSet_time(int set_time) {
        this.set_time = set_time;
    }

    public int getTotal_period() {
        return total_period;
    }

    public void setTotal_period(int total_period) {
        this.total_period = total_period;
    }

    public float getTotal_credit() {
        return total_credit;
    }

    public void setTotal_credit(float total_credit) {
        this.total_credit = total_credit;
    }

    public String getParctice_rate() {
        return parctice_rate;
    }

    public void setParctice_rate(String parctice_rate) {
        this.parctice_rate = parctice_rate;
    }

    public Teaching_situation(int id, String major_name, String advantage_major, int set_time, int total_period, float total_credit, String parctice_rate) {
        this.id = id;
        this.major_name = major_name;
        this.advantage_major = advantage_major;
        this.set_time = set_time;
        this.total_period = total_period;
        this.total_credit = total_credit;
        this.parctice_rate = parctice_rate;
    }

    @Override
    public String toString() {
        return "Teaching_situation{" +
                "id=" + id +
                ", major_name='" + major_name + '\'' +
                ", advantage_major='" + advantage_major + '\'' +
                ", set_time=" + set_time +
                ", total_period=" + total_period +
                ", total_credit=" + total_credit +
                ", parctice_rate=" + parctice_rate +
                '}';
    }

}
