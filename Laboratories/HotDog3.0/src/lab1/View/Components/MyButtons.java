package lab1.View.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyButtons extends JPanel {

    private JButton button;

    public MyButtons(String name) {
        setOpaque(false);

        button = new JButton(name);
        setupComponents();
        add(button);
    }

    private void setupComponents() {
        button.setPreferredSize(new Dimension(180, 40));
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setOpaque(true);
        button.setForeground(new Color(0, 0, 0));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
    }

    public void addActionListener(ActionListener listener) {
        button.addActionListener(listener);
    }
}
