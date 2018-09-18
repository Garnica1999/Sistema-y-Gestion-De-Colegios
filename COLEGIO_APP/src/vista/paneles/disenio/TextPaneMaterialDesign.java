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
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTextPaneUI;

/**
 *
 * @author Carlos
 */
public class TextPaneMaterialDesign extends BasicTextPaneUI{
    public static ComponentUI createUI(JComponent c){
        return new TextPaneMaterialDesign();
    }
    
    public static void crearDisenio(){
        UIManager.put("TextPane.border",BorderFactory.createLineBorder(new Color(101,62,164)));
    }
}
