package View.Components;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Icons {

    private static final Map<String, ImageIcon> iconCache = new HashMap<>();

    public static ImageIcon createIcon(String imagePath, int width, int height) {
        ImageIcon cachedIcon = iconCache.get(imagePath);
        if (cachedIcon != null) {
            return new ImageIcon(cachedIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        }
        ImageIcon newIcon = new ImageIcon(imagePath);
        Image image = newIcon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        iconCache.put(imagePath, resizedIcon);

        return resizedIcon;
    }




}
