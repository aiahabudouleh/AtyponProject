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
import java.io.PrintWriter;

@WebServlet(name = "servlets.RegisterServlet", urlPatterns = {"/register"})

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * Get registration information from its view register.jsp.
         * */
        String usrename = request.getParameter("username");
        String email = request.getParameter("email");

        String password = request.getParameter("password");
        password = Crypto.encryptThisString(password);

        String repassword = request.getParameter("repassword");
        repassword = Crypto.encryptThisString(repassword);


        /**
         * Verify login data from login database
         * */
        if (UsersDAO.isCorrectLogin(usrename, password)) {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('User name in use, find another one');");
            pw.println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.include(request, response);
        } else if (password.equals(repassword) == false) {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Passwords are not equals');");
            pw.println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.include(request, response);
        } else {
            //Update database
            User user = new User(usrename, password, email, "user", 0);
            UsersDAO.appendUser(user);
            response.sendRedirect("welcome.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
