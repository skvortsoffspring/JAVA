package com.example.lab11;

import com.example.lab11.util.XXRand;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "Sss_JSON", value = "/Sss_JSON")
public class Sss_JSON extends HttpServlet {
    public Sss_JSON() {
        super();
    }

    @SneakyThrows
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Sss_JSON:doPost");
        Integer n = Integer.parseInt(rq.getHeader("XRand-N"));
        System.out.println(n);
        XXRand num = new XXRand(n);
        rs.setContentType("text/xml");
        PrintWriter w = rs.getWriter();

        StringBuilder s = new StringBuilder("{\"X\":[");
        var cycle = (10 - new Random().nextInt(5));
        
        for (int i = 0; i < cycle; i++)
        {
            s.append("{\"rand\":").append(num.Get().toString()).append("}").append((i < 9) ? "," : " ");
        }

        s.append("]}");
        System.out.println(s);
        w.println(s);
        Thread.sleep(1000);
    }

}
