/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles;

import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import vista.interfaces.IConstanteComponentes;
import vista.interfaces.IPanelComponents;

/**
 *
 * @author Carlos
 */
public abstract class PanelComponents extends BasicPanelComponents implements IPanelComponents, IConstanteComponentes {

    public void iniciarItemsPopMenu(JTable tabla, JPopupMenu menu) {
        agregarItemsAMenu();
        agregarMenuALista(tabla, menu);
    }

    public void buscarEnTabla(JTable tabla, JTextField textField) {
        try {
            TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tabla.getRowSorter();
            String txt = textField.getText();
            if (txt.length() == 0 || txt.equals(TEXTFIELD_BUSCAR)) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter(txt));
            }
        } catch (NullPointerException ex) {
            System.err.println(ex.getClass().getName() + "-" + ex.getMessage() + "\nIntente activar AutoCreateRowSorter en la tabla");
        }

    }

    public void eventuarTabs(JTabbedPane tp) {
        tp.addChangeListener((ChangeEvent e) -> {
            cargarDatosPrincipales();
        });
    }

    protected void iniciarTimerBuscar(JTable tabla, JTextField buscar, Timer timer) {
        timer = new Timer(10, (ActionEvent e) -> {
            buscarEnTabla(tabla, buscar);
        });
        timer.start();
    }
}
