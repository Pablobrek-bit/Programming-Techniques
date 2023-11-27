package View.Containers.Universe;

import View.Containers.Interaction.Buttons;
import View.Components.Icons;
import Model.Entities.Components.Planets;
import Model.Entities.Planets.*;
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
    private final Buttons buttons;
    private static final String JAVA_ICON_PATH = "src/main/java/View/Sources/java.png";
    private static final String BACKGROUND_IMAGE_PATH = "src/main/java/View/Sources/espaco.jpg";
    private static final String BACKGROUND_MUSIC_PATH = "src/main/java/View/Sources/InterstellarSong.wav";
    private final Image BACKGROUND_IMAGE = Icons.createIcon(BACKGROUND_IMAGE_PATH, 800, 950).getImage();


    public MainFrame() {
        setSetup();
        setImage();
        //playBackgroundMusic();

        buttons = new Buttons();
        universe = new Universe();
        universe.buildUniverse();
        universe.updates(instances());


        organize();
    }

    private void setSetup() {
        setSize(1400, 950);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setIconImage(Icons.createIcon(JAVA_ICON_PATH, 48, 48).getImage());
    }

    private void setImage(){
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

    public void organize(){

        add(buttons, BorderLayout.NORTH);

        JPanel teste = new JPanel(new FlowLayout());
        teste.setOpaque(false);
        teste.add(ranking);
        teste.add(universe);
        teste.add(warnings);

        add(teste, BorderLayout.CENTER);

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
