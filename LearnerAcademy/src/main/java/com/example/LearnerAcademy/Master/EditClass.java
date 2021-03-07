package com.example.LearnerAcademy.Master;

import com.example.LearnerAcademy.Entity.MainApp;
import com.example.LearnerAcademy.Entity.MasterList;
import com.example.LearnerAcademy.Entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/editCLass")
public class EditClass extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Student s = MainApp.getStudentById(id);
        System.out.println("id->>" + id);

        HttpSession session = req.getSession();
        session.setAttribute("updatedId", s.getsId());

        resp.setContentType("text/html");

        List<String> teacherList = MasterList.getMasterTeacher();
        List<String> subjectList = MasterList.getMasterSubject();
        List<String> classList1 = MasterList.getMasterCLass();

        PrintWriter out = resp.getWriter();
        out.println("<div align='center' style='border: solid 4px black'>");
        out.println("<h1>Student update</h1>");
        out.print("<a href='Home.jsp'>Home</a><br><br>");
        out.print("<form action='editCLass' method='post'>");
        out.print("<table>");
        out.print("<tr><td>Student Name:</td><td><input type='text' name='name' value='" + s.getName() + "'/></td></tr>");
        out.print("<tr><td>Class:</td>");
        out.print("<td><select name='className' style='width:150px'>");
        for (String classList : classList1) {
            if (s.getClassName().equals(classList))
                out.print("<option selected>" + classList + "</option>");
            else
                out.print("<option>" + classList + "</option>");
        }
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td>Subject:</td>");
        out.print("<td><select name='subject' style='width:150px'>");
        for (String subject : subjectList) {
            if (s.getSubjectName().equals(subject))
                out.print("<option selected>" + subject + "</option>");
            else
                out.print("<option>" + subject + "</option>");
        }
        out.print("</select>");
        out.print("<tr><td>Teacher:</td>");
        out.print("<td><select name='teacher' style='width:150px'>");
        for (String teacher : teacherList) {
            if (s.getTeacherName().equals(teacher))
                out.print("<option selected>" + teacher + "</option>");
            else
                out.print("<option>" + teacher + "</option>");
        }
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td></td><td colspan='2'><input type='submit' value='update student'/></td></tr>");
        out.print("</table>");
        out.print("</form>");
        out.println("</div>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int s = (int) session.getAttribute("updatedId");
        String name = req.getParameter("name");
        String className = req.getParameter("className");
        String subject = req.getParameter("subject");
        String teacher = req.getParameter("teacher");
        Student s1 = new Student(name, className, subject, teacher);
        s1.setsId(s);
        MainApp.updateStudent(s1);
        resp.sendRedirect("classReport");
    }
}
