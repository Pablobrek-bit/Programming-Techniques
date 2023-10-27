package lab1.View.Displays;

import lab1.View.Components.MyLabel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ListClients extends JPanel {

    public ListClients(){
        setupComponents();
        addComponents();
    }

    private void setupComponents() {
        setBackground(new Color(64, 213, 213));
        setBorder(new LineBorder(Color.black, 3));
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    private void addComponents() {
        add(new MyLabel("Listar clientes"));
    }
}
