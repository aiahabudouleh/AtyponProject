package DAO;

import objects.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class UsersDAO {

    /**
     * MySQL Queries.
     */
    private static String checkUser = "select * from users where uname=? and password=?";
    private static String selectAll = "select * from users";
    private static String appendUser = "insert into users (uname , password , privilage, email ) VALUES(?,?,?,?)";
    private static String updateUser = "update users set uname=?,password=?,privilage=?,email=? where id=?";
    private static String deleteUser = "delete from users where id=?";
    private static String getUser = "select * from users where id=?";


    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultLogin = null, resultUser = null;


    /**
     * Prevent initiating instances.
     */
    private UsersDAO() {
    }

    private static void connect() {
        connection = Database.connect();
    }


    /**
     * @param uname
     * @param upass
     */
    public static boolean isCorrectLogin(String uname, String upass) {
        connect();
        prepareStatement(checkUser);
        setCheckUserParameters(uname, upass);
        executeQuery();
        boolean result = checkResult();
        closeConnection();
        return result;
    }

    /**
     * Append new user into users table in dbProject
     * When user do registration, this function will do insert into table mysql
     *
     * @param user
     */
    public static void appendUser(User user) {
        connect();
        prepareStatement(appendUser);
        setAppendUserParameters(user);
        try {
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: Login DAO, executeUpdate");
        }
        closeConnection();
    }

    /**
     * @param str: mysql query
     */
    private static void prepareStatement(String str) {
        try {
            statement = connection.prepareStatement(str);
        } catch (Exception e) {
            System.out.println("error: Users DAO, prepareStatementError");
        }
    }


    /**
     * Update User Function that udpate user information with reference to it's id.
     *
     * @param :user
     */
    public static void updateUser(User user) {
        connect();
        prepareStatement(updateUser);
        setUpdateUserParameters(user);
        try {
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: Login DAO, executeUpdate, Update user");
        }
        closeConnection();
    }

    /**
     * @param uname
     * @param upass
     */
    private static void setCheckUserParameters(String uname, String upass) {
        try {
            statement.setString(1, uname);
            statement.setString(2, upass);
        } catch (Exception e) {
            System.out.println("error: Login DAO, setCheckUserParameters");
        }
    }

    /**
     * @param user
     */
    private static void setAppendUserParameters(User user) {
        try {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getPrivilege());
            statement.setString(4, user.getEmail());
        } catch (Exception e) {
            System.out.println("error: Login DAO, setStatementParameterError");
        }
    }

    /**
     * @param user
     */
    private static void setUpdateUserParameters(User user) {
        try {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getPrivilege());
            statement.setString(4, user.getEmail());
            statement.setInt(5, user.getId());
        } catch (Exception e) {
            System.out.println("error: Login DAO, setStatementParameterError, updateUser");
        }
    }

    /**
     * @param id
     */
    private static void setUserIdParameters(int id) {
        try {
            statement.setInt(1, id);
        } catch (Exception e) {
            System.out.println("error: Login DAO, setStatementParameterError, setUserIdParameters");
            System.out.println(e.getMessage());
        }
    }

    private static void executeQuery() {
        try {
            resultLogin = statement.executeQuery();
        } catch (Exception e) {
            System.out.println("error: Login DAO, executeQuery");
        }
    }

    private static boolean checkResult() {
        try {
            if (resultLogin.next()) return true;
        } catch (Exception e) {
            System.out.println("error: Login DAO, checkResult");
        }

        return false;
    }

    private static void closeConnection() {
        closeResultSt();
        closeStatement();
        closeDb();
    }

    private static void closeResultSt() {

        if (resultLogin == null) return;

        try {
            resultLogin.close();
        } catch (Exception e) {
            System.out.println("error: Login DAO, closeResultSt");
            System.out.println(e.getMessage());
        }
    }

    private static void closeStatement() {
        try {
            statement.close();
        } catch (Exception e) {
            System.out.println("error: Login DAO, closeStatement");
        }
    }

    private static void closeDb() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println("error: Login DAO, closeDb");
        }
    }

    /**
     * @param uname
     * @param upass
     */
    public static String getPrivilage(String uname, String upass) {

        ResultSet userInfo = null;
        String privilage = null;

        connect();
        System.out.println("connect succ ");
        prepareStatement(checkUser);
        System.out.println("checkUser succ ");

        setCheckUserParameters(uname, upass);
        System.out.println("setcheckUser succ ");

        try {
            userInfo = statement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error: getPrivilage");
        }


        try {
            if (userInfo.next()) privilage = userInfo.getString(3);
            System.out.println("Privilege : " + privilage);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return privilage;
    }

    public static ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        ResultSet resultSet = null;
        connect();
        prepareStatement(selectAll);
        String uname, password, email, privilege;
        int id;

        try {
            resultSet = statement.executeQuery();
        } catch (Exception e) {
            System.out.println("error: Login DAO, executeQuery");
            System.out.println(e.getMessage());
        }

        while (true) {

            try {
                if (resultSet.next() == false) break;
            } catch (Exception e) {
                System.out.println("Error: Select * from users.jsp");
                System.out.println(e.getMessage());
            }

            try {
                uname = resultSet.getString("uname");
                password = resultSet.getString("password");
                email = resultSet.getString("email");
                privilege = resultSet.getString("privilage");
                id = resultSet.getInt("id");
                users.add(new User(uname, password, email, privilege, id));

            } catch (Exception e) {
                System.out.println("Error : Getting user data from database.");
                System.out.println(e.getMessage());
            }
        }

        closeConnection();
        return users;
    }

    /**
     * @param id
     */
    public static void deleteUser(int id) {
        connect();
        prepareStatement(deleteUser);
        setUserIdParameters(id);
        try {
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: Login DAO, deleteUser");
            System.out.println(e.getMessage());
        }
        closeConnection();
    }

    /**
     * @param id
     */
    public static User getUserbyId(int id) {
        connect();
        prepareStatement(getUser);
        setUserIdParameters(id);
        try {
            resultUser = statement.executeQuery();
        } catch (Exception e) {
            System.out.println("Error : getUserbyId , execute query.");
            System.out.println(e.getMessage());
        }

        User user = null;

        try {
            if (resultUser.next()) {
                String uname = resultUser.getString("uname");
                String password = resultUser.getString("password");
                String privilage = resultUser.getString("privilage");
                String email = resultUser.getString("email");
                int userId = resultUser.getInt("id");
                user = new User(uname, password, email, privilage, userId);
            }
        } catch (Exception e) {
            System.out.println("Error : getUserById");
            System.out.println(e.getMessage());
        }
        closeConnection();

        return user;
    }
}
