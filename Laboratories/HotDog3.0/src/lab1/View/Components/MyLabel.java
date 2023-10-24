package lab1.View.Components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MyLabel extends JLabel {

    public MyLabel(String text){
        setForeground(Color.black);
        setText(text);
        setFont(new Font("Arial", Font.BOLD, 20));
    }
}
