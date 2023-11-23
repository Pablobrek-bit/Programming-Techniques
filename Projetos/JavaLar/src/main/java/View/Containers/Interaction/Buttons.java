package View.Containers.Interaction;

import Control.ManagementControl.ManagementArchiveController;
import Model.DAO.PlanetsDAO;
import View.Components.Create;
import View.Components.MyButton;


import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Buttons extends JPanel {

    private static final MyButton processInstant = new MyButton("processInstant");
    private static final MyButton leadNewArchive = new MyButton("leadNewArchive");
    private static final MyButton saveReport = new MyButton("saveReport");
    private static final MyButton readDataParticipants = new MyButton("readDataParticipants");
    private static final MyButton saveArchive = new MyButton("saveArchive");

    public static int line = 0;

    public Buttons() {
        setSetup();
        organize();
    }

    private void setSetup() {
        setLayout(new FlowLayout());
        setOpaque(false);
        setPreferredSize(new Dimension(700, 80));
        setBorder(new LineBorder(Color.PINK, 2, true));
    }

    public void organize() {
        addImages();
        add(processInstant);
        add(leadNewArchive);
        add(saveReport);
        add(readDataParticipants);
        add(saveArchive);

        addAction();
    }

    private void addImages() {
        leadNewArchive.addImage(Create.createIcon("src/main/java/View/Sources/folder.png", 30, 30));
        processInstant.addImage(Create.createIcon("src/main/java/View/Sources/direito.png", 30, 30));
        saveReport.addImage(Create.createIcon("src/main/java/View/Sources/save-archive.png", 30, 30));
        readDataParticipants.addImage(Create.createIcon("src/main/java/View/Sources/banco-de-dados.png", 30, 30));
        saveArchive.addImage(Create.createIcon("src/main/java/View/Sources/save-archive-exit.png", 30, 30));
    }

    private void addAction() {
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
                case "processInstant"-> {
                    if (ManagementArchiveController.archiveSelected != null) {
                        managementArchiveController.run();
                    } else {
                        System.out.println("Selecione um arquivo");
                    }
                }
                case "leadNewArchive" -> {
                    getFile();
                    managementArchiveController.readArchive();
                }
                case "saveReport" -> {
                    planetsDAO.insertJavaLar();
                }
                case "readDataParticipants" -> {
                    managementArchiveController.javaLar = planetsDAO.getJavaLar();
                    System.out.println("Tamanho que é para ser: " + planetsDAO.getJavaLar().size());
                }
                case "saveArchive" -> {
                    JOptionPane.showMessageDialog(null, managementArchiveController.mostCommomName(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        private void getFile(){
            JFileChooser fileChooser = new JFileChooser();

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos CVS", "csv");
            fileChooser.setFileFilter(filter);

            int result = fileChooser.showOpenDialog(null);

            if(result == JFileChooser.APPROVE_OPTION){
                ManagementArchiveController.archiveSelected = fileChooser.getSelectedFile().getAbsolutePath();
            } else{
                JOptionPane.showMessageDialog(null,"Select one option", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void startProcessingLoop() {
            timer = new Timer(500, new ActionListener() {
                int countdown = 10; // Tempo inicial em segundos

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (countdown > 0) {
                        System.out.println("Contagem regressiva: " + countdown);
                        countdown--;
                    } else {
                        managementArchiveController = new ManagementArchiveController();
                        planetsDAO.insertJavaLar();
                        timer.stop();
                        startProcessingLoop();

                    }
                }
            });

            // Inicia otemporizador
            timer.start();
        }





    }
}
