package com.example.lab_7;

import com.example.lab_7.model.CBean;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "Ccc", value = "/Ccc")
public class Ccc extends HttpServlet {

    private CBean cBean = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        cBean = new CBean();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/Ccc.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        var paramCBean = req.getParameter("CBean");
        var value1 = req.getParameter("Value1");
        var value2 = req.getParameter("Value2");
        var value3 = req.getParameter("Value3");


        if("new".equals(paramCBean)) {
            cBean = new CBean();
            //req.setAttribute("atrCBean", cBean);
        }
        req.getSession(true).setAttribute("atrCBean", cBean);

        if(!Objects.equals(value1, ""))
            cBean.setValue1(value1);
        if(!Objects.equals(value2, ""))
            cBean.setValue2(value2);
        if(!Objects.equals(value3, ""))
            cBean.setValue3(value3);

        getServletContext()
                .getRequestDispatcher("/Ccc.jsp")
                .forward(req, resp);
    }
}
