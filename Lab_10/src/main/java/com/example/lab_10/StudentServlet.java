package com.example.lab_10;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "b", urlPatterns = "/students/*")
public class StudentServlet extends HttpServlet {
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
        var arrPath = request.getPathInfo().split("/");
        var id = Integer.parseInt(arrPath[arrPath.length -1]);
        var array = new ArrayList<Student>();

        try (var prepareStatement = connection.prepareStatement("select * from student where id = ?")){

            prepareStatement.setInt(1, id);
            var result = prepareStatement.executeQuery();

            while (result.next()){
                array.add(new Student(
                        result.getShort("id"),
                        result.getString("name"),
                        result.getString("phone"),
                        result.getString("email")
                ));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        request.setAttribute("students", array);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }

    @SneakyThrows
    public void destroy() {
        connection.close();
    }
}
