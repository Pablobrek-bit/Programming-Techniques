package lab1.View.Components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MyTextFields extends JPanel {

    private JTextField textField;

    public MyTextFields(){

        setLayout(new GridBagLayout());
        setOpaque(false);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(385, 40));
        textField.setFont(new Font("Arial", Font.BOLD, 15));
        textField.setOpaque(true);
        textField.setForeground(new Color(0, 0, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(textField, gbc);


    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String text) {
        textField.setText(text);
    }
}
