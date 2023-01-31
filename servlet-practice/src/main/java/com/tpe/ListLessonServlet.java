package com.tpe;

import com.tpe.domain.Lesson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListLessonServlet", value = "/ListLessonServlet")
public class ListLessonServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private List<Lesson> list;

    @Override
    public void init() throws ServletException {
        list = new ArrayList<>();
        Lesson lesson1 = new Lesson();
        lesson1.setId(1L);
        lesson1.setName("Advanced Java");
        lesson1.setSubject("MultiThread");

        list.add(lesson1);

        Lesson lesson2 = new Lesson();
        lesson2.setId(2L);
        lesson2.setName("Spring MVC");
        lesson2.setSubject("MVC");
        list.add(lesson2);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // Set up HTML table formatting for the output
        out.println("<html><body>");
        out.println("<h3>Lessons Details</h3>");
        out.println("<table border=1><tr>" + "<td><b>id</b></td>" + "<td><b>Name</b></td>"
                + "<td><b>Subject</b></td></tr>");
        for (Lesson lesson : list) {
            out.println("<tr>" + "<td>" + lesson.getId() + "</td>" + "<td>" + lesson.getName() + "</td>"
                    + "<td>" + lesson.getSubject() + "</td></tr>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
