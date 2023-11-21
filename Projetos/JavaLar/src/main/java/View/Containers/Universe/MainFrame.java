package View.Containers.Universe;

import View.Containers.Interaction.Buttons.Buttons;
import View.Components.Create;
import Model.Entities.Components.Planets;
import Model.Entities.Planets.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    public static Universe universe = new Universe();
    private final Buttons buttons;
    private static final String JAVA_ICON_PATH = "src/main/java/View/Sources/java.png";
    private static final String BACKGROUND_IMAGE_PATH = "src/main/java/View/Sources/espaco.jpg";


    public MainFrame() {
        setSetup();
        setImage();

        buttons = new Buttons();
        universe = new Universe();
        universe.buildUniverse();
        universe.updates(instances());

        organize();
    }

    private void setSetup() {
        setSize(1300, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setIconImage(Create.createIcon(JAVA_ICON_PATH, 48, 48).getImage());
    }

    private void setImage(){
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Image backgroundImage = Create.createIcon(BACKGROUND_IMAGE_PATH, getWidth(), getHeight()).getImage();

                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        });
    }

    public void organize(){
        add(universe, BorderLayout.WEST);
        add(buttons, BorderLayout.SOUTH);
    }

    private List<Planets> instances(){
        List<Planets> planetsList = new ArrayList<>();

        planetsList.add(new C());
        planetsList.add(new CPlusPlus());
        planetsList.add(new CSharp());
        planetsList.add(new JS());
        planetsList.add(new Php());
        planetsList.add(new Python());
        planetsList.add(new RubyRails());

        return planetsList;
    }

}
