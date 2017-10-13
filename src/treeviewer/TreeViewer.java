package treeviewer;

import org.w3c.dom.Document;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.prefs.Preferences;

public class TreeViewer extends JFrame {
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;
    private Preferences root = Preferences.userRoot();
    private Preferences node = root.node("com/uncnownhost/treeviewer");
    private DocumentBuilder builder;

    public TreeViewer() {
        int left = node.getInt("left", 0);
        int right = node.getInt("right", 0);
        int width = node.getInt("width", DEFAULT_WIDTH);
        int height = node.getInt("height", DEFAULT_HEIGHT);

        setBounds(left, right, width, height);
        setTitle("TreeViewer");

        JMenu menu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(event -> openFile());
        menu.add(openItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(event -> {
            savePreferences();
            System.exit(0);
        });
        menu.add(exitItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    public void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setFileFilter(new FileNameExtensionFilter("XML filter", "xml"));
        int r = fileChooser.showOpenDialog(this);
        if (r != JFileChooser.APPROVE_OPTION) return;
        final File file = fileChooser.getSelectedFile();

        new SwingWorker<Document, Void>() {
            @Override
            protected Document doInBackground() throws Exception {
                if (builder == null) {
                    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
                    builder = builderFactory.newDocumentBuilder();
                }
                return builder.parse(file);
            }

            @Override
            protected void done() {
                try {
                    Document doc = get();
                    JTree tree = new JTree(new DOMTreeModel(doc));
                    tree.setCellRenderer(new DOMTreeCellRenderer());
                    setContentPane(new JScrollPane(tree));
                    validate();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(TreeViewer.this, e);
                }
            }

        }.execute();
    }

    public void savePreferences() {
        node.putInt("left", getX());
        node.putInt("right", getY());
        node.putInt("width", getWidth());
        node.putInt("height", getHeight());
    }
}
