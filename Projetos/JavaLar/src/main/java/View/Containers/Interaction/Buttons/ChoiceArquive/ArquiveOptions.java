package View.Containers.Interaction.Buttons.ChoiceArquive;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class ArquiveOptions extends JPanel {

    public static ButtonGroup buttonGroup;

    private final JRadioButton option10 = new JRadioButton("10");
    private final JRadioButton option50 = new JRadioButton("50");
    private final JRadioButton option100 = new JRadioButton("100");
    private final JRadioButton option500 = new JRadioButton("500");
    private final JRadioButton option1000 = new JRadioButton("1000");
    private final JRadioButton option1500 = new JRadioButton("1500");
    private final JRadioButton option2000 = new JRadioButton("2000");

    public ArquiveOptions(){
        setSetup();
        addOptions();
    }

    private void setSetup(){
        setOpaque(false);
        setLayout(new GridLayout(4,2));

        buttonGroup = new ButtonGroup();
        buttonGroup.add(option10);
        buttonGroup.add(option50);
        buttonGroup.add(option100);
        buttonGroup.add(option500);
        buttonGroup.add(option1000);
        buttonGroup.add(option1500);
        buttonGroup.add(option2000);
    }

    private void addOptions() {
        add(option10);
        add(option50);
        add(option100);
        add(option500);
        add(option1000);
        add(option1500);
        add(option2000);
    }

    public static String getSelectedOption() {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            JRadioButton button = (JRadioButton) buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
}


