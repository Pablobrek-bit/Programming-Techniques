package lab1.View.Displays;

import lab1.Model.People.Enums.Additional;
import lab1.Services.Management;
import lab1.View.Components.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class MakingSales extends JPanel {

    private static final String[] CHEESEOPTIONS = {"MUSSARELA", "PRATO", "PARMESSAO", "COALHO"};
    private static final String[] PROTEINOPTIONS = {"SALSICHA", "LINGUICA", "FRANGO", "BACON"};
    private static final String[] DRINKOPTIONS = {"COCACOLA", "DELRIO", "SUCOCHAVES"};
    private static final Additional[] additionalOptions = {Additional.MAIONESE, Additional.KETCHUP, Additional.OVO, Additional.BATATA_PALHA};



    private final MyButtons bRealizeVendas;
    private final MyTextFields nomeTextField; // Variável para o campo de nome
    private final MyTextFields matriculaTextField; // Variável para o campo de matrícula
    private final MyComboBoxs queijoComboBox; // Variável para o JComboBox de queijo
    private final MyComboBoxs proteinaComboBox; // Variável para o JComboBox de proteína
    private final MyCheckBoxs adicionaisCheckBoxes; // Variável para o grupo de JCheckBox de queijo
    private final MyComboBoxs drinkComboBox;

    public MakingSales() {
        bRealizeVendas = new MyButtons("Realizar Vendas");

        nomeTextField = new MyTextFields(); // Inicializa o campo de nome
        matriculaTextField = new MyTextFields(); // Inicializa o campo de matrícula
        queijoComboBox = new MyComboBoxs(CHEESEOPTIONS); // Inicializa o JComboBox de queijo
        proteinaComboBox = new MyComboBoxs(PROTEINOPTIONS); // Inicializa o JComboBox de proteína
        adicionaisCheckBoxes = new MyCheckBoxs(additionalOptions);
        drinkComboBox = new MyComboBoxs(DRINKOPTIONS);

        this.setupComponents();
        this.addComponents();
        this.setupListeners();
    }

    private void setupComponents() {
        this.setBackground(new Color(64, 213, 213));
        this.setBorder(new LineBorder(Color.black, 3));
        this.setLayout(new GridLayout(7, 2));
    }

    private void addComponents() {
        add(new MyLabels("Nome"));
        add(nomeTextField);

        add(new MyLabels("Matricula"));
        add(matriculaTextField);

        add(new MyLabels("Opção de queijo"));
        add(queijoComboBox);

        add(new MyLabels("Opção de proteina"));
        add(proteinaComboBox);

        add(new MyLabels("Escolha opção de queijo"));
        add(adicionaisCheckBoxes);

        add(new MyLabels("Bebida"));
        add(drinkComboBox);

        add(bRealizeVendas);
    }
    private void setupListeners() {
        bRealizeVendas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Management management = new Management();
                String nome = nomeTextField.getText();
                String matricula = matriculaTextField.getText();
                String opcaoQueijo = queijoComboBox.getSelectedItem();
                String opcaoProteina = proteinaComboBox.getSelectedItem();
                List<Additional> opcoesAdicionais = adicionaisCheckBoxes.getSelectedOptions();
                String bebida = drinkComboBox.getSelectedItem();
                if(Management.addSale(nome, matricula, bebida, opcaoQueijo, opcaoProteina, opcoesAdicionais)){
                    JOptionPane.showMessageDialog(null, "Venda realizada com sucesso");
                    clearFields();
                }
            }
        });
    }

    private void clearFields() {
        nomeTextField.setText("");
        matriculaTextField.setText("");
        queijoComboBox.setSelectedIndex(0);
        proteinaComboBox.setSelectedIndex(0);
        adicionaisCheckBoxes.clearSelection();
        drinkComboBox.setSelectedIndex(0);
    }



}

