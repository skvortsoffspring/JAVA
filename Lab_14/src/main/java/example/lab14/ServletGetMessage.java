package example.lab14;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "ServletGetMessage", value = "/getmessage")
public class ServletGetMessage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var username = getServletContext().getInitParameter("username");
        var password = getServletContext().getInitParameter("password");
        var imap = getServletContext().getInitParameter("imap");
        var date = request.getParameter("date");
        response.getWriter().println(EmailUtility.getMessage(username, password, date, imap));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
