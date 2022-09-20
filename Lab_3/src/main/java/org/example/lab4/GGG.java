package org.example.lab4;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalTime;
import java.util.Scanner;

@WebServlet(name = "StaticContentServlet", value = "/GoGgg/")
public class GGG extends HttpServlet {

    StringBuilder body = new StringBuilder();

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println(LocalTime.now().toString() + "GoGgg:init");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        HttpServletResponse response = (HttpServletResponse) res;
        response.addHeader("ServletSSS", "Service");
        System.out.println(LocalTime.now().toString() + "GoGgg:service");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println(LocalTime.now().toString() + "GoGgg:destroy");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost( "http://localhost:8080/Lab_3/GoSss");
        URI uri = null;
        try {
            uri = new URIBuilder(httpPost.getURI())
                    .addParameter("firstname", "Igor")
                    .addParameter("lastname", "Skvortsov")
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        httpPost.setURI(uri);

        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

        Scanner sc = new Scanner(httpResponse.getEntity().getContent());
        PrintWriter out = response.getWriter();

        response.setStatus(httpResponse.getStatusLine().getStatusCode());

        while(sc.hasNext()) {
            out.println((sc.nextLine()));
        }*/
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("</head>");
        out.println("<body><h1>Get</h1>");
        out.println("<body><h1>Ggg</h1>");
        out.println("<body><h1>Lab 3</h1>");
        out.println("<h1>" + request.getParameter("firstname") + "</h1>");
        out.println("<h1>" + request.getParameter("lastname") + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("</head>");
        out.println("<body><h1>Post</h1>");
        out.println("<body><h1>Ggg</h1>");
        out.println("<body><h1>Lab 3</h1>");
        out.println("<h1>" + request.getParameter("firstname") + "</h1>");
        out.println("<h1>" + request.getParameter("lastname") + "</h1>");
        out.println("</body></html>");
    }
}

