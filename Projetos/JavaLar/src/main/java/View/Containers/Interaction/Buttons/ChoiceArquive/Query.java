package View.Containers.Interaction.Buttons.ChoiceArquive;

import javax.swing.*;
import java.awt.*;

public class Query extends JPanel {

    private final JLabel query;

    public Query(){
        query = new JLabel("Choose the file option:");
        setSetup();
        add(query);
    }



    public void setSetup(){
        query.setFont(new Font("Arial", Font.BOLD, 20));
        setOpaque(false);
    }
}
