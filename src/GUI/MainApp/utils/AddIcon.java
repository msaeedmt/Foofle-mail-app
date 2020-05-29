package GUI.MainApp.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AddIcon {
    public void createIcon(Container container, String iconAddress, int width, int height) throws IOException {
        Image img = ImageIO.read(getClass().getResource(iconAddress));
        img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ((JButton) container).setIcon(new ImageIcon(img));
        container.setPreferredSize(new Dimension(40, 40));
        ((JButton) container).setBorderPainted(false);
        ((JButton) container).setContentAreaFilled(false);
        ((JButton) container).setFocusPainted(false);
    }
}
