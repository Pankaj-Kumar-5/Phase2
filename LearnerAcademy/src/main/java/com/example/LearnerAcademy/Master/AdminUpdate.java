package com.example.LearnerAcademy.Master;

import com.example.LearnerAcademy.Entity.Admin;
import com.example.LearnerAcademy.Entity.MainApp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminUpdate")
public class AdminUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("adminName");
        String email = req.getParameter("adminEmail");
        String password = req.getParameter("adminPassword");
        String phone = req.getParameter("adminPhone");
        String city = req.getParameter("adminCity");

        Admin admin = new Admin(name, email, phone, password, city);

        if (!MainApp.updateAdmin(admin)) {
            req.setAttribute("msg", "Update was unsuccessful");
            RequestDispatcher rd = req.getRequestDispatcher("/UpdateAdmin.jsp");
            rd.forward(req, resp);
        } else {
            req.setAttribute("msg", "Update was successful");
            RequestDispatcher rd = req.getRequestDispatcher("/UpdateAdmin.jsp");
            rd.forward(req, resp);
        }
    }
}
