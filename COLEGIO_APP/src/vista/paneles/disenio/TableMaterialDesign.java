/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.disenio;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.TableUI;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Carlos
 */
public class TableMaterialDesign extends BasicTableUI{
    public static TableUI createUI(JComponent c){
        return new TableMaterialDesign();
    }
    
    public static void crearDisenio(){
        UIManager.put("Table.background", new Color(255,255,255));
        UIManager.put("Table.darkShadow", new Color(255,255,255));
        UIManager.put("Table.shadow", new Color(255,255,255));
        UIManager.put("Table.grid", new Color(255,255,255));
        UIManager.put("TableHeader.cellBorder", BorderFactory.createLineBorder(new Color(255,255,255)));
        UIManager.put("TableHeader.foreground", new Color(110,110,110));
        UIManager.put("TableHeader.background", new Color(255,255,255));
        UIManager.put("TableHeader.font", new Font("Segoe UI", Font.BOLD,14));
        UIManager.put("Table.scrollPaneBorder", BorderFactory.createLineBorder(new Color(255,255,255),1));
        UIManager.put("Table.focusCellBackground", new Color(101,62,164));
        UIManager.put("Table.focusCellHighlightBorder", BorderFactory.createEmptyBorder());
        UIManager.put("Table.light", new Color(255,255,255));
        UIManager.put("Table.highlight", new Color(255,255,255));
        UIManager.put("Table.selectionForeground", new Color(255,255,255));
    }
    
    public static void modificarGrid(JTable componente){
        componente.setShowGrid(true);
        componente.setShowHorizontalLines(true);
        componente.setShowVerticalLines(false);
    }

    public static void modificarAlturaFilas(JTable componente) {
        componente.setRowHeight(40);
    }

    public static class CustomRenderer extends DefaultTableCellRenderer {

        private DefaultTableCellRenderer render;
        private Border b;

        public CustomRenderer(TableCellRenderer r, Color top, Color left, Color bottom, Color right) {
            this.render = (DefaultTableCellRenderer)r;
            construirBorde(top, left, bottom, right);
            alinearElementos();
            
        }

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            final JComponent result = (JComponent) render.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            result.setBorder(b);
            return result;
        }

        private void alinearElementos() {
            render.setHorizontalAlignment(SwingConstants.CENTER);
        }

        private void construirBorde(Color top, Color left, Color bottom, Color right) {
            b = BorderFactory.createCompoundBorder();
            //b = BorderFactory.createCompoundBorder(b, BorderFactory.createMatteBorder(0, 0, 2, 0, top));
            //b = BorderFactory.createCompoundBorder(b, BorderFactory.createMatteBorder(0, 0, 2, 0, left));
            b = BorderFactory.createCompoundBorder(b, BorderFactory.createMatteBorder(0, 0, 2, 0, bottom));
            //b = BorderFactory.createCompoundBorder(b, BorderFactory.createMatteBorder(0, 0, 2, 0, right));
        }

    }
}
