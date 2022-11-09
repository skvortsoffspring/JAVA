package example.lab14;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletReceive", value = "/receive")
public class ServletReceive extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var username = getServletContext().getInitParameter("username");
        var password = getServletContext().getInitParameter("password");
        var imap = getServletContext().getInitParameter("imap");
        response.getWriter().println(EmailUtility.showMessages(username, password, imap));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
