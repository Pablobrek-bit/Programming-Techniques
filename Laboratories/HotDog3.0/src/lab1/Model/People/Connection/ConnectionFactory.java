package lab1.Model.People.Connection;

import java.sql.*;

//Classe que vai ser responsavel por abrir e fechar a conexão
public class ConnectionFactory {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/hotdog";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "familiabrek";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }

    public static void closeConnection(Connection con){

        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement st){
        closeConnection(con);

        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement st, ResultSet rs){
        closeConnection(con, st);

        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
