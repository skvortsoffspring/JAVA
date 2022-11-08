package example.lab13;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "ServletSss", value = "/Sss")
public class ServletSss extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var fileName = request.getParameter("file");
        OutputDoc(new File(getServletContext().getInitParameter("docs") + "\\" + fileName), response);
    }

    protected void OutputDoc(File doc, HttpServletResponse rs)
            throws IOException {
        rs.setContentType("application/msword");
        rs.addHeader("Content-Disposition", "attachment; filename="+
                doc.getName());
        rs.setContentLength(Math.toIntExact(doc.length()));

        FileInputStream in = new FileInputStream(doc);
        BufferedInputStream buf = new BufferedInputStream(in);
        ServletOutputStream out = rs.getOutputStream();
        int readBytes;
        while ((readBytes = buf.read()) != -1)
            out.write(readBytes);
    }
}
