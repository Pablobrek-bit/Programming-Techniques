package View.Components;

import View.Containers.Interaction.Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MyButton extends JPanel {
    private final JButton button;
    private String name;



    public MyButton(String name) {
        this.name = name;
        button = new JButton();
        setupComponents();
        setOpaque(false);

        add(button);
    }

    private void setupComponents() {
        button.setFont(new Font("Arial", Font.BOLD, 10));
        button.setOpaque(false);
        button.setForeground(Color.white);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.addMouseListener(new Buttons.MyButtonMouseListener(this));
    }

    public void addImage(ImageIcon imageIcon){
        button.setIcon(imageIcon);
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

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyButton myButton = (MyButton) o;
        return Objects.equals(button, myButton.button) && Objects.equals(name, myButton.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(button, name);
    }
}

