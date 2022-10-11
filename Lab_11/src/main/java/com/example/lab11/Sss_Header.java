package com.example.lab11;

import jakarta.servlet.Servlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

@WebServlet(name = "servlet-headers", value = "/Sss_Header")
public class Sss_Header extends HttpServlet implements Servlet {
    public Sss_Header() {
        super();
    }
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        System.out.println("Sss:doGet");
    }

    @SneakyThrows
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) {
        float x = Float.parseFloat(rq.getHeader("Value-X"));
        float y = Float.parseFloat(rq.getHeader("Value-Y"));
        rs.setHeader("Value-Z", String.valueOf(x + y));
        Thread.sleep(10000);
    }
}
