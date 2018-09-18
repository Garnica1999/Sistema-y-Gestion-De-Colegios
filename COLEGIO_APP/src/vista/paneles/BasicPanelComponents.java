/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles;

import vista.interfaces.IPanelComponents;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import vista.paneles.disenio.ComboBoxMaterialDesign;
import vista.paneles.disenio.MaterialDesingTema;
import vista.paneles.disenio.TabbedPaneMaterialDesing;
import vista.paneles.disenio.TableMaterialDesign;

/**
 *
 * @author Carlos
 */
@SuppressWarnings("serial")
public abstract class BasicPanelComponents extends JPanel{

    protected void agregarMenuALista(JTable tabla, JPopupMenu menu) {
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point point = e.getPoint();
                int currentRow = tabla.rowAtPoint(point);
                tabla.setRowSelectionInterval(currentRow, currentRow);
                if (SwingUtilities.isRightMouseButton(e)) {
                    menu.show(tabla, e.getX(), e.getY());
                }
            }
        });

    }

    public void modificarTabla(JTable tabla) {
        modificarGridTabla(tabla);
        modificarAlturaFilas(tabla);
        renderizarTabla(tabla);
    }

    public void modificarGridTabla(JTable tabla) {
        TableMaterialDesign.modificarGrid(tabla);
    }

    public void modificarAlturaFilas(JTable tabla) {
        TableMaterialDesign.modificarAlturaFilas(tabla);
    }

    public void renderizarTabla(JTable tabla) {
        tabla.setIntercellSpacing(new Dimension(0, 0));
        TableMaterialDesign.CustomRenderer cr = new TableMaterialDesign.CustomRenderer(tabla.getDefaultRenderer(Object.class), Color.WHITE, Color.WHITE, new Color(204, 204, 204), Color.WHITE);
        tabla.setDefaultRenderer(Object.class, cr);
    }

    public static void modificarTemaComboBox(JPanel... panel) throws IllegalArgumentException{
        if (panel.length <= 0) {
            throw new IllegalArgumentException("El parametro de entrada debe de tener por lo menos uno o más elementos");
        }

        for (int k = 0; k < panel.length; k++) {
            for (int i = 0; i < panel[k].getComponentCount(); i++) {
                if (panel[k].getComponent(i) instanceof JComboBox) {
                    JComboBox cb = (JComboBox) panel[k].getComponent(i);
                    cb.setUI(new ComboBoxMaterialDesign());
                }

            }
        }
    }

    protected static void agregarFocusBorder(JPanel... contenedor) throws IllegalArgumentException{
        if(contenedor.length <= 0){
            throw new IllegalArgumentException("La función debe tener uno o más parámetros de entrada");
        }
        
        for(int i = 0 ; i < contenedor.length; i++){
            MaterialDesingTema.addFocusBorder(contenedor[i]);
        }
        
    }
    
    protected void ingresarPosicionComboBox(int index, JPanel... panel) throws IllegalArgumentException{
        if(panel.length == 0){
            throw new IllegalArgumentException("La función debe de tener uno o más parámetros de entrada que coincidan con la clase o clases padres de esta");
        }
        
        for(int i = 0; i < panel.length; i++){
            for(int componente = 0; componente < panel[i].getComponentCount(); componente++){
                if(panel[i].getComponent(componente) instanceof JComboBox){
                    JComboBox cb = (JComboBox)panel[i].getComponent(componente);
                    cb.setSelectedIndex(index);
                }
            }
        }
    }

    public Object obtenerInformaciónCelda(JTable tabla, int celda){
        DefaultTableModel tm = (DefaultTableModel) tabla.getModel();
        //aca capturo el primer dato de la celda seleccionada 
        return tm.getValueAt(tabla.getSelectedRow(), celda);
    }
    
    public void cambiarEstiloTabbePane(JTabbedPane... tps) throws IllegalArgumentException{
        if(tps.length == 0){
            throw new IllegalArgumentException("Debe haber por lo menos un argumento de entrada en la función");
        }
        
        for(int i = 0 ; i < tps.length; i++){
            tps[i].setUI(new TabbedPaneMaterialDesing());
        }
        
    }

    protected static void addPlaceHolder(JComponent componente, String textoActual, String nuevoTexto){
        MaterialDesingTema.addPlaceHolder(componente, textoActual, nuevoTexto);
    }
    
    protected static void modificarElementos(JPanel panel){
        agregarFocusBorder(panel);
        modificarTemaComboBox(panel);
    }
}
