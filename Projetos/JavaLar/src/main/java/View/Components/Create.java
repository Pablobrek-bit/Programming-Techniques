package View.Components;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Create {

    public static ImageIcon createIcon(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

}
