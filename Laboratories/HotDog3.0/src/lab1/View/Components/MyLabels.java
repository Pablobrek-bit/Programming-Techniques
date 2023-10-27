package lab1.View.Components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MyLabels extends JPanel {

    public MyLabels(String text){
        setOpaque(false);
        setLayout(new BorderLayout());

        JLabel label = new JLabel(text);
        label.setForeground(Color.black);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        add(label);
    }

    public MyLabels(String text, int fontSize){
        setOpaque(false);
        setLayout(new BorderLayout());

        JLabel label = new JLabel(text);
        label.setForeground(Color.black);
        label.setFont(new Font("Arial", Font.BOLD, fontSize));

        add(label);
    }
}
