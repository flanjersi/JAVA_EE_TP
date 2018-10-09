package fr.flanjersi.agenda.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletEL", urlPatterns = { "/el" })
public class ServletEL extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pays = request.getParameter("pays");
        String names[] = request.getParameterValues("name");

        if(pays == null || names == null || names.length < 2 || pays.isEmpty()){
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        this.getServletContext().getRequestDispatcher("/el.jsp").forward(request, response);
    }
}
