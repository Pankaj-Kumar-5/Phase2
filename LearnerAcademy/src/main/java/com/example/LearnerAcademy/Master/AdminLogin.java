package com.example.LearnerAcademy.Master;

import com.example.LearnerAcademy.Entity.MainApp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=  req.getParameter("userName");
        String password=  req.getParameter("password");
        PrintWriter out= resp.getWriter();

        if(MainApp.validateAdmin(userName,password)){
            HttpSession session= req.getSession();
            session.setAttribute("name",userName);
            resp.sendRedirect("Home.jsp");

        }else {
            req.setAttribute("errorMessage", "Invalid user or password");
            RequestDispatcher rd = req.getRequestDispatcher("/AdminLogin.jsp");
            rd.forward(req, resp);
        }
    }



}
