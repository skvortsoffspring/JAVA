package com.example.lab_8;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

@WebServlet(name = "AAA", value = "/aaa")
public class AAA extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        var httpPost = new HttpGet("http://localhost:8080/Lab_8/bbb");

        URI uri = null;
        try {
            uri = new URIBuilder(
                    httpPost.getURI())
                    .addParameter("param1", "val1")
                    .addParameter("param2", "val2")
                    .addParameter("param3", "val3")
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        httpPost.setURI(uri);
        httpPost.addHeader("header1", "head1");
        httpPost.addHeader("header2", "head2");
        httpPost.addHeader("header3", "head3");

        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

        Scanner sc = new Scanner(httpResponse.getEntity().getContent());
        PrintWriter out = response.getWriter();
        response.setStatus(httpResponse.getStatusLine().getStatusCode());

        while (sc.hasNext()) {
            out.println((sc.nextLine()));
        }

        var resHeaders = httpResponse.getAllHeaders();

        out.println("<h5 align=center>Lab 8 servlet: AAA</h5>");
        out.println("<h6 align=center> Request </h6>");
        out.println("<table border=1 align=center width=400>\n" +
                "<tr bgcolor=\"#FFAD00\">\n" +
                "<th>Header Name<th>Header Value");
        for (var header : resHeaders) {
            out.println("<tr><td>" + header.getName());
            out.println("<td>" + header.getValue() + "</tr>");
        }

        out.println("</table></body></html>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}