package org.example.lab4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

@WebServlet(name = "daytime", value = "/daytime")
public class TimeOfDay extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        var hour = Integer.parseInt(req.getParameter("hour"));
        if (hour < 8)
            res.sendRedirect("night.jsp");
        else if(hour < 12)
            res.sendRedirect("morning.jsp");
        else if(hour < 17)
            res.sendRedirect("afternoon.jsp");
        else
            res.sendRedirect("evening.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        var hour = Integer.parseInt(req.getParameter("hour"));
        var page = "";
        if (hour < 8)
            page = "night.jsp";
        else if(hour < 12)
            page = "morning.jsp";
        else if(hour < 17)
            page = "afternoon.jsp";
        else
            page = "evening.jsp";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/Lab_4/" + page);

        URI uri = null;
        try {
            uri = new URIBuilder(httpGet.getURI()).build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        httpGet.setURI(uri);

        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        Scanner sc = new Scanner(httpResponse.getEntity().getContent());
        PrintWriter out = res.getWriter();
        res.setStatus(httpResponse.getStatusLine().getStatusCode(), httpResponse.getStatusLine().getReasonPhrase());

        while(sc.hasNext()) {
            out.println((sc.nextLine()));
        }
    }
}