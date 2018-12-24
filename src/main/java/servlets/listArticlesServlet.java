package servlets;

import DAO.ArticlesDAO;
import objects.Structure;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listArticlesServlet", urlPatterns = {"/listArticles"})
public class listArticlesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Structure> articles = ArticlesDAO.listArticles();
        request.setAttribute("articles", articles);
        RequestDispatcher dispatcher = request.getRequestDispatcher("webAdmin/listArticles.jsp");
        dispatcher.forward(request, response);
    }
}
