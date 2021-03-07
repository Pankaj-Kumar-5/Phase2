package com.example.LearnerAcademy.Master;

import com.example.LearnerAcademy.Entity.MainApp;
import com.example.LearnerAcademy.Entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/classReport")
public class ClassReport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<div align='center' style='border: solid 4px black; height: 95%'>");
        out.println("<a href='Home.jsp'>Home</a>");
        out.println("<h1>Class report</h1>");

        boolean isDelete = false;
        String id = req.getParameter("id");
        if (id != null) {
            MainApp.deleteStudent(id);
            isDelete = true;
        }

        List<Student> list = MainApp.getAllClass();
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>S.No</th><th>Name</th><th>Class</th><th>Subject</th><th>teacher</th><th>Edit</th><th>Delete</th></tr>");
        int count = 1;
        for (Student e : list) {
            out.print("<tr style='text-align:center'><td >" + count + "</td><td>" + e.getName() + "</td><td>" + e.getClassName() + "</td><td>" + e.getSubjectName() + "</td><td>" + e.getTeacherName() + "</td><td><a href='editCLass?id=" + e.getsId() + "'>edit</a></td><td><a href='classReport?id=" + e.getsId() + "'>delete</a></td></tr>");
            count++;
        }
        out.print("</table><br><br>");
        if (isDelete) {
            out.print("delete was successful");
        }
        out.println("</div>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println("delete id" + id);
        MainApp.deleteStudent(id);
        resp.sendRedirect("classReport");
    }
}
