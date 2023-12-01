package View.Containers.Universe;

import View.Components.MyLabel;
import View.Components.Icons;
import Model.Entities.BugsDevs.BugsDevs;
import Model.Entities.Components.Coordinates;
import Model.Entities.Components.Planets;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class Universe extends JPanel {

    private static final Map<Coordinates, MyLabel> positionsMap = new HashMap<>();
    private static final Set<Coordinates> changedPositions = new HashSet<>();
    private static final String JAVA_IMAGE = "src/main/java/View/Sources/java.png";
    private static final String BUG_IMAGE = "src/main/java/View/Sources/Bug.jpg";
    private static final String DEV_IMAGE = "src/main/java/View/Sources/Dev_Second.jpg";
    private static final ImageIcon BUG_ICON = Icons.createIcon(BUG_IMAGE, 38, 38);
    private static final ImageIcon DEV_ICON = Icons.createIcon(DEV_IMAGE, 38, 38);
    private static final ImageIcon JAVA_ICON = Icons.createIcon(JAVA_IMAGE, 38, 38);
    private static final int ICON_SIZE = 38;

    public Universe() {
        setSetup();
    }

    private void setSetup() {
        setLayout(new GridLayout(15, 15, 3, 3));
        setOpaque(false);
        setPreferredSize(new Dimension(700, 700));
    }

    public void buildUniverse() {
        int contX = 14;

        for (int i = 1; i < 16; i++) {
            for (int j = 5; j <= 19; j++) {
                MyLabel position = new MyLabel(new Coordinates(i + contX, j));
                position.setOpaque(false);
                position.setBorder(BorderFactory.createLineBorder(new Color(0xFFFFFF), 2, true));

                positionsMap.put(position.getCoordinates(), position);
                add(position);
            }
            contX -= 2;
        }
    }

    public void updates(List<Planets> planets) {
        SwingUtilities.invokeLater(() -> {
            clearOldIcons();
            changedPositions.clear();
            updateBugs();
            updateDevs();

            for (MyLabel position : positionsMap.values()) {
                Coordinates positionCoordinates = position.getCoordinates();

                if (positionCoordinates.getX() == 8 && positionCoordinates.getY() == 12) {
                    updatePosition(position, JAVA_ICON);
                } else {
                    for (Planets planet : planets) {
                        if (planet.isAlive()) {
                            Coordinates planetCoordinates = planet.getLocation().getCoord();

                            if (positionCoordinates.equals(planetCoordinates)) {
                                updatePosition(position, planet.getImageIcon());
                            }
                        }
                    }
                }
            }
            revalidate();
            repaint();
        });
    }


    private void clearOldIcons() {
        for (Coordinates position : changedPositions) {
            MyLabel label = positionsMap.get(position);
            label.setIcon(null);
            label.setText("");
        }
    }

    private void updatePosition(MyLabel position, ImageIcon icon) {
        position.setText("");
        position.setIcon(icon);
        changedPositions.add(position.getCoordinates());
    }

    public void updateBugs() {
        updateEntities(BugsDevs.getBugs(), BUG_IMAGE,"bugs");
    }

    public void updateDevs() {
        updateEntities(BugsDevs.getDevs(), DEV_IMAGE, "devs");
    }

    private void updateEntities(List<Coordinates> entities, String imagePath, String name) {
        for (Coordinates entity : entities) {
            MyLabel position = positionsMap.get(entity);
            if (position != null) {
                if(name.equals("bugs"))
                    updatePosition(position, BUG_ICON);
                else
                    updatePosition(position, DEV_ICON);
            }
        }
    }
}
