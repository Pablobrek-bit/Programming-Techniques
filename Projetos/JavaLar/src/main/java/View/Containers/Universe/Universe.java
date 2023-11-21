package View.Containers.Universe;

import View.Components.MyLabel;
import View.Components.Create;
import Model.Entities.BugsDevs.BugsDevs;
import Model.Entities.Components.Coordinates;
import Model.Entities.Components.Planets;
import View.ExecutableMove;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Universe extends JPanel {

    private static final List<MyLabel> positions = new ArrayList<>();
    private static final List<MyLabel> labeledPositions = new ArrayList<>();
    private static final String JAVA_IMAGE = "src/main/java/View/Sources/java.png";
    private static final String BUG_IMAGE = "src/main/java/View/Sources/Bug.jpg";
    private static final String DEV_IMAGE = "src/main/java/View/Sources/Dev_Second.jpg";
    private static final int ICON_SIZE = 38;

    public Universe() {
        setSetup();
    }

    private void setSetup() {
        setLayout(new GridLayout(15, 15,3,3));
        setOpaque(false);
        setPreferredSize(new Dimension(700, 700));
    }

    public void updates(List<Planets> planets){
        updatePlanets(planets);
        updateBugs();
        updateDevs();
    }

    public void buildUniverse() {
        int contX = 14;

        for (int i = 1; i < 16; i++) {
            for (int j = 5; j <= 19; j++) {
                MyLabel position = new MyLabel(new Coordinates(i + contX, j));
                position.setOpaque(false);

                position.setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 2,true));

                positions.add(position);
                add(position);
            }
            contX -= 2;
        }
    }

    public void updatePlanets(List<Planets> planets) {
        clearOldIcons();
        labeledPositions.clear();


        for (MyLabel position : positions) {
            Coordinates positionCoordinates = position.getCoordinates();

            if (positionCoordinates.getX() == 8 && positionCoordinates.getY() == 12) {
                position.setText("");
                ImageIcon imageIcon = Create.createIcon(JAVA_IMAGE, ICON_SIZE, ICON_SIZE);
                position.setIcon(imageIcon);
                labeledPositions.add(position);
            } else {
                for (Planets planet : planets) {
                    if(planet.isAlive()){
                        Coordinates planetCoordinates = planet.getLocation().getCoord();

                        if (positionCoordinates.equals(planetCoordinates)) {
                            position.setText("");
                            position.setIcon(planet.getImageIcon());
                            labeledPositions.add(position);
                        }
                    }
                }
            }
        }
        revalidate();
        repaint();

    }

    private void clearOldIcons() {
        for (MyLabel position : labeledPositions) {
            position.setIcon(null);
            position.setText("");
        }
    }

    public void updateBugs() {
        updateEntities(BugsDevs.getBugs(), BUG_IMAGE);
//        revalidate();
//        repaint();
    }

    public void updateDevs() {
        updateEntities(BugsDevs.getDevs(), DEV_IMAGE);
//        revalidate();
//        repaint();
    }

    private void updateEntities(List<Coordinates> entities, String imagePath) {
        for (Coordinates entity : entities) {
            for (MyLabel position : positions) {
                if (entity.getX() == position.getCoordinates().getX() && entity.getY() == position.getCoordinates().getY()) {
                    updatePosition(position, Create.createIcon(imagePath, ICON_SIZE, ICON_SIZE));
                }
            }
        }
    }

    private void updatePosition(MyLabel position, ImageIcon icon) {
        position.setText("");
        position.setIcon(icon);
    }



}
