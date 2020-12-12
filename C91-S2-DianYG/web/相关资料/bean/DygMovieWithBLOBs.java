package com.yc.demo.example.dyg.bean;

public class DygMovieWithBLOBs extends DygMovie {
    private String intro;

    private String performers;

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getPerformers() {
        return performers;
    }

    public void setPerformers(String performers) {
        this.performers = performers == null ? null : performers.trim();
    }
}