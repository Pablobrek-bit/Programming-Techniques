package View.Containers.Interaction.Buttons.ChoiceArquive;

import Control.ManagementControl.ManagementArchiveController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class ChoiceArquive extends JFrame {


    public String selectedOption = "";


    private final JButton confirm = new JButton("Confirm");
    public ChoiceArquive(){
        setSetup();
        setSetupButton();
        organize();
    }

    private void organize(){

        JFileChooser fileChooser = new JFileChooser();
        add(new Query(),BorderLayout.NORTH);
        add(new ArquiveOptions(),BorderLayout.CENTER);
        add(confirm, BorderLayout.SOUTH);
    }

    private void setSetup() {
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
    }

    private void setSetupButton(){
        confirm.setPreferredSize(new Dimension(100,50));
        confirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        confirm.setBackground(Color.white);
        confirm.setForeground(Color.black);

        confirm.addActionListener(this::handleConfirm);
    }

    private void handleConfirm(ActionEvent e) {
        if (ArquiveOptions.buttonGroup.getSelection() != null) {
            selectedOption = Objects.requireNonNull(ArquiveOptions.getSelectedOption());
            ManagementArchiveController.archiveSelected = selectedOption;
            System.out.println("Arquivo selecionado: " + selectedOption);
            messageSuccess();
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Select one option");
        }
    }

    private void messageSuccess(){
        JOptionPane.showMessageDialog(null,"Read file with success");
    }
}
