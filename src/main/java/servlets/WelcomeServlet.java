package servlets;

import DAO.ArticlesDAO;
import DAO.UsersDAO;
import utils.Crypto;
import objects.Structure;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "servlets.WelcomeServlet" ,urlPatterns = {"/welcome"})
public class WelcomeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * Get username and userpassword from its view (login.jsp) page.
        * */
        String userName=request.getParameter("username");
        String userPassword=request.getParameter("userpassword");

        /** Encrypt password using SA1**/
        userPassword= Crypto.encryptThisString(userPassword);


        /**
         * Verify login data from login database
         * */
         if (UsersDAO.isCorrectLogin(userName,userPassword)) {

             HttpSession loginSession=request.getSession();
             loginSession.setAttribute("username",userName);
             loginSession.setAttribute("userpassword",userPassword);

             String privilege= UsersDAO.getPrivilage(userName,userPassword);
             if (privilege.equals("admin"))  response.sendRedirect("admin/admin.jsp");
             else if (privilege.equals("user")){
                 request.setAttribute("username",userName);
                 List<Structure> list= ArticlesDAO.listArticles();
                 request.setAttribute("articles" , list);
                 RequestDispatcher dispatcher=request.getRequestDispatcher("user.jsp");
                 dispatcher.forward(request,response);
             }
             else response.sendRedirect("webAdmin/webAdminTool.jsp");

         }
        else {
             response.setContentType("text/html");
             PrintWriter pw=response.getWriter();
             pw.println("<script type=\"text/javascript\">");
             pw.println("alert('Invalid Username or Password');");
             pw.println("</script>");
             RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
             rd.include(request, response);
         }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
