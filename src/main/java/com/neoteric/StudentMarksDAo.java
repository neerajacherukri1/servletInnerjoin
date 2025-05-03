package com.neoteric;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentMarksDAo {




        private final String url = "jdbc:mysql://localhost:3306/studentschema";
        private final String user = "root";
        private final String password = "Cherukuri@19";

        public List<StudentMarks> getAllStudentMarks() throws Exception {
            List<StudentMarks> list = new ArrayList<>();

            String sql = "SELECT s.stuId, s.stuName, s.class, m.subject, m.marks " +
                    "FROM student s INNER JOIN marks m ON s.stuId = m.stuId";

            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(url, user, password);
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



