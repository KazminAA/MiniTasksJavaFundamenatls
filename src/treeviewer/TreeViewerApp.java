package treeviewer;

import javax.swing.*;
import java.awt.*;

public class TreeViewerApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new TreeViewer();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
