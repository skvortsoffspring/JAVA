package com.example.lab_9;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Ccc", value = "/Ccc")
public class Ccc extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        String action = String.valueOf(req.getParameter("action"));

        if(action.equals("create")) {
            session.setAttribute("attr", "val");
            resp.getWriter().println("attr create in session");
        }
        else if (action.equals("destroy")) {
            session.removeAttribute("attr");
            resp.getWriter().println("attr destroy in session");
        }

    }
}
