package treeviewer;

import org.w3c.dom.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class DOMTreeCellRenderer extends DefaultTreeCellRenderer {
    private static String characterString(CharacterData node) {
        StringBuilder stringBuilder = new StringBuilder(node.getData());
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '\r') {
                stringBuilder.replace(i, i + 1, "\\r");
                i++;
            } else if (stringBuilder.charAt(i) == '\n') {
                stringBuilder.replace(i, i + 1, "\\n");
                i++;
            } else if (stringBuilder.charAt(i) == '\t') {
                stringBuilder.replace(i, i + 1, "\\t");
                i++;
            }
        }
        if (node instanceof CDATASection) stringBuilder.insert(0, "CDATASection: ");
        else if (node instanceof Text) stringBuilder.insert(0, "Text: ");
        else if (node instanceof Comment) stringBuilder.insert(0, "Comment: ");
        return stringBuilder.toString();
    }

    private static JPanel elementPanel(Element node) {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Element: " + node.getTagName()));
        final NamedNodeMap map = node.getAttributes();
        panel.add(new JTable(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return map.getLength();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return columnIndex == 0 ? map.item(rowIndex).getNodeName() :
                        map.item(rowIndex).getNodeValue();
            }
        }));
        return panel;
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Node node = (Node) value;
        if (node instanceof Element) return elementPanel((Element) node);
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        if (node instanceof CharacterData) setText(characterString((CharacterData) node));
        else setText(node.getClass() + ": " + node.toString());
        return this;
    }
}
