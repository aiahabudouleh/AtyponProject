package DAO;

import objects.Journal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JournalsDAO {

    /**
     * MySQL Queries.
     */
    private String checkJournal = "select * from journals where journal_name varchar=?";
    private static String appendJournal = "insert into journals (journal_name, publisher_name , publisher_location, publisher_id,user_name,issn_ppub,issn_epub) values(?,?,?,?,?,?,?)";
    private static String selectJournals = "select * from journals";
    private static Connection connection = null;
    private static PreparedStatement statement = null;


    /**
     * Prevent initiating instances.
     */
    private JournalsDAO() {
    }


    private static void connect() {
        connection = Database.connect();
    }

    /**
     * @param journal
     */
    public static void appendJournal(Journal journal) {
        connect();
        prepareStatement(appendJournal);
        setAppendJournalParameters(journal);
        try {
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: Journals DAO, executeUpdate");
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param str: SQL query
     */
    private static void prepareStatement(String str) {
        try {
            statement = connection.prepareStatement(str);
        } catch (Exception e) {
            System.out.println("error: Journals DAO, prepareStatementError");
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param journal
     */
    private static void setAppendJournalParameters(Journal journal) {
        try {
            statement.setString(1, journal.getJournalName());
            statement.setString(2, journal.getPublisherName());
            statement.setString(3, journal.getPublisherLocation());
            statement.setString(4, journal.getPublisherId());
            statement.setString(5, journal.getUserName());
            statement.setString(6, journal.getIssnPpub());
            statement.setString(7, journal.getIssnEpub());
        } catch (Exception e) {
            System.out.println("error: Journals DAO, setStatementParameterError");
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Journal> getAllJournals() {
        ArrayList<Journal> journals = new ArrayList<>();
        ResultSet resultSet = null;
        connect();
        prepareStatement(selectJournals);
        String journalName, publisherName, publisherLocation, publisherID, userName, issnPpub, issnEpub;

        try {
            resultSet = statement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error : Journal DAO");
            System.out.println(e.getMessage());
        }

        while (true) {
            try {
                if (resultSet.next() == false) break;

                journalName = resultSet.getString("journal_name");
                publisherName = resultSet.getString("publisher_name");
                publisherLocation = resultSet.getString("publisher_location");
                publisherID = resultSet.getString("publisher_id");
                userName = resultSet.getString("user_name");
                issnPpub = resultSet.getString("issn_ppub");
                issnEpub = resultSet.getString("issn_epub");
                journals.add(new Journal(journalName, publisherName, publisherLocation, publisherID, userName, issnPpub, issnEpub));

            } catch (Exception e) {
                System.out.println("Error : Journal DAO, <Select * from journals>");
                System.out.println(e.getMessage());
            }

        }
        closeConnection();
        return journals;
    }

    private static void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println("Error : Can't close connection");
            System.out.println(e.getMessage());
        }
    }

}
