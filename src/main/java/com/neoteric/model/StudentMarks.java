package com.neoteric.model;

public class StudentMarks {

    private Student student;
    private Marks marks;

    public StudentMarks(Student student, Marks marks) {
        this.student=student;
        this.marks=marks;

    }

    public Marks getMarks() {
        return marks;
    }

    public void setMarks(Marks marks) {
        this.marks = marks;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }




}
