package lab1.View;

import lab1.View.Components.MyLabel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class DisplayReport extends JPanel {

    public DisplayReport(){
        setupComponents();
        addComponents();
    }

    private void setupComponents() {
        setBackground(new Color(64, 213, 213));
        setBorder(new LineBorder(Color.black, 3));
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    private void addComponents() {
        add(new MyLabel("Relatorio"));
    }
}
