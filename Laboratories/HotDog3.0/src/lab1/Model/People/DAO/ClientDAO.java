package lab1.Model.People.DAO;

import lab1.Model.People.Connection.ConnectionFactory;
import lab1.Model.People.Client.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Classe que vai fazer o gerenciamento do banco de dados na table client
public class ClientDAO {

    public static List<Client> listClient(){
        List<Client> clients = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM clients");
            rs = stmt.executeQuery();

            while(rs.next()){
                clients.add(new Client(rs.getString("nome"), rs.getString("id")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clients;
    }

    public static Client findUserbyName(String name){
        Client client = new Client("","");
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM clients WHERE nome = ?");
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            if(rs.next()){
                client = new Client(rs.getString("nome"), rs.getString("id"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return client;
    }

    public static Client updateUser(Client client){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE clients SET name = ? WHERE id = ?");
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return client;
    }

    public static void insertUser(Client client){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        Client clientVerify = findUserbyName(client.getId());


            if(!clientVerify.getId().equals(client.getId())){
                System.out.println("Criando usuario");
                try {
                    stmt = con.prepareStatement("INSERT INTO clients (id, nome, profissao) VALUES (?, ?, ?)");
                    stmt.setString(1, client.getId());
                    stmt.setString(2, client.getName());
                    stmt.setString(3, "null");
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    ConnectionFactory.closeConnection(con, stmt);
                }
            }
    }

    public static Client findUserbyId(String id){
        Client client = new Client("","");
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM clients WHERE id = ?");
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            if(rs.next()){
                client = new Client(rs.getString("nome"), rs.getString("id"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return client;
    }

    public static void deleteUserbyId(String id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM clients WHERE id = ?");
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static void deleteUserbyName(String name){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM clients WHERE nome = ?");
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
