package com.smart.pojo;

public class Personnel_situation {
    private int id;
    private int teacher_num;
    private int teacher_this;
    private int teacher_outer;
    private int teacher_ftime_num;
    private int teacher_ftime_this;
    private int teacher_ftime_outer;
    private int experiment_num;
    private int experiment_title;
    private int experiment_ntitle;
    private int course_num;
    private int course_experiment;
    private int course_theory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacher_num() {
        return teacher_num;
    }

    public void setTeacher_num(int teacher_num) {
        this.teacher_num = teacher_num;
    }

    public int getTeacher_this() {
        return teacher_this;
    }

    public void setTeacher_this(int teacher_this) {
        this.teacher_this = teacher_this;
    }

    public int getTeacher_outer() {
        return teacher_outer;
    }

    public void setTeacher_outer(int teacher_outer) {
        this.teacher_outer = teacher_outer;
    }

    public int getTeacher_ftime_num() {
        return teacher_ftime_num;
    }

    public void setTeacher_ftime_num(int teacher_ftime_num) {
        this.teacher_ftime_num = teacher_ftime_num;
    }

    public int getTeacher_ftime_this() {
        return teacher_ftime_this;
    }

    public void setTeacher_ftime_this(int teacher_ftime_this) {
        this.teacher_ftime_this = teacher_ftime_this;
    }

    public int getTeacher_ftime_outer() {
        return teacher_ftime_outer;
    }

    public void setTeacher_ftime_outer(int teacher_ftime_outer) {
        this.teacher_ftime_outer = teacher_ftime_outer;
    }

    public int getExperiment_num() {
        return experiment_num;
    }

    public void setExperiment_num(int experiment_num) {
        this.experiment_num = experiment_num;
    }

    public int getExperiment_title() {
        return experiment_title;
    }

    public void setExperiment_title(int experiment_title) {
        this.experiment_title = experiment_title;
    }

    public int getExperiment_ntitle() {
        return experiment_ntitle;
    }

    public void setExperiment_ntitle(int experiment_ntitle) {
        this.experiment_ntitle = experiment_ntitle;
    }

    public int getCourse_num() {
        return course_num;
    }

    public void setCourse_num(int course_num) {
        this.course_num = course_num;
    }

    public int getCourse_experiment() {
        return course_experiment;
    }

    public void setCourse_experiment(int course_experiment) {
        this.course_experiment = course_experiment;
    }

    public int getCourse_theory() {
        return course_theory;
    }

    public void setCourse_theory(int course_theory) {
        this.course_theory = course_theory;
    }

    @Override
    public String toString() {
        return "Personnel_situation{" +
                "id=" + id +
                ", teacher_num=" + teacher_num +
                ", teacher_this=" + teacher_this +
                ", teacher_outer=" + teacher_outer +
                ", teacher_ftime_num=" + teacher_ftime_num +
                ", teacher_ftime_this=" + teacher_ftime_this +
                ", teacher_ftime_outer=" + teacher_ftime_outer +
                ", experiment_num=" + experiment_num +
                ", experiment_title=" + experiment_title +
                ", experiment_ntitle=" + experiment_ntitle +
                ", course_num=" + course_num +
                ", course_experiment=" + course_experiment +
                ", course_theory=" + course_theory +
                '}';
    }
}
