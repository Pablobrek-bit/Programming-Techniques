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

    private static final String PROCESS_INSTANT_TEXT = "Processar Instante";
    private static final String LEAD_NEW_ARCHIVE_TEXT = "Ler Novo Arquivo de Entrada";
    private static final String SAVE_REPORT_TEXT = "Salvar Relatório";
    private static final String READ_DATA_PARTICIPANTS_TEXT = "Ler Dados dos Participantes";
    private static final String SAVE_ARCHIVE_TEXT = "Salvar Arquivo de Saída";

    private static final MyButton processInstant = new MyButton("Processar Instante");
    private final MyButton leadNewArchive = new MyButton("Ler Novo Arquivo de Entrada");
    private final MyButton saveReport = new MyButton("Salvar Relatório");
    private final MyButton readDataParticipants = new MyButton("Ler Dados dos Participantes");
    private final MyButton saveArchive = new MyButton("Salvar Arquivo de Saída");

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
        //leadNewArchive.addImage(Create.createIcon("src/main/java/View/Sources/folder.png", 30, 30));
        add(processInstant);
        add(leadNewArchive);
        add(saveReport);
        add(readDataParticipants);
        add(saveArchive);

        addAction();
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
        static ManagementArchiveController managementArchiveController = null;
        PlanetsDAO planetsDAO = new PlanetsDAO();

        public MyButtonMouseListener(MyButton button) {
            this.button = button;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            JButton button = (JButton) e.getSource();

            switch (button.getText()) {
                case PROCESS_INSTANT_TEXT -> {
                    System.out.println("Novo arquivo: " + ManagementArchiveController.archiveSelected);
                    managementArchiveController = new ManagementArchiveController();
                    //planetsDAO.insertJavaLar();
                    //planetsDAO.getJavaLar();
                    //startProcessingLoop();
                }
                case LEAD_NEW_ARCHIVE_TEXT -> {
                    getFile();

                }
                case SAVE_REPORT_TEXT -> {
                    planetsDAO.insertJavaLar();
                }
                case READ_DATA_PARTICIPANTS_TEXT -> {
                    managementArchiveController.javaLar = planetsDAO.getJavaLar();
                    System.out.println("Tamanho que é para ser: " + planetsDAO.getJavaLar().size());
                }
                case SAVE_ARCHIVE_TEXT -> {
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
