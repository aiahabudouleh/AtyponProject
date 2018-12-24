package DAO;

import objects.Structure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class ArticlesDAO {

    /**
     * MySQL Queries.
     *
     * */
    private static String getPath ="select * from articles where doi=?";
    private static String appendArticle = "insert into articles (journal_name, issue_number , doi , path) values(?,?,?,?)";
    private static String appendwhoisDOI ="insert into whoisDOI (title , doi) values (?,?)";
    private static String retriveArticles = "select * from articles";
    private static String retrivewhoisDOI = "select * from whoisDOI";
    private static Connection connection = null;
    private static PreparedStatement statement = null;


    /**
     * Prevent initiating instances.
     */
    private ArticlesDAO() {
    }

    /**
     * @param  mysql
     * @param  structure
    * */
    private static void insertWhosisDOI(String mysql , Structure structure){

        prepareStatement(mysql);

        try {
            statement.setString(1, structure.getTitle());
            statement.setString(2,structure.getDoi() );
        } catch (Exception e) {
            System.out.println("Error : can't set insert AA parameter");
        }

        try {
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: insert Article DAO, executeUpdate");
        }

    }


    /**
     * @param  structure
     * @param path
     * */
    public static void insertArticle(Structure structure, String path) {

        connection = Database.connect();
        prepareStatement(appendArticle);
        setInsertArticleParameter(structure, path);

        try {
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: insert Article DAO, executeUpdate");
            System.out.println(e.getMessage());
        }

        insertWhosisDOI(appendwhoisDOI,structure);
        closeConnection();
    }


    /**
     * @param mysqlStatement
     **/
    private static void prepareStatement(String mysqlStatement) {
        try {
            statement = connection.prepareStatement(mysqlStatement);
        } catch (Exception e) {
            System.out.println("error: Articles DAO, prepareStatementError");
            System.out.println(e.getMessage());
        }
    }


    /**
     * @param structure
     * @param path
     * */
    private static void setInsertArticleParameter(Structure structure, String path) {

        try {
            statement.setString(1, structure.getJournal());
            statement.setInt(2, Integer.valueOf(structure.getIssue()));
            statement.setString(3, structure.getDoi());
            statement.setString(4, path);
        } catch (Exception e) {
            System.out.println("Error : can't set insert article parameter");
        }
    }


    private static void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println("Error : Can't close connection");
            System.out.println(e.getMessage());
        }
    }


    public static ArrayList<Structure> listArticles() {

        /*** Get DOI mapped to title***/
        HashMap<String,String> titleDOI= mapTitle();


        ArrayList<Structure> list = new ArrayList<Structure>();
        ResultSet resultSet = null;
        connection = Database.connect();
        prepareStatement(retriveArticles);

        try {
            resultSet = statement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error : can't execute <select * from articles>");
            System.out.println(e.getMessage());
        }

        String journal="",issue="",doi="",path="",title="";



        while (true) {

            try {
                if (resultSet.next() == false) break;
            } catch (Exception e) {
                System.out.println("Error : resiltSet.next()");
                System.out.println(e.getMessage());
            }

            try {
                journal = resultSet.getString("journal_name");
                issue = String.valueOf(resultSet.getInt("issue_number"));
                doi = resultSet.getString("doi");
                title= titleDOI.get(doi);
                path=resultSet.getString("path");
            } catch (Exception e) {
                System.out.println("Error : get data from resultSet ");
                System.out.println(e.getMessage());
            }

            Structure article=new Structure(journal,issue,title,path);
            article.setDoi(doi);
            list.add(article);

        }


        closeConnection();
        return list;
    }

    private static HashMap<String,String> mapTitle(){

        HashMap<String,String> DOITitle = new HashMap<>();
        String doi="",title="";
        ResultSet resultSet = null;

        connection = Database.connect();
        prepareStatement(retrivewhoisDOI);


        try {
            resultSet = statement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error : can't execute <select * from whoisDOI>");
            System.out.println(e.getMessage());
        }


        while (true) {

            try {
                if (resultSet.next() == false) break;
            } catch (Exception e) {
                System.out.println("Error : resiltSet.next() ");
                System.out.println(e.getMessage());
            }

            try {
                title = resultSet.getString("title");
                doi = resultSet.getString("doi");
                DOITitle.put(doi,title);

            } catch (Exception e) {
                System.out.println("Error : get data from resultSet ");
                System.out.println(e.getMessage());
            }

        }
        closeConnection();
        return DOITitle;
    }


    /**
     * @param doi
     * */
    public static String getArticlePath (String doi){
        connection=Database.connect();
        String path="";
        prepareStatement(getPath);

        try{
            statement.setString(1,doi);
        }catch (Exception e){
            System.out.println("Error: getArticleByPath , set statement parameter");
            System.out.println(e.getMessage());
        }

        ResultSet resultSet=null;

        try {
            resultSet=statement.executeQuery();
        }catch (Exception e){
            System.out.println("Error: getArticleByPath , execute statement");
            System.out.println(e.getMessage());
        }

        try {
            if (resultSet.next() == true) {
                path=resultSet.getString("path");
            }
        }catch (Exception e){
            System.out.println("Error: getArticleByPath , resultSet");
            System.out.println(e.getMessage());
        }
        closeConnection();
        return path;
    }
}
