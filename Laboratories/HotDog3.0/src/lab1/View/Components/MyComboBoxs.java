package lab1.View.Components;

import javax.swing.*;
import java.awt.*;

public class MyComboBoxs extends JPanel{

    private JComboBox<String> comboBox;

    public MyComboBoxs(String[] itens){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Usar BoxLayout para centralizar verticalmente

        comboBox = new JComboBox<>(itens);
        comboBox.setAlignmentX(Component.CENTER_ALIGNMENT); // Centralizar horizontalmente

        comboBox.setPreferredSize(new Dimension(385, 40));

        add(Box.createVerticalGlue()); // Adicionar espaço vertical
        add(comboBox);
        add(Box.createVerticalGlue()); // Adicionar espaço vertical


    }

    public void setSelectedIndex(int item) {
        comboBox.setSelectedIndex(item);
    }

    public String getSelectedItem() {
        return (String) comboBox.getSelectedItem();
    }
}
