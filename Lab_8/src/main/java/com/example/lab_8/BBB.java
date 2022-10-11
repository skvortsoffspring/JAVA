package com.example.lab_8;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "BBB", value = "/bbb")
public class BBB extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        var reqKeys = request.getParameterMap();
        var reqHeaderNames = request.getHeaderNames();

        ///////////// request ////////////
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("</head>");
        // body
        out.println("<body>\n" +
                "<h5 align=center>" + "Lab 8 servlet: BBB" + "</h5>\n" +
                "<h6 align=center> Response </h6>" +
                "<table border=1 align=center width=400>\n" +
                "<tr bgcolor=\"#FFAD00\">\n" +
                "<th>Header Name<th>Header Value");
        while(reqHeaderNames.hasMoreElements()) {
            String headerName = reqHeaderNames.nextElement();
            out.println("<tr><td>" + headerName);
            out.println("    <td>" + request.getHeader(headerName));
        }

            out.println("<tr bgcolor=\"#00ADFF\"><th>Header Name<th>Header Value");

        for (var key : reqKeys.keySet()) {
            out.println("<tr><td>" + key);
            out.println("<td>" + Arrays.toString(reqKeys.get(key)));
        }
        out.println("</table><br><br>");

        response.addHeader("response-header1", "head1");
        response.addHeader("response-header2", "head2");
        response.addHeader("response-header3", "head3");
    }

    public void destroy() {
    }
}