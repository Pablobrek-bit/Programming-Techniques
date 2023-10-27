package lab1.View.Components;

import lab1.Model.People.Enums.Additional;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyCheckBoxs extends JPanel {

    private List<JCheckBox> checkBoxList = new ArrayList<>();

    public MyCheckBoxs(Additional[] options) {
        setLayout(new GridLayout(2, 2));
        setOpaque(false);
        for (Additional option : options) {
            JCheckBox checkBox = new JCheckBox(option.name());
            checkBox.setOpaque(false);
            checkBoxList.add(checkBox);
            add(checkBox);
        }
    }

    public List<Additional> getSelectedOptions() {
        List<Additional> selectedOptions = new ArrayList<>();
        for (JCheckBox checkBox : checkBoxList) {
            if (checkBox.isSelected()) {
                selectedOptions.add(Additional.valueOf(checkBox.getText()));
            }
        }
        return selectedOptions;
    }

    public void clearSelection() {
        for (JCheckBox checkBox : checkBoxList) {
            checkBox.setSelected(false);
        }
    }
}
