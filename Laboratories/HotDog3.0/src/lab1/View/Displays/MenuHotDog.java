package lab1.View.Displays;

import lab1.View.Components.MyLabels;

import javax.swing.*;
import java.awt.*;

public class MenuHotDog extends JPanel {

    MyLabels label = new MyLabels("Bem vindo", 30);

    public MenuHotDog() {
        setBackground(new java.awt.Color(64, 213, 213));
        setBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0), 3, true));
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

        //agora fazer um bem vindo aqui
        add(label, BorderLayout.CENTER);

    }
}
