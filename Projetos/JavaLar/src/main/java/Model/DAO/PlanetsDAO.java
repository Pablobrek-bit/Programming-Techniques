package Model.DAO;

import Control.Calculations.Calculation;
import Model.Archives.manageFiles.ManagementArchiveModel;
import Model.Connection.ConnectionFactory;
import Model.Entities.BugsDevs.BugsDevs;
import Model.Entities.Components.Planets;
import View.ExecutableMove;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlanetsDAO {

    private static final String NAME = "Pablo";
    private static final String MATRICULA = "555989";
    private final Calculation calculation = new Calculation();

    private int bugsQuadOne;
    private int bugsQuadTwo;
    private int bugsQuadThree;
    private int bugsQuadFour;
    private int devsQuadOne;
    private int devsQuadTwo;
    private int devsQuadThree;
    private int devsQuadFour;
    private final List<Integer> hours = new ArrayList<>();
    private final List<Integer> velocity = new ArrayList<>();

    public void insertJavaLar() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Planets> planets = ExecutableMove.planetsList;

        getHoras(planets);
        getQuadrante();
        getVelocity(planets);

        try {
            String sql = "INSERT INTO javalar " +
                    "(nome, matricula, nome_arquivo, bug_python, bug_javascript, bug_ruby, bug_php, " +
                    "bug_csharp, bug_cmais, bug_c, dev_python, dev_javascript, dev_ruby, dev_php, " +
                    "dev_csharp, dev_cmais, dev_c, v_python, v_javascript, v_ruby, v_php, " +
                    "v_csharp, v_cmais, v_c, d_python, d_javascript, d_ruby, d_php, " +
                    "d_csharp, d_cmais, d_c, a_python, a_javascript, a_ruby, a_php, " +
                    "a_csharp, a_cmais, a_c, bug_q1, bug_q2, bug_q3, bug_q4, " +
                    "dev_q1, dev_q2, dev_q3, dev_q4) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, NAME);
            stmt.setString(2, MATRICULA);
            stmt.setString(3, "AE_100.csv");
            stmt.setInt(4, planets.get(0).getHitBugs());
            stmt.setInt(5, planets.get(1).getHitBugs());
            stmt.setInt(6, planets.get(2).getHitBugs());
            stmt.setInt(7, planets.get(3).getHitBugs());
            stmt.setInt(8, planets.get(4).getHitBugs());
            stmt.setInt(9, planets.get(5).getHitBugs());
            stmt.setInt(10, planets.get(6).getHitBugs());
            stmt.setInt(11, planets.get(0).getHitDevs());
            stmt.setInt(12, planets.get(1).getHitDevs());
            stmt.setInt(13, planets.get(2).getHitDevs());
            stmt.setInt(14, planets.get(3).getHitDevs());
            stmt.setInt(15, planets.get(4).getHitDevs());
            stmt.setInt(16, planets.get(5).getHitDevs());
            stmt.setInt(17, planets.get(6).getHitDevs());
            stmt.setInt(18, velocity.get(0));
            stmt.setInt(19, velocity.get(1));
            stmt.setInt(20, velocity.get(2));
            stmt.setInt(21, velocity.get(3));
            stmt.setInt(22, velocity.get(4));
            stmt.setInt(23, velocity.get(5));
            stmt.setInt(24, velocity.get(6));
            stmt.setInt(25, hours.get(0));
            stmt.setInt(26, hours.get(1));
            stmt.setInt(27, hours.get(2));
            stmt.setInt(28, hours.get(3));
            stmt.setInt(29, hours.get(4));
            stmt.setInt(30, hours.get(5));
            stmt.setInt(31, hours.get(6));
            stmt.setInt(32, planets.get(0).getYears());
            stmt.setInt(33, planets.get(1).getYears());
            stmt.setInt(34, planets.get(2).getYears());
            stmt.setInt(35, planets.get(3).getYears());
            stmt.setInt(36, planets.get(4).getYears());
            stmt.setInt(37, planets.get(5).getYears());
            stmt.setInt(38, planets.get(6).getYears());
            stmt.setInt(39, bugsQuadOne);
            stmt.setInt(40, bugsQuadTwo);
            stmt.setInt(41, bugsQuadThree);
            stmt.setInt(42, bugsQuadFour);
            stmt.setInt(43, devsQuadOne);
            stmt.setInt(44, devsQuadTwo);
            stmt.setInt(45, devsQuadThree);
            stmt.setInt(46, devsQuadFour);

//            insertPersonalInfo(stmt);
//            insertBugs(stmt, planets);
//            insertDevs(stmt, planets);
//            insertVelocity(stmt, planets);
//            insertHours(stmt, planets);
//            insertYears(stmt, planets);
//            insertQuadrants(stmt, planets.size());

            stmt.executeUpdate();
            System.out.println("Inserção realizada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir no banco de dados: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }

    private String buildSqlInsertStatement(int planetCount) {
        StringBuilder sql = new StringBuilder("INSERT INTO javalar (nome, matricula, nome_arquivo");

        for (int i = 0; i < planetCount; i++) {
            sql.append(", bug_" + i);
        }

        for (int i = 0; i < planetCount; i++) {
            sql.append(", dev_" + i);
        }

        for (int i = 0; i < planetCount; i++) {
            sql.append(", v_" + i);
        }

        for (int i = 0; i < planetCount; i++) {
            sql.append(", d_" + i);
        }

        for (int i = 0; i < planetCount; i++) {
            sql.append(", a_" + i);
        }

        sql.append(", bug_q1, bug_q2, bug_q3, bug_q4, dev_q1, dev_q2, dev_q3, dev_q4) VALUES (");

        for (int i = 0; i < 5 * planetCount - 1; i++) {
            sql.append("?, ");
        }

        // Adicionei mais 8 placeholders para os quadrantes
        sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        return sql.toString();
    }




    private void insertPersonalInfo(PreparedStatement stmt) throws Exception {
        stmt.setString(1, NAME);
        stmt.setString(2, MATRICULA);
        stmt.setString(3, ManagementArchiveModel.path);
    }

    private void insertBugs(PreparedStatement stmt, List<Planets> planets) throws Exception {
        for (int i = 0; i < planets.size(); i++) {
            stmt.setInt(3 + i, planets.get(i).getHitBugs()); // Ajustei o índice inicial para 3
        }
    }

    private void insertDevs(PreparedStatement stmt, List<Planets> planets) throws Exception {
        int startIndex = 3 + planets.size(); // Ajustei o índice inicial para 3
        for (int i = 0; i < planets.size(); i++) {
            stmt.setInt(startIndex + i, planets.get(i).getHitDevs());
        }
    }

    private void insertVelocity(PreparedStatement stmt, List<Planets> planets) throws Exception {
        int startIndex = 18 + 2 * planets.size();
        for (int i = 0; i < planets.size(); i++) {
            stmt.setInt(startIndex + i, velocity.get(i));
        }
    }

    private void insertHours(PreparedStatement stmt, List<Planets> planets) throws Exception {
        int startIndex = 25 + 3 * planets.size();
        for (int i = 0; i < planets.size(); i++) {
            stmt.setInt(startIndex + i, hours.get(i));
        }
    }

    private void insertYears(PreparedStatement stmt, List<Planets> planets) throws Exception {
        int startIndex = 32 + 4 * planets.size();
        for (int i = 0; i < planets.size(); i++) {
            stmt.setInt(startIndex + i, planets.get(i).getYears());
        }
    }

    private void insertQuadrants(PreparedStatement stmt, int size) throws Exception {
        int startIndex = 3 + 4 * size; // Ajustei o índice inicial para 3
        for (int i = 0; i < 8; i++) { // Adicionei 8 placeholders para os quadrantes
            stmt.setInt(startIndex + i, 0); // Substitua 0 pelos valores reais dos quadrantes
        }
    }

    public void getVelocity(List<Planets> planets){
        for (Planets planet : planets) {
            velocity.add(calculation.mediaVelocity(planet));
        }
    }

    public void getHoras(List<Planets> planets){
        for (Planets planet : planets) {
            hours.add(calculation.quantityDays(planet.getInstants(), planet.getRotation()));
        }
    }

    //    // Método para calcular a distribuição de bugs e devs em cada quadrante
    public void getQuadrante() {
        // Cálculo para bugs nos quadrantes 1 e 2
        Integer[] quadranteUmDoisBugs = Calculation.northEntity(BugsDevs.getBugs());
        bugsQuadOne = quadranteUmDoisBugs[0];
        bugsQuadTwo = quadranteUmDoisBugs[1];

        // Cálculo para bugs nos quadrantes 3 e 4
        Integer[] quadranteTresQuatroBugs = Calculation.southEntity(BugsDevs.getBugs());
        bugsQuadThree = quadranteTresQuatroBugs[0];
        bugsQuadFour = quadranteTresQuatroBugs[1];

        // Cálculo para devs nos quadrantes 1 e 2
        Integer[] quadranteUmDoisDevs = Calculation.northEntity(BugsDevs.getDevs());
        devsQuadOne = quadranteUmDoisDevs[0];
        devsQuadTwo = quadranteUmDoisDevs[1];

        // Cálculo para devs nos quadrantes 3 e 4
        Integer[] quadranteTresQuatroDevs = Calculation.southEntity(BugsDevs.getDevs());
        devsQuadThree = quadranteTresQuatroDevs[0];
        devsQuadFour = quadranteTresQuatroDevs[1];
    }


}

