package lab1.Model.People.DAO;

import lab1.Model.People.Connection.ConnectionFactory;
import lab1.Model.People.Client.Client;
import lab1.Model.People.Enums.Additional;
import lab1.Model.People.HotDog.HotDog;
import lab1.Services.Value;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotDogDAO {

    public static void createHotDog(HotDog hotDog, Client client){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        Value value = new Value();

        Integer quantity = HotDogDAO.getQuantityHotDogs(Integer.parseInt(client.getId()));
        Double valor = value.calculateValue(hotDog, quantity);
        String proteina = hotDog.getProtein().toString();
        System.out.println("Tipo de proteina: " + proteina);

        System.out.println("Adicionais: " + String.join(";", getAdditional(hotDog.getAdditional())));

        try {
            stmt = con.prepareStatement("INSERT INTO hotdog (proteina, bebida, queijo, adicionais, valor, id_cliente) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, hotDog.getProtein().toString());
            stmt.setString(2, hotDog.getDrink().toString());
            stmt.setString(3, hotDog.getCheese().toString());
            stmt.setString(4, String.join(";", getAdditional(hotDog.getAdditional())));
            stmt.setDouble(5, valor);
            stmt.setInt(6, Integer.parseInt(client.getId()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }



    public static void updateHotDog(HotDog hotDog, Client client){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        Value value = new Value();

        Integer quantity = HotDogDAO.getQuantityHotDogs(Integer.parseInt(client.getId()));
        Double valor = value.calculateValue(hotDog, quantity);

        try {
            stmt = con.prepareStatement("UPDATE hotdog SET proteina = ?, bebida = ?, queijo = ?, adicionais = ?, valor = ? WHERE id_cliente = ?");
            stmt.setString(1, String.valueOf(hotDog.getProtein()));
            stmt.setString(2, String.valueOf(hotDog.getDrink()));
            stmt.setString(3, String.valueOf(hotDog.getCheese()));
            stmt.setString(4, String.join(";", getAdditional(hotDog.getAdditional())));
            stmt.setDouble(5, valor);
            stmt.setInt(6, Integer.parseInt(client.getId()));

            stmt.executeUpdate();
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

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static Integer getQuantityHotDogs(Integer matricula){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer quantity = 0;

        try {
            stmt = con.prepareStatement("SELECT COUNT(*) FROM hotdog WHERE id_cliente = ?");
            stmt.setInt(1, matricula);
            rs = stmt.executeQuery();

            if(rs.next()){
                quantity = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return quantity;
    }

    public static Integer getIdHotDogbyIdUser(Integer matricula){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer id = 0;

        try {
            stmt = con.prepareStatement("SELECT MAX(id) FROM hotdog WHERE id_cliente = ?");
            stmt.setInt(1, matricula);
            rs = stmt.executeQuery();

            if(rs.next()){
                id = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
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

    public static List<HotDog> listHotDogs(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<HotDog> hotDogs = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM hotdog");
            rs = stmt.executeQuery();
            int i = 1;
            while(rs.next()){
                String adicionais = rs.getString("adicionais");
                String[] adicionaisArray = adicionais.split(";");
                List<Additional> additionalList = new ArrayList<>();
                for(String adicional : adicionaisArray){
                    additionalList.add(Additional.valueOf(adicional));
                }
                String proteina = rs.getString("proteina");
                String bebida = rs.getString("bebida");
                String queijo = rs.getString("queijo");

                hotDogs.add(new HotDog(proteina, bebida, queijo, additionalList));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return hotDogs;
    }

    public static List<HotDog> listarHotDogsPorCliente(Integer idCliente) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<HotDog> hotDogs = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM hotdog WHERE id_cliente = ?");
            stmt.setInt(1, idCliente);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String adicionais = rs.getString("adicionais");
                String[] adicionaisArray = adicionais.split(";");
                List<Additional> additionalList = new ArrayList<>();
                for(String adicional : adicionaisArray){
                    additionalList.add(Additional.valueOf(adicional));
                }
                String proteina = rs.getString("proteina");
                String bebida = rs.getString("bebida");
                String queijo = rs.getString("queijo");

                hotDogs.add(new HotDog(bebida, queijo, proteina, additionalList));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return hotDogs;
    }

}
