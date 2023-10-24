package lab1.View.Components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MyCheckBoxs extends JPanel {

    public MyCheckBoxs(String[] opcoes){
        setLayout(new GridLayout(2,2));
        setOpaque(false);
        JCheckBox[] checkBoxs = new JCheckBox[opcoes.length];
        for (int i = 0; i < opcoes.length; i++) {
            checkBoxs[i] = new JCheckBox(opcoes[i]);
            checkBoxs[i].setOpaque(false);
            add(checkBoxs[i]);
        }
    }
}
