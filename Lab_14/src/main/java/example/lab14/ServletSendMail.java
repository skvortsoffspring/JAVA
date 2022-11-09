package example.lab14;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SendMail", value = "/send")
public class ServletSendMail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        var host = getServletContext().getInitParameter("host");
        var port = getServletContext().getInitParameter("port");
        var username = getServletContext().getInitParameter("username");
        var password = getServletContext().getInitParameter("password");
        var mail = request.getParameter("mail");
        var message = request.getParameter("message");
        var topic = request.getParameter("topic");
        EmailUtility.sendEmail(host, port, username, password, mail, topic, message);

        response.getWriter().println("Send mail");
    }

}
