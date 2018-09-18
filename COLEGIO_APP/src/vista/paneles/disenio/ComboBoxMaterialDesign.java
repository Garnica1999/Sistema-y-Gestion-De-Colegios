/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.disenio;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author Carlos
 */
public class ComboBoxMaterialDesign extends BasicComboBoxUI {

    public static ComboBoxUI createUI(JComponent c) {
        return new ComboBoxMaterialDesign();
    }

    @Override 
    protected JButton createArrowButton() {
        BasicArrowButton a = new BasicArrowButton(
            BasicArrowButton.SOUTH,
            Color.white, Color.white,
            new Color(204,204,204), Color.white);
        
        a.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        return a;
    }
    
    public static void crearDisenio(){
        UIManager.put("Combobox.rendererUseListColors", true);
        UIManager.put("ComboBox.background", new Color(255,255,255));
        UIManager.put("ComboBox.border", BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(153,153,153)));
        UIManager.put("ComboBox.foreground", new Color(102,102,102));
        UIManager.put("ComboBox.buttonBackground", new Color(255,255,255));
        //UIManager.put("ComboBox.buttonDarkShadow", new Color(255,255,255));
        UIManager.put("ComboBox.buttonHighlight", new Color(255,255,255));
        UIManager.put("ComboBox.buttonShadow", new Color(255,255,255));
        UIManager.put("ComboBox.control", new Color(255,255,255));
        UIManager.put("ComboBox.selectionBackground", new Color(0,107,196));
        UIManager.put("ComboBox.selectionForeground", new Color(255,255,255));
        //UIManager.put("Focus.color", new Color(255,255,255));
        //UIManager.put("Button.border", BorderFactory.createLineBorder(Color.WHITE));
        //UIManager.put("List.border", BorderFactory.createLineBorder(new Color(204,204,204),1));*/
    }
}
