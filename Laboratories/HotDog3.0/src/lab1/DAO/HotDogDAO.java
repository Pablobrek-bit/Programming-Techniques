package lab1.DAO;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import lab1.Connection.ConnectionFactory;
import lab1.Model.People.Enums.Additional;
import lab1.Model.People.HotDog.HotDog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotDogDAO {

    public static void createHotDog(HotDog hotDog, Double value){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO hotdog (proteina, bebida, queijo, adicionais, valor) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, String.valueOf(hotDog.getProtein()));
            stmt.setString(2, String.valueOf(hotDog.getDrink()));
            stmt.setString(3, String.valueOf(hotDog.getCheese()));
            stmt.setString(4, String.join(";", getAdditional(hotDog.getAdditional())));
            stmt.setDouble(5, value);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static void deleteHotDog(HotDog hotDog){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM hotdog WHERE proteina = ? AND bebida = ? AND queijo = ? AND adicionais = ?");
            stmt.setString(1, String.valueOf(hotDog.getProtein()));
            stmt.setString(2, String.valueOf(hotDog.getDrink()));
            stmt.setString(3, String.valueOf(hotDog.getCheese()));
            stmt.setString(4, String.join(";", getAdditional(hotDog.getAdditional())));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

//    public static void updateHotDog(HotDog newHotDog, HotDog oldHotDog){
//        Connection con = ConnectionFactory.getConnection();
//        PreparedStatement stmt = null;
//
//        try {
//            stmt = con.prepareStatement("UPDATE hotdog SET proteina = ?, bebida = ?, queijo = ?, adicionais = ? WHERE proteina = ? AND bebida = ? AND queijo = ? AND adicionais = ?");
//            stmt.setString(1, String.valueOf(newHotDog.getProtein()));
//            stmt.setString(2, String.valueOf(newHotDog.getDrink()));
//            stmt.setString(3, String.valueOf(newHotDog.getCheese()));
//            stmt.setString(4, String.join(";", getAdditional(newHotDog.getAdditional())));
//            stmt.setString(5, String.valueOf(oldHotDog.getProtein()));
//            stmt.setString(6, String.valueOf(oldHotDog.getDrink()));
//            stmt.setString(7, String.valueOf(oldHotDog.getCheese()));
//            stmt.setString(8, String.join(";", getAdditional(oldHotDog.getAdditional())));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            ConnectionFactory.closeConnection(con, stmt);
//        }
//    }

    public static Integer getQuantityHotDogs(Integer matricula){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        Integer quantity = 0;

        try {
            stmt = con.prepareStatement("SELECT COUNT(*) FROM hotdog WHERE matricula = ?");
            stmt.setInt(1, matricula);
            quantity = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return quantity;
    }

    public static Integer getIdHotDogbyIdUser(Integer matricula){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        Integer id = 0;

        try {
            stmt = con.prepareStatement("SELECT id FROM hotdog WHERE matricula = ?");
            stmt.setInt(1, matricula);
            id = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return id;
    }

    private static List<String> getAdditional(List<Additional> additionals){
        List<String> additional = new ArrayList<>();
        for(Additional additional1 : additionals){
            additional.add(String.valueOf(additional1));
        }
        return additional;
    }
}
