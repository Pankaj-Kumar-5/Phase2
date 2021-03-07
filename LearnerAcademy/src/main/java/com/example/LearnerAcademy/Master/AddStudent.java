package com.example.LearnerAcademy.Master;

import com.example.LearnerAcademy.Entity.MainApp;
import com.example.LearnerAcademy.Entity.MasterList;
import com.example.LearnerAcademy.Entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addStudent")
public class AddStudent extends HttpServlet {
    private static boolean isSuccess = false;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        List<String> teacherList = MasterList.getMasterTeacher();
        List<String> subjectList = MasterList.getMasterSubject();
        List<String> classList1 = MasterList.getMasterCLass();

        PrintWriter out = resp.getWriter();
        out.println("<div align='center' style='border: solid 4px black'>");
        out.println("<h1>Student registration</h1>");
        out.print("<a href='Home.jsp'>Home</a><br><br>");
        out.print("<form action='addStudent' method='post'>");
        out.print("<table>");
        out.print("<tr><td>Student Name:</td><td><input type='text' name='name'/></td></tr>");
        out.print("<tr><td>Class:</td>");
        out.print("<td><select name='className' style='width:150px'>");
        for (String classList : classList1) {
            out.print("<option>" + classList + "</option>");
        }
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td>Subject:</td>");
        out.print("<td><select name='subject' style='width:150px'>");
        for (String subject : subjectList) {
            out.print("<option>" + subject + "</option>");
        }
        out.print("</select>");
        out.print("<tr><td>Teacher:</td>");
        out.print("<td><select name='teacher' style='width:150px'>");
        for (String teacher : teacherList) {
            out.print("<option>" + teacher + "</option>");
        }
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td></td><td colspan='2'><input type='submit' value='Add student'/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        if (isSuccess)
            out.println("Student added successfully");
        out.println("</div>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String className = req.getParameter("className");
        String subject = req.getParameter("subject");
        String teacher = req.getParameter("teacher");
        Student s1 = new Student(name, className, subject, teacher);
        MainApp.addStudent(s1);
        isSuccess = true;
        resp.sendRedirect("addStudent");
    }
}
