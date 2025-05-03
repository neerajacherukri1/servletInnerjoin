package com.neoteric;

public class Student {
    private int stuId;
    private String stuName;
    private int stuClass;

    public Student(int stuId, String stuName, int stuClass) {

        this.stuId=stuId;
        this.stuName=stuName;
        this.stuClass=stuClass;

    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuClass() {
        return stuClass;
    }

    public void setStuClass(int stuClass) {
        this.stuClass = stuClass;
    }
}
