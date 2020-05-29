package Logic;

import java.sql.*;

public class SQL {
    private Connection connection = null;
    private CallableStatement statement = null;

    public SQL() {
        connection();
    }

    public void connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/foofle", "saeed", "saeed@1379");
        } catch (Exception e) {
//            System.out.println(e);
        }
    }

    public void addUser(String username, String password, String phone) throws SQLException {
        statement = connection.prepareCall("{call addNewUser(?, ?, ?)}");
        statement.setString(1, username);
        statement.setString(2, password);
        statement.setString(3, phone);
        statement.execute();
    }

    public void updateInfo(String fName, String lName, String nName, String birthday, String phone, String codeMeli
            , String address, String username, String signUpPhone,String totalPermisson) throws SQLException {
        statement = connection.prepareCall("{call updateInfo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
        statement.setString(1, fName);
        statement.setString(2, lName);
        statement.setString(3, nName);
        statement.setString(4, birthday);
        statement.setString(5, phone);
        statement.setString(6, codeMeli);
        statement.setString(7, address);
        statement.setString(9, totalPermisson);
        statement.setString(8, signUpPhone);
        statement.setString(10,username);
        statement.execute();
        statement.close();
    }

    public void addNews(String title, String content, String username) throws SQLException {
        statement = connection.prepareCall("{call addNews(?, ?, ?)}");
        statement.setString(1, title);
        statement.setString(2, content);
        statement.setString(3, username);
        statement.execute();
        statement.close();
    }

    public ResultSet getNews(String username) throws SQLException {
        statement = connection.prepareCall("{call findNewsByUsername(?)}");
        statement.setString(1, username);
        return statement.executeQuery();
    }

    public ResultSet getInfo(String username) throws SQLException {
        statement = connection.prepareCall("{call findInfoByUsername(?)}");
        statement.setString(1, username);
        return statement.executeQuery();
    }

    public void addInfoToUser(String username) throws SQLException {
        statement = connection.prepareCall("{call addInfoToUser(?, ?, ?, ?, ?, ?, ?, ?)}");
        for (int i = 1; i < 8; i++) {
            statement.setString(i, null);
        }
        statement.setString(8, username);
        statement.execute();
        statement.close();
    }

    public void deleteNews(int id) throws SQLException {
        statement = connection.prepareCall("{call deleteNews(?)}");
        statement.setInt(1, id);
        statement.execute();
        statement.close();
    }

    public ResultSet findUser(String username, String password) throws SQLException {
        statement = connection.prepareCall("{call findUser(?, ?)}");
        statement.setString(1, username);
        statement.setString(2, password);
        return statement.executeQuery();
    }

    public void login(String username) throws SQLException {
        statement = connection.prepareCall("{call addLogIn(?)}");
        statement.setString(1, username);
        statement.execute();
        statement.close();
    }

    public void addEmail(String username, String subject, String content) throws SQLException {
        statement = connection.prepareCall("{call addEmail(?, ?, ?)}");
        statement.setString(1, username);
        statement.setString(2, subject);
        statement.setString(3, content);
        statement.execute();
        statement.close();
    }

//    public void addReceiver(int id, String username) throws SQLException {
////        statement=connection.prepareCall("{call addReceiver(?, ?)}")
//    }

    public ResultSet getSentEmails(String username) throws SQLException {
        statement = connection.prepareCall("{call getSentEmails(?)}");
        statement.setString(1, username);
        return statement.executeQuery();
    }

    public ResultSet findEmail(int id) throws SQLException {
        statement = connection.prepareCall("{call findEmail(?)}");
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    public void addReceivers(String name) throws SQLException {
        statement = connection.prepareCall("{call addReceivers(?) }");
        statement.setString(1, name);
        statement.execute();
        statement.close();
    }

    public ResultSet getReceivers(int id) throws SQLException {
        statement = connection.prepareCall("{call getReceivers(?) }");
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    public ResultSet getReceivedEmails(String name) throws SQLException {
        statement = connection.prepareCall("{call getReceivedEmails(?)}");
        statement.setString(1, name);
        return statement.executeQuery();
    }

    public void deleteEmail(int id) throws SQLException {
        statement = connection.prepareCall("{call deleteEmail(?)}");
        statement.setInt(1, id);
        statement.execute();
        statement.close();
    }

    public void deleteReceiver(int id, String sender) throws SQLException {
        statement = connection.prepareCall("{call deleteReceiver(?, ?)}");
        statement.setInt(1, id);
        statement.setString(2, sender);
        statement.execute();
        statement.close();
    }

    public ResultSet getExceptions(String username) throws SQLException{
        statement=connection.prepareCall("{call getExceptions(?)}");
        statement.setString(1,username);
        return statement.executeQuery();
    }

    public void addException(String username,String dest) throws SQLException {
        statement=connection.prepareCall("{call addExceptionP(?, ?)}");
        statement.setString(1,username);
        statement.setString(2,dest);
        statement.execute();
    }

    public void deleteExceptions(String username) throws SQLException{
        statement=connection.prepareCall("{call removeExceptions(?)}");
        statement.setString(1,username);
        statement.execute();
    }

    public void updatePassword(String username,String password) throws SQLException {
        statement=connection.prepareCall("{call updatePassword(?, ?)}");
        statement.setString(1,username);
        statement.setString(2,password);
        statement.execute();
    }

    public ResultSet getOtherInfos(String username, String dest) throws SQLException {
        statement=connection.prepareCall("{call getOtherInfos(?, ?)}");
        statement.setString(1,username);
        statement.setString(2,dest);
        return statement.executeQuery();
    }
}

