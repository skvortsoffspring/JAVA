package com.example.lab_5;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Ttl", value = "/Ttl")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var surname = req.getParameter("surname");
        var lastname = req.getParameter("lastname");
        var sex = req.getParameter("sex");
        resp.getWriter().println("Surname: " + surname);
        resp.getWriter().println("Lastname: " + lastname);
        resp.getWriter().println("Sex: " + sex);
    }
}