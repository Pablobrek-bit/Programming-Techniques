package model.Connection;


import java.sql.*;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://da_java.mysql.dbaas.com.br/da_java";
    private static final String username = "da_java";
    private static final String password = "Tecnicas*2023@";


    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(Connection con){

        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);

        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);

        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
