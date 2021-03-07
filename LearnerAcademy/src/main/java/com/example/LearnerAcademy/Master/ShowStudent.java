package com.example.LearnerAcademy.Master;

import com.example.LearnerAcademy.Entity.MainApp;
import com.example.LearnerAcademy.Entity.MasterList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/showStudent")
public class ShowStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<String> classList1 = MasterList.getMasterCLass();

        PrintWriter out = resp.getWriter();
        out.println("<div align='center' style='border: solid 4px black'>");
        out.println("<h1>Student registration</h1>");
        out.print("<a href='Home.jsp'>Home</a><br><br>");
        out.print("<form action='showStudent' method='post'>");
        out.print("<table>");
        out.print("<tr><td>Class:</td>");
        out.print("<td><select name='className' style='width:150px'>");
        for (String classList : classList1) {
            out.print("<option>" + classList + "</option>");
        }
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td></td><td colspan='2'><input type='submit' value='Show'/></td></tr>");
        out.print("</table>");
        out.print("</form>");
        out.println("</div>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String className = req.getParameter("className");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<div align='center' style='border: solid 4px black; height: 95%' >");
        out.println("<h1>Display Student</h1>");
        out.print("<a href='Home.jsp'>Home</a><br><br>");

        List<String> list = MainApp.getStudentsFromClass(className);

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>S.No</th><th>Name</th></tr>");

        for (int i = 0; i < list.size(); i++) {
            out.print("<tr><td style='text-align:center'>" + (i + 1) + "</td><td style='text-align:center'>" + list.get(i) + "</td></tr>");
        }
        out.print("</table>");
        out.println("</div>");
        out.close();
    }
}
