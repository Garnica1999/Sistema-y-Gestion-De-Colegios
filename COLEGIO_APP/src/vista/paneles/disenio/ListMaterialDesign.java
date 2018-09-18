/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.disenio;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ListUI;
import javax.swing.plaf.basic.BasicListUI;

/**
 *
 * @author Carlos
 */
public class ListMaterialDesign extends BasicListUI{
    public static ListUI createUI(JComponent c){
        return new ListMaterialDesign();
    }
    
    public static void crearDisenio(){
        UIManager.put("List.selectionForeground", new Color(255,255,255));
        UIManager.put("List.focusCellHighlightBorder", BorderFactory.createEmptyBorder());
    }
}
