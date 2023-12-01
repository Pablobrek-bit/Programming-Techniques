package View.Containers.Universe;

import View.Components.Icons;
import Model.Entities.Components.Planets;
import Model.Entities.Planets.*;
import View.Containers.Interaction.Buttons;
import View.Containers.Ranking;
import View.Containers.Warnings;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    public static Universe universe;
    public static Ranking ranking = new Ranking();
    public static Warnings warnings = new Warnings();
    private  Buttons buttons;
    private static final String JAVA_ICON_PATH = "src/main/java/View/Sources/java.png";
    private static final String BACKGROUND_IMAGE_PATH = "src/main/java/View/Sources/espaco.jpg";
    private static final String BACKGROUND_MUSIC_PATH = "src/main/java/View/Sources/InterstellarSong.wav";
    private final Image BACKGROUND_IMAGE = Icons.createIcon(BACKGROUND_IMAGE_PATH, 800, 950).getImage();

    public MainFrame() {
        initialize();
        organizeComponents();
    }

    private void initialize() {
        setMainFrameSetup();
        setBackgroundImage();
        // playBackgroundMusic();

        buttons = new Buttons();
        universe = new Universe();
        universe.buildUniverse();
        universe.updates(instances());
    }

    private void setMainFrameSetup() {
        setSize(1400, 950);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setIconImage(Icons.createIcon(JAVA_ICON_PATH, 48, 48).getImage());
    }

    private void setBackgroundImage() {
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Image backgroundImage = BACKGROUND_IMAGE;

                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        });
    }

    private void playBackgroundMusic() {
        try {
            File soundFile = new File(BACKGROUND_MUSIC_PATH);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void organizeComponents() {
        add(buttons, BorderLayout.NORTH);

        JPanel flowPanel = createFlowPanel();
        add(flowPanel, BorderLayout.CENTER);
    }

    private JPanel createFlowPanel() {
        JPanel flowPanel = new JPanel(new FlowLayout());
        flowPanel.setOpaque(false);
        flowPanel.add(ranking);
        flowPanel.add(universe);
        flowPanel.add(warnings);
        return flowPanel;
    }

    private List<Planets> instances() {
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
