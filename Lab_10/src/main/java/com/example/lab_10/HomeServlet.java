package com.example.lab_10;

import java.io.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;

@WebServlet(name = "z", urlPatterns = "/")
public class HomeServlet extends HttpServlet {

    Connection connection;
    Statement statement;
    @SneakyThrows
    @Override
    public void init(ServletConfig config) {
        super.init(config);
        if(connection == null)
            connection = new DataBase().connection();
        if(statement == null)
            statement = connection.createStatement();
    }

    @SneakyThrows
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        var result = statement.executeQuery("select * from student");
        var array = new ArrayList<Student>();

        while (result.next()){
            array.add(new Student(
                    result.getShort("id"),
                    result.getString("name"),
                    result.getString("phone"),
                    result.getString("email")
            ));
        }

        request.setAttribute("students", array);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @SneakyThrows
    public void destroy() {
        connection.close();
    }
}