package lab1.DAO;

import lab1.Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientsHotDogsDAO {

    public static void createClientHotDog(Integer idClient){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        System.out.println("ID CLIENTE: " + idClient);
        Integer idHotDog = HotDogDAO.getIdHotDogbyIdUser(idClient);
        System.out.println("ID HOTDOG: " + idHotDog);

        try {
            stmt = con.prepareStatement("INSERT INTO clientes_hotdogs (id_cliente, id_hotdog) VALUES (?, ?)");
            stmt.setInt(1, idClient);
            stmt.setInt(2, idHotDog);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }


}
