package View.Containers.Interaction;

import Control.ManagementControl.ManagementArchiveController;
import Model.DAO.PlanetsDAO;
import View.Components.Icons;
import View.Components.MyButton;
import View.Containers.Ranking;
import View.Containers.Universe.MainFrame;
import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Buttons extends JPanel {

    public static final int IMAGESIZE = 47;

    private static final MyButton processInstant = new MyButton("processInstant");
    private static final MyButton leadNewArchive = new MyButton("leadNewArchive");
    private static final MyButton saveReport = new MyButton("saveReport");
    private static final MyButton readDataParticipants = new MyButton("readDataParticipants");
    private static final MyButton saveArchive = new MyButton("saveArchive");

    public static int line = 0;

    public Buttons() {
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setOpaque(false);
        setBorder(new LineBorder(Color.red, 1));
        setPreferredSize(new Dimension(700, 80));

        organize();
    }

    private void organize() {
        addImages();
        addButtons();
        addActionListeners();
    }

    private void addImages() {
        leadNewArchive.addImage(Icons.createIcon("src/main/java/View/Sources/folder.png", IMAGESIZE, IMAGESIZE));
        processInstant.addImage(Icons.createIcon("src/main/java/View/Sources/right-arrow.png", IMAGESIZE, IMAGESIZE));
        saveReport.addImage(Icons.createIcon("src/main/java/View/Sources/diskette.png", IMAGESIZE, IMAGESIZE));
        readDataParticipants.addImage(Icons.createIcon("src/main/java/View/Sources/database-storage.png", IMAGESIZE, IMAGESIZE));
        saveArchive.addImage(Icons.createIcon("src/main/java/View/Sources/sheet.png", IMAGESIZE, IMAGESIZE));
    }

    private void addButtons() {
        add(processInstant);
        add(leadNewArchive);
        add(saveReport);
        add(readDataParticipants);
        add(saveArchive);
    }

    private void addActionListeners() {
        processInstant.addMouseListener(new MyButtonMouseListener(processInstant));
        leadNewArchive.addMouseListener(new MyButtonMouseListener(leadNewArchive));
        saveReport.addMouseListener(new MyButtonMouseListener(saveReport));
            readDataParticipants.addMouseListener(new MyButtonMouseListener(readDataParticipants));
        saveArchive.addMouseListener(new MyButtonMouseListener(saveArchive));
    }

    public static class MyButtonMouseListener extends MouseAdapter {
        private final MyButton button;
        private Timer timer;
        static ManagementArchiveController managementArchiveController = new ManagementArchiveController();
        PlanetsDAO planetsDAO = new PlanetsDAO();

        public MyButtonMouseListener(MyButton button) {
            this.button = button;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (button.getName()) {
                case "processInstant" -> processInstantClicked();
                case "leadNewArchive" -> leadNewArchiveClicked();
                case "saveReport" -> saveReportClicked();
                case "readDataParticipants" -> readDataParticipantsClicked();
                case "saveArchive" -> saveArchiveClicked();
            }
        }

        private void processInstantClicked() {
            if (ManagementArchiveController.archiveSelected != null) {
                managementArchiveController.run();
                startProcessingLoop();
            } else {
                JOptionPane.showMessageDialog(null, "Select one option", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void leadNewArchiveClicked() {
            getFile();
            managementArchiveController.readArchive();
        }

        private void saveReportClicked() {
            planetsDAO.insertJavaLar();
        }

        private void readDataParticipantsClicked() {
            managementArchiveController.javaLar = planetsDAO.getJavaLar();
            MainFrame.ranking.updateRanking(managementArchiveController.rankNamesByOccurrences());
        }

        private void saveArchiveClicked() {
            System.out.println(managementArchiveController.buildReport());
            System.out.println(managementArchiveController.rankNamesByOccurrences());
        }

        private void getFile() {
            JFileChooser fileChooser = new JFileChooser();

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos CVS", "csv");
            fileChooser.setFileFilter(filter);

            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                ManagementArchiveController.archiveSelected = fileChooser.getSelectedFile().getAbsolutePath();
            } else {
                JOptionPane.showMessageDialog(null, "Select one option", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void startProcessingLoop() {
            timer = new Timer(500, new ActionListener() {
                int countdown = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (countdown > 0) {
                        System.out.println("Contagem regressiva: " + countdown);
                        countdown--;
                    } else {
                        managementArchiveController.run();
                        planetsDAO.insertJavaLar();
//                        planetsDAO.insertJavaLar();
//                        planetsDAO.insertJavaLar();
                        timer.stop();
                        startProcessingLoop();
                    }
                }
            });

            timer.start();
        }
    }
}
