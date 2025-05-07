package com.neoteric.dao;

import com.neoteric.model.Marks;
import com.neoteric.model.Student;
import com.neoteric.model.StudentMarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



@Component
public class
StudentMarksDAo {


    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }




        public List<StudentMarks> getAllStudentMarks() throws Exception {
            List<StudentMarks> list = new ArrayList<>();

            String sql = "SELECT s.stuId, s.stuName, s.class, m.subject, m.marks " +
                    "FROM student s INNER JOIN marks m ON s.stuId = m.stuId";



            try (Connection conn = dataSource.getConnection();

                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Student student = new Student(
                            rs.getInt("stuId"),
                            rs.getString("stuName"),
                            rs.getInt("class")
                    );

                    Marks marks = new Marks(
                            rs.getInt("stuId"),
                            rs.getString("subject"),
                            rs.getInt("marks")
                    );

                    StudentMarks studentMark = new StudentMarks(student, marks);
                    list.add(studentMark);
                }
            }

            return list;
        }
    }




