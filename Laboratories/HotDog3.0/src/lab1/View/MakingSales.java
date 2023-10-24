package lab1.View;

import lab1.View.Components.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class MakingSales extends JPanel {

    private static final String[] CHEESEOPTIONS = {"MUSSARELA", "PRATO", "PARMESSAO", "COALHO"};
    private static final String[] PROTEINOPTIONS = {"SALSICHA", "LINGUICA", "FRANGO", "BACON"};
    private static final String[] DRINKOPTIONS = {"COCA-COLA", "DELRIO", "SUCO DO CHAVES"};

    private MyButtons bRealizeVendas;

    public MakingSales() {
        bRealizeVendas = new MyButtons("Realizar Vendas");

        this.setupComponents();
        this.addComponents();
    }

    private void setupComponents() {
        this.setBackground(new Color(64, 213, 213));

        this.setBorder(new LineBorder(Color.black, 3));
        this.setLayout(new GridLayout(7, 2));
    }

    private void addComponents() {
        //add(createLabel("Nome"));
        add(new MyLabels("Nome"));
        add(new MyTextFields());

        //add(createLabel("Matricula"));
        add(new MyLabels("Matricula"));
        add(new MyTextFields());

        //add(createLabel("Opção de queijo"));
        add(new MyLabels("Opção de queijo"));
        add(new MyComboBoxs(CHEESEOPTIONS));

        //add(createLabel("Opção de proteina"));
        add(new MyLabels("Opção de proteina"));
        add(new MyComboBoxs(PROTEINOPTIONS));

        //add(createLabel("Escolha opção de queijo"));
        add(new MyLabels("Escolha opção de queijo"));
        add(new MyCheckBoxs("MUSSARELA, PRATO, PARMESSAO, COALHO".split(", ")));

        //add(createLabel("Bebida"));
        add(new MyLabels("Bebida"));
        add(new MyComboBoxs(DRINKOPTIONS));

        add(bRealizeVendas);
    }

    private JPanel createLabel(String name) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(new Color(4, 255, 255));
        MyLabel label = new MyLabel(name);
        panel.add(label);
        return panel;
    }
}
