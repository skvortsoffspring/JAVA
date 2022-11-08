package example.lab14;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(name = "ServletSendMail", value = "/SendMail")
public class ServletSendMail extends HttpServlet {
    private EmailUtility emailUtility;

    public ServletSendMail() {
        super();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var host = getServletContext().getInitParameter("host");
        var port = getServletContext().getInitParameter("port");
        var username = getServletContext().getInitParameter("username");
        var password = getServletContext().getInitParameter("password");
        EmailUtility.sendEmail(host, port, username, password, "garikmogilev@gmail.com", "Test", "Test message");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
