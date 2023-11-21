package View.Components;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Create {

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

    //criar um metodo para pegar uma imagem com o getResouce
//    public static ImageIcon createIcon(String imagePath, int size, int size1) {
//        ImageIcon cachedIcon = iconCache.get(imagePath);
//        if (cachedIcon != null) {
//            return new ImageIcon(cachedIcon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH));
//        }
//
//        ImageIcon newIcon = new ImageIcon(Objects.requireNonNull(Create.class.getResource(imagePath)));
//        Image image = newIcon.getImage();
//        Image resizedImage = image.getScaledInstance(size, size, Image.SCALE_SMOOTH);
//        ImageIcon resizedIcon = new ImageIcon(resizedImage);
//
//        iconCache.put(imagePath, resizedIcon);
//
//        return resizedIcon;
//    }


}
