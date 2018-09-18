/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.disenio;

import com.sun.glass.ui.Cursor;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Carlos
 */
@SuppressWarnings("serial")
public class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            /*setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));*/
            setBackground(new Color(255,255,255));
            setForeground(new Color(0,0,0));
            setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(204,204,204)));
        }
        setText((value == null) ? "" : value.toString());
        setCursor(new java.awt.Cursor(Cursor.CURSOR_POINTING_HAND));
        return this;
    }
}
