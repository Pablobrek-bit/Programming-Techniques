package View.Containers.Interaction.Buttons;

import Control.ManagementControl.ManagementArchiveController;
import View.Components.MyButton;
import View.Containers.Interaction.Buttons.ChoiceArquive.ChoiceArquive;
import View.Containers.Universe.Universe;
import View.ExecutableMove;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Buttons extends JPanel {

    private static final String PROCESS_INSTANT_TEXT = "Processar Instante";
    private static final String LEAD_NEW_ARCHIVE_TEXT = "Ler Novo Arquivo de Entrada";
    private static final String SAVE_REPORT_TEXT = "Salvar Relatório";
    private static final String READ_DATA_PARTICIPANTS_TEXT = "Ler Dados dos Participantes";
    private static final String SAVE_ARCHIVE_TEXT = "Salvar Arquivo de Saída";

    private final MyButton processInstant = new MyButton("Processar Instante");
    private final MyButton leadNewArquive = new MyButton("Ler Novo Arquivo de Entrada");
    private final MyButton saveReport = new MyButton("Salvar Relatório");
    private final MyButton readDataParticipants = new MyButton("Ler Dados dos Participantes");
    private final MyButton saveArquive = new MyButton("Salvar Arquivo de Saída");

    public static int line = 0;

    public Buttons() {
        setSetup();
        organize();
    }

    private void setSetup() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        setPreferredSize(new Dimension(300, 700));
    }

    public void organize() {
        add(processInstant);
        add(leadNewArquive);
        add(saveReport);
        add(readDataParticipants);
        add(saveArquive);

        addAction();
    }

    private void addAction() {
        processInstant.addMouseListener(new MyButtonMouseListener(processInstant));
        leadNewArquive.addMouseListener(new MyButtonMouseListener(leadNewArquive));
        saveReport.addMouseListener(new MyButtonMouseListener(saveReport));
        readDataParticipants.addMouseListener(new MyButtonMouseListener(readDataParticipants));
        saveArquive.addMouseListener(new MyButtonMouseListener(saveArquive));
    }

    public static class MyButtonMouseListener extends MouseAdapter {
        private final MyButton button;

        public MyButtonMouseListener(MyButton button) {
            this.button = button;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            JButton button = (JButton) e.getSource();

            ManagementArchiveController managementArchiveController = null;

            switch (button.getText()) {
                case PROCESS_INSTANT_TEXT -> {
                    System.out.println("Novo arquivo: " + ManagementArchiveController.archiveSelected);
                    managementArchiveController = new ManagementArchiveController();
                }
                case LEAD_NEW_ARCHIVE_TEXT -> {
                    ChoiceArquive choiceArquive = new ChoiceArquive();
                    choiceArquive.setVisible(true);
                }
                case SAVE_REPORT_TEXT -> {

                }
                case READ_DATA_PARTICIPANTS_TEXT -> {

                }
                case SAVE_ARCHIVE_TEXT -> {

                }

            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            transitionToColor();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            animateExit();
        }

        private void animateExit() {

        }
        private void transitionToColor() {
            button.setForeground(Color.LIGHT_GRAY);

            Timer timer = new Timer(140, event -> {
                button.setForeground(Color.white);
                ((Timer) event.getSource()).stop();
            });

            timer.start();
        }
    }
}
