package lab1.DAO;

import lab1.Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientsHotDogsDAO {

    public static void createClientHotDog(Integer idClient){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        Integer idHotDog = HotDogDAO.getIdHotDogbyIdUser(idClient);

        try {
            stmt = con.prepareStatement("INSERT INTO clientshotdogs (idClient, idHotDog) VALUES (?, ?)");
            stmt.setInt(1, idClient);
            stmt.setInt(2, idHotDog);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }


}
