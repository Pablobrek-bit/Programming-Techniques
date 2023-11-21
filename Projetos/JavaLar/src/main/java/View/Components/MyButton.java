package View.Components;

import View.Containers.Interaction.Buttons.Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyButton extends JPanel {

    private final JButton button;

    public MyButton(String name) {
        button = new JButton(name);
        setupComponents();
        setOpaque(false);

        add(button);
    }

    private void setupComponents() {
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setOpaque(false);
        button.setForeground(Color.white);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);

        button.addMouseListener(new Buttons.MyButtonMouseListener(this));
    }

    public String getText(){
        return button.getText();
    }

    public void addActionListener(ActionListener listener) {
        button.addActionListener(listener);
    }

    public void animateHover(Color originalColor) {
        button.setForeground(Color.YELLOW);

        Timer timer = new Timer(500, actionEvent -> button.setForeground(originalColor));
        timer.setRepeats(false);
        timer.start();
    }
}

