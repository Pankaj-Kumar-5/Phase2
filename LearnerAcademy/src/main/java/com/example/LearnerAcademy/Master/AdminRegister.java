package com.example.LearnerAcademy.Master;

import com.example.LearnerAcademy.Entity.Admin;
import com.example.LearnerAcademy.Entity.MainApp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/adminRegister")
public class AdminRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("adminName");
        String email = req.getParameter("adminEmail");
        String password = req.getParameter("adminPassword");
        String phone = req.getParameter("adminPhone");
        String city = req.getParameter("adminCity");
        Admin admin = new Admin(name, email, phone, password, city);

        if (!MainApp.isAdminPresent(name) && !MainApp.isAdminEmail(email)) {
            MainApp.addAdmin(admin);
            HttpSession session= req.getSession();
            session.setAttribute("name",name);
            resp.sendRedirect("Home.jsp");
        } else {
            req.setAttribute("msg", "Username or email is already present");
            RequestDispatcher rd = req.getRequestDispatcher("/AdminRegistration.jsp");
            rd.forward(req, resp);
        }
    }
}
