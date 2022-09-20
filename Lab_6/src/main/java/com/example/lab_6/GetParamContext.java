package com.example.lab_6;

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

@WebServlet(name = "GetParamContext", value = "/get-param-context")
public class GetParamContext extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var n = request.getParameter("urln");
        var param = getServletContext().getInitParameter("URL" + n);

        if(n.equals("1") || n.equals("2")) {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(param);

            URI uri = null;
            try {
                uri = new URIBuilder(httpGet.getURI()).build();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }

            httpGet.setURI(uri);

            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

            Scanner sc = new Scanner(httpResponse.getEntity().getContent());
            PrintWriter out = response.getWriter();
            response.setStatus(httpResponse.getStatusLine().getStatusCode());

            while (sc.hasNext()) {
                out.println((sc.nextLine()));
            }
        }
        else {
            response.getWriter().println("parameter URLn not found");
        }
    }

    public void destroy() {
    }
}