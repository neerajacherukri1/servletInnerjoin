package com.neoteric.servlet;

import com.neoteric.dao.StudentMarksDAo;
import com.neoteric.model.StudentMarks;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class StudentMarksServlet extends HttpServlet {



    private StudentMarksDAo dao;

    @Override
    public void init() {
        WebApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        dao = context.getBean(StudentMarksDAo.class);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            try {

                List<StudentMarks> studentMarks = dao.getAllStudentMarks();

                out.println("<html><body><h2>Student Marks</h2>");
                out.println("<table border='1'>");
                out.println("<tr><th>stuId</th><th>stuName</th><th>Class</th><th>Subject</th><th>Marks</th></tr>");

                for (StudentMarks sm : studentMarks) {
                    out.println("<tr>");
                    out.println("<td>" + sm.getStudent().getStuId() + "</td>");
                    out.println("<td>" + sm.getStudent().getStuName() + "</td>");
                    out.println("<td>" + sm.getStudent().getStuClass() + "</td>");
                    out.println("<td>" + sm.getMarks().getSubject() + "</td>");
                    out.println("<td>" + sm.getMarks().getMarks() + "</td>");
                    out.println("</tr>");
                }

                out.println("</table></body></html>");

            } catch (Exception e) {
                out.println("<p>Error: " + e.getMessage() + "</p>");
            }
        }

    }


