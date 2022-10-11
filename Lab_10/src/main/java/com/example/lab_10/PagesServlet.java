package com.example.lab_10;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "p", urlPatterns = "/students/page/*")
public class PagesServlet  extends HttpServlet {
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
        int id = Integer.parseInt(arrPath[arrPath.length -1]);

        var stm = connection.prepareCall("call PaginationStudents(?)");
        stm.setInt(1, id);
        stm.execute();

        var array = new ArrayList<Student>();

        ResultSet result = stm.getResultSet();

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
    @Override
    public void destroy() {
        connection.close();
    }
}
