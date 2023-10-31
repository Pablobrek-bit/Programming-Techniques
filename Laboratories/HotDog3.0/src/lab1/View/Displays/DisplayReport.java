package lab1.View.Displays;

import lab1.View.Components.MyLabel;
import lab1.View.Components.MyLabels;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

//No display vai ter que aparecer as seguintes coisas:



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

    }
}

class ReportLabels extends JPanel{

    public ReportLabels(){
        setupComponents();
        addComponents();
    }

    private void setupComponents() {
        setBackground(new Color(64, 213, 213));
        setBorder(new LineBorder(Color.black, 3));
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    private void addComponents() {
        add(new MyLabels("Clients"));
        add(new MyLabels("HotDogs"));
        add(new MyLabels("Value"));
    }

}


