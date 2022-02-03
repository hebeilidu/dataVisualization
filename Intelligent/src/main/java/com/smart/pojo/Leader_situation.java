package com.smart.pojo;

public class Leader_situation {
    private int id;
    private int PhD_num;
    private int master_num;
    private int other_num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhD_num() {
        return PhD_num;
    }

    public void setPhD_num(int phD_num) {
        PhD_num = phD_num;
    }

    public int getMaster_num() {
        return master_num;
    }

    public void setMaster_num(int master_num) {
        this.master_num = master_num;
    }

    public int getOther_num() {
        return other_num;
    }

    public void setOther_num(int other_num) {
        this.other_num = other_num;
    }

    @Override
    public String toString() {
        return "Leader_situation{" +
                "id=" + id +
                ", PhD_num=" + PhD_num +
                ", master_num=" + master_num +
                ", other_num=" + other_num +
                '}';
    }

}
