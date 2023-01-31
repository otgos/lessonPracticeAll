package com.tpe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FirstServlet", value = "/FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getContextPath()): "+request.getContextPath());
        System.out.println("getContextPath()): "+request.getServletPath());

        System.out.println (request.getParameter("name"));

        String name =request.getParameter("name");

        response.getWriter().append("Served at : ").append("my name is "+name);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
