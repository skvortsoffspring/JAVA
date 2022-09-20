package org.example.lab4;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
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
import java.time.LocalTime;
import java.util.Scanner;

@WebServlet(name = "StaticContentServlet", value = "/GoSss/")
public class SSS extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println(LocalTime.now().toString() + "GoSss:init");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
       System.out.println(LocalTime.now().toString() + "GoSss:service");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println(LocalTime.now().toString() + "GoSss:destroy");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
/*        getServletContext()
                .getRequestDispatcher("/GoGgg")
                .forward(request, response);*/
        //response.sendRedirect("index.jsp");

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://localhost:8080/Lab_3/GoGgg");
        URI uri = null;
        try {
            uri = new URIBuilder(httpGet.getURI())
                    .addParameter("firstname", "Igor")
                    .addParameter("lastname", "Skvortsov")
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        httpGet.setURI(uri);

        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        Scanner sc = new Scanner(httpResponse.getEntity().getContent());
        PrintWriter out = response.getWriter();

        response.setStatus(httpResponse.getStatusLine().getStatusCode(), httpResponse.getStatusLine().getReasonPhrase());

        while(sc.hasNext()) {
            out.println((sc.nextLine()));
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

/*        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");*/

     /*   PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("</head>");
        out.println("<body><h1>Post</h1>");
        out.println("<body><h1>Sss</h1>");
        out.println("<body><h1>Lab 3</h1>");
        out.println("<h1>" + request.getParameter("firstname") + "</h1>");
        out.println("<h1>" + request.getParameter("lastname") + "</h1>");
        out.println("</body></html>");*/

        response.setStatus(307);
        response.addHeader("Location", "http://localhost:8080/Lab_3/GoGgg");
        /*response.sendRedirect("http://localhost:8080/Lab_3/GoGgg");*/
    }
}

