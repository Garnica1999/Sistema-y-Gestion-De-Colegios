/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.disenio;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author Carlos
 */
public class ButtonMaterialDesign extends BasicButtonUI{
    public static ButtonUI createUI(JComponent c){
        return new ButtonMaterialDesign();
    }
    
    public static void crearDisenio(){
        /*UIManager.put("Button.focus", new Color(255,255,255));
        UIManager.put("Button.border", BorderFactory.createLineBorder(new Color(101,62,164), 2));
        UIManager.put("Button.background", new Color(255,255,255));
        UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 18));
        UIManager.put("Button.foreground", new Color(101,62,164));
        UIManager.put("Button.select", null);*/
    }
}
