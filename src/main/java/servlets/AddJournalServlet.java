package servlets;

import DAO.JournalsDAO;
import objects.Journal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddJournalServlet", urlPatterns = {"/addJournal"})
public class AddJournalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Journal journal = new Journal();
        journal.setJournalName(request.getParameter("journal-name"));
        journal.setPublisherName(request.getParameter("publisher-name"));
        journal.setPublisherLocation(request.getParameter("publisher-location"));
        journal.setPublisherId(request.getParameter("publisher-id"));
        journal.setUserName(request.getParameter("user-name"));
        journal.setIssnPpub(request.getParameter("issn-ppub"));
        journal.setIssnEpub(request.getParameter("issn-epub"));

        JournalsDAO.appendJournal(journal);
        journal.createJournalDirectory("/home/aabudouleh/Desktop");

        String message = "Journal created successfully";
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/webAdmin/actionResult.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
