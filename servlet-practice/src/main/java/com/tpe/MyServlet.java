package com.tpe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MyServlet", value = "/MyServlet")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

//        if(userName.isEmpty() || password.isEmpty()){
//            response.getWriter().append("Enter user name or password cannot be empty");
//            return;
//        }
//        if(userName.equals("user") && password.equals("pass")){
//            response.getWriter().append("Welcome to my world");
//        }else{
//            response.getWriter().append("login failed");
//        }


        if(!(userName.equals("user") && password.equals("pass"))) {//eger kulllanici user  ve pass degerleriini girerse
            response.getWriter().append("login failed****");
        }else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listLesson");

            dispatcher.forward(request, response);
        }

    }
}
