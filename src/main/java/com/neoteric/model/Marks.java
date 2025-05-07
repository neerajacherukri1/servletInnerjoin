package com.neoteric.model;

public class Marks {

    private int stuId;
    private String subject;
    private int marks;

    public Marks(int stuId, String subject, int marks) {

        this.stuId=stuId;
        this.subject=subject;
        this.marks=marks;


    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
