package fr.flanjersi.agenda.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletCondition", urlPatterns = { "/condition" })
public class ServletCondition extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        if(name == null || name.isEmpty()){
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
        else {
            this.getServletContext().getRequestDispatcher("/seconde.jsp").forward(request, response);
        }
    }
}
