package util;

import javax.swing.*;
import java.awt.*;

public class WindowInitializer {

    private WindowInitializer(){}

    public static void initialize(JFrame frame, JPanel panel,
                                  int defaultCloseOperation, String title){
        frame.add(panel);
        frame.setTitle(title);
        frame.setDefaultCloseOperation(defaultCloseOperation);
        frame.pack();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(
                    (int) ((dimension.getWidth() - frame.getWidth()) / 2),
                    (int) ((dimension.getHeight() - frame.getHeight()) / 2));
        frame.setVisible(true);
    }

}
