package servlets;

import DAO.UsersDAO;
import utils.Crypto;
import objects.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddUserServlet", urlPatterns = {"/addUser"})
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        password = Crypto.encryptThisString(password);
        String repassword = request.getParameter("repassword");
        repassword = Crypto.encryptThisString(repassword);
        String role = request.getParameter("role");


        String message = "";
        /**
         * Verify login data from login database
         * Already exist account
         * */
        if (UsersDAO.isCorrectLogin(username, password)) {
            message = "Account exist ";
        } else if (password.equals(repassword) == false) {
            message = "Password are not equals";
        } else {

            User user = new User(username, password, email, role, 0);
            UsersDAO.appendUser(user);
            message = "User added successfully";
        }

        request.setAttribute("message", message);
        RequestDispatcher rd = request.getRequestDispatcher("webAdmin/addUser.jsp");
        rd.include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
