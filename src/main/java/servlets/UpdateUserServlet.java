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
import java.util.ArrayList;

@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/updateUser"})
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * Get updated user information
         * */
        String usrename = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (password.isEmpty() == false)  password = Crypto.encryptThisString(password);
        String privilege = request.getParameter("privilege");
        int id = Integer.parseInt(request.getParameter("id"));


        User oldUser = UsersDAO.getUserbyId(id);

        /**
         * Keep old data and update new only.
         * */
        if (usrename.isEmpty()) usrename = oldUser.getUsername();
        if (password.isEmpty()) password = oldUser.getPassword();
        if (email.isEmpty()) email = oldUser.getEmail();
        if (privilege.isEmpty()) privilege = oldUser.getPrivilege();


        /**
         * Update User and keep its id and unchanged data.
         * */
        User newUser = new User(usrename, password, email, privilege, id);
        UsersDAO.updateUser(newUser);

        ArrayList<User> usersList = UsersDAO.getAllUsers();
        request.setAttribute("users", usersList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("webAdmin/listUsers.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
