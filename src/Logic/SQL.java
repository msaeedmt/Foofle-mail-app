package Logic;

import java.sql.*;

public class SQL {
    private Connection connection=null;
    private CallableStatement statement=null;

    public SQL() {
        connection();
    }

    public void connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3307/foofle", "saeed", "saeed@1379");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addUser(String username,String password) throws SQLException {
        statement = connection.prepareCall("{call addNewUser(?, ?)}");
        statement.setString(1,username);
        statement.setString(2,password);
        statement.execute();
        statement.close();
    }
}

