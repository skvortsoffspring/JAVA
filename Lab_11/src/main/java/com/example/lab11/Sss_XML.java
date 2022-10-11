package com.example.lab11;

import com.example.lab11.util.XXRand;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "Sss_XML", value = "/Sss_XML")
public class Sss_XML extends HttpServlet {
    static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Sss_Rand:doPost");
        int n = Integer.parseInt(request.getHeader("XRand-N"));
        XXRand xxRand = new XXRand(n);
        response.setContentType("text/xml");
        PrintWriter writer = response.getWriter();
        StringBuilder s = new StringBuilder("<?xml version=\"1.0\"  encoding = \"utf-8\" ?><rand>");

        var cycle = (10 - new Random().nextInt(5));

        for (int i = 0; i < cycle; i++)
        {
            s.append("<num>").append(xxRand.Get().toString()).append("</num>");
        }

        s.append("</rand>");
        writer.println(s);
        Thread.sleep(5000);
    }
}
