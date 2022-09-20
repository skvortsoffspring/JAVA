package org.example.lab4;


import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

@WebServlet(name = "StaticContentServlet", value = "/GoSss/")
public class SSS extends HttpServlet {

    StringBuilder body = new StringBuilder();

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println(LocalTime.now().toString() + "GoSss:init");
        body.append("<h4>").append(LocalTime.now().toString()).append("GoSss:init").append("</h4>");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
       System.out.println(LocalTime.now().toString() + "GoSss:service");
        body.append("<h4>").append(LocalTime.now().toString()).append("GoSss:service").append("</h4>");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println(LocalTime.now().toString() + "GoSss:destroy");
        body.append("<h4>").append(LocalTime.now().toString()).append("GoSss:destroy").append("</h4>");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("</head>");
        out.println(request.getServerName() + ":" + request.getServerPort() + request.getRequestURI());
        out.println("<body><h1>Get</h1>");
        out.println("<body><h1>Lab 2</h1>");
        out.println("<h1>" + request.getParameter("firstname") + "</h1>");
        out.println("<h1>" + request.getParameter("lastname") + "</h1>");
        out.println("<h1>" + body + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("</head>");
        out.println("<body><h1>Post</h1>");
        out.println("<body><h1>Lab 2</h1>");
        out.println("<h1>" + request.getParameter("firstname") + "</h1>");
        out.println("<h1>" + request.getParameter("lastname") + "</h1>");
        out.println("</body></html>");
    }
}

