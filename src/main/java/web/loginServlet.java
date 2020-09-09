package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@WebServlet("/test")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String userName=req.getParameter("userName");
        String password=req.getParameter("password");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");

        out.println("<head>");

        out.println("<title>Hello World</title>");

        out.println("</head>");

        out.println("<body>");

        out.println("<h1>"+userName+"</h1>");

        out.println("<h1>"+password+"</h1>");

        out.println("</body>");

        out.println("</html>");


    }
}
