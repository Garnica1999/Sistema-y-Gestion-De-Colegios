/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.disenio;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

/**
 *
 * @author Carlos
 */
public class TabbedPaneMaterialDesing extends BasicTabbedPaneUI{
    public static TabbedPaneUI createUI(JComponent c){
        return new TabbedPaneMaterialDesing();
    }
    
    public static void crearDisenio(){
        UIManager.put("TabbedPane.focus", new Color(88,165,240));
        UIManager.put("TabbedPane.selected", new Color(88,165,240));
        UIManager.put("TabbedPane.contentBorderInsets", new Insets(0,0,0,0));
        UIManager.put("TabbedPane.contentAreaColor", new Color(88,165,240));
        UIManager.put("TabbedPane.tabsOverlapBorder", false);
        UIManager.put("TabbedPane.tabAreaInsets", new Insets(0,0,0,0));
        UIManager.put("TabbedPane.highlight", new Color(88,165,240));
        UIManager.put("TabbedPane.light", new Color(88,165,240));
        
        UIManager.put("TabbedPane.tabAreaBackground", new Color(88,165,240));
        UIManager.put("TabbedPane.tabsOverlapBorder", false);
        UIManager.put("TabbedPane.darkShadow", new Color(88,165,240));    
        UIManager.put("TabbedPane.selectHighlight", new Color(88,165,240));
        UIManager.put("TabbedPane.selectionFollowsFocus", false);
        UIManager.put("TabbedPane.selectedTabPadInsets", new Insets(0,0,0,0));
        UIManager.put("TabbedPane.shadow", new Color(88,165,240));
        UIManager.put("TabbedPane.font", new Font("Segoe UI", Font.PLAIN, 18));
        //UIManager.put("TabbedPane.tabsOverlapBorder", false);
        //UIManager.put("TabbedPane.tabsOpaque", true);
    }

}
