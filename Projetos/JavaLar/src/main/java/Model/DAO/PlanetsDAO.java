package Model.DAO;

import Control.Calculations.Calculation;
import Model.Connection.ConnectionFactory;
import Model.Entities.BugsDevs.BugsDevs;
import Model.Entities.Components.Planets;
import Control.ExecutableMove;

import javax.swing.*;
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
        List<Planets> planets = ExecutableMove.planetsList;

        getHoras(planets);
        getQuadrant();
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
            stmt.setString(3, "AE_1500.csv");


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


//            for(int i = 0; i < planets.size(); i++){
//                stmt.setInt(i + 4, planets.get(i).getHitBugs());
//            }
//            for(int i = 0; i < planets.size() ; i++){
//                stmt.setInt(i + 11, planets.get(i).getHitDevs());
//            }
//            for(int i = 0; i < velocity.size(); i++){
//                stmt.setInt(i + 18, velocity.get(i));
//            }
//            for(int i = 0; i < hours.size(); i++){
//                stmt.setInt(i + 25, hours.get(i));
//            }
//            for(int i = 0; i < planets.size(); i++){
//                stmt.setInt(i + 32, planets.get(i).getYears());
//            }

            stmt.setInt(39, bugsQuadOne);
            stmt.setInt(40, bugsQuadTwo);
            stmt.setInt(41, bugsQuadThree);
            stmt.setInt(42, bugsQuadFour);
            stmt.setInt(43, devsQuadOne);
            stmt.setInt(44, devsQuadTwo);
            stmt.setInt(45, devsQuadThree);
            stmt.setInt(46, devsQuadFour);



            stmt.executeUpdate();
            System.out.println("Insertion successful!");
            //JOptionPane.showMessageDialog(null, "Insertion successful!", "Success", JOptionPane.OK_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inserting data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error inserting data: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }




    public List<String[]> getJavaLar(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> javaLar = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM javalar where id < 1000");
            rs = stmt.executeQuery();

            while (rs.next()) {
                String[] datas = new String[45];

                datas[0] = rs.getString("nome");
                datas[1] = rs.getString("matricula");
                datas[2] = rs.getString("nome_arquivo");

                for (int i = 5; i <= 46; i++) {
                    datas[i - 2] = String.valueOf(rs.getInt(i));
                }
                javaLar.add(datas);
            }
            JOptionPane.showMessageDialog(null, "Data read successfully!");

        }catch (Exception e){

            JOptionPane.showMessageDialog(null, "Error reading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error reading data: " + e.getMessage());

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return javaLar;

    }

    public void imprimirLinhas(String[] linha) {
        for (String s : linha) {
            System.out.println(s);
        }
    }

    private  void getVelocity(List<Planets> planets){
        for (Planets planet : planets) {
            velocity.add(calculation.mediaVelocity(planet));
        }
    }

    private void getHoras(List<Planets> planets){
        for (Planets planet : planets) {
            hours.add(calculation.quantityDays(planet.getInstants(), planet.getRotation()));
        }
    }

    private void getQuadrant() {
        Integer[] quadOneTwoBugs = Calculation.northEntity(BugsDevs.getBugs());
        bugsQuadOne = quadOneTwoBugs[0];
        bugsQuadTwo = quadOneTwoBugs[1];

        Integer[] quadThreeFourBugs = Calculation.southEntity(BugsDevs.getBugs());
        bugsQuadThree = quadThreeFourBugs[0];
        bugsQuadFour = quadThreeFourBugs[1];

        Integer[] quadOneTwoDevs = Calculation.northEntity(BugsDevs.getDevs());
        devsQuadOne = quadOneTwoDevs[0];
        devsQuadTwo = quadOneTwoDevs[1];

        Integer[] quadThreeFourDevs = Calculation.southEntity(BugsDevs.getDevs());
        devsQuadThree = quadThreeFourDevs[0];
        devsQuadFour = quadThreeFourDevs[1];
    }
}

