/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.disenio;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.plaf.basic.BasicOptionPaneUI;

/**
 *
 * @author Carlos
 */
public class DialogMaterialDesign extends BasicOptionPaneUI{
    /*private final Icon errorIcon;
    private final Icon questionMessage;
    private final Icon yesIcon;
    private final Icon warningIcon;
    private final Icon informationIcon;
    private final Icon noIcon;
    private final Icon okIcon;*/
    public static OptionPaneUI createUI(JComponent c){
        return new DialogMaterialDesign();
    }
    
    public DialogMaterialDesign() {
        
    }
    
    
    public static void crearDisenio(){
        
    }
    
}
