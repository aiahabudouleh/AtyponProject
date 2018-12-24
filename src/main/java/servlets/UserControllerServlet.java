package servlets;

import DAO.ArticlesDAO;
import DAO.UsersDAO;
import objects.User;
import utils.HtmlAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UserControllerServlet", urlPatterns = {"/UserController"})
public class UserControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        String forward = "";
        String message = "";


        if (action.equalsIgnoreCase("delete")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            UsersDAO.deleteUser(userId);
            forward = "webAdmin/listUsers.jsp";
            ArrayList<User> users = UsersDAO.getAllUsers();
            request.setAttribute("users", users);
            message = "Deleted successfully";

        } else if (action.equalsIgnoreCase("edit")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            forward = "webAdmin/updateUser.jsp";
            User oldUser = UsersDAO.getUserbyId(userId);
            request.setAttribute("user", oldUser);

        } else if (action.equalsIgnoreCase("view")) {
            String doi = request.getParameter("article");
            String path = ArticlesDAO.getArticlePath(doi);
            path+=File.separator+"article.html";


            StringBuilder stringBuilder= HtmlAction.getHtmlArticle(path);
            request.setAttribute("html",stringBuilder);

            forward = "articleView.jsp";
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
        requestDispatcher.forward(request, response);

    }
}
