/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.disenio;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author Carlos
 */
public class MaterialDesingTema{
    
    public static final Color colorFocus = new Color(0,107,196);
    public static final Color colorNoFocus = new Color(153,153,153);
    
    public static void addPlaceHolder(JComponent componente, String textoActual, String nuevoTexto) {
        if (componente instanceof JTextField) {
            if (((JTextField)componente).getText().equals(textoActual)) {
                ((JTextField)componente).setText(nuevoTexto);
            }
        } else if (componente instanceof JTextPane) {
            if (((JTextPane)componente).getText().equals(textoActual)) {
                ((JTextPane)componente).setText(nuevoTexto);
            }
        } else if(componente instanceof JPasswordField){
            String cad = new String(((JPasswordField)componente).getPassword());
            if (cad.equals(textoActual)) {
                ((JPasswordField)componente).setText(nuevoTexto);
            }
        }
    }
    
    private static void addFocusOnSelectedComponent(JComponent componente, Color newColor){
        if(componente instanceof JTextField){
            ((JTextField)componente).setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, newColor));
        } else if(componente instanceof JPasswordField){
            ((JPasswordField)componente).setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, newColor));
        }else if(componente instanceof JComboBox){
            ((JComboBox)componente).setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, newColor));
        }
    }
    
    public static void addFocusBorder(JPanel contenedor) {
        for (int i = 0; i < contenedor.getComponentCount(); i++) {
            if (contenedor.getComponent(i) instanceof JTextField) {
                final JTextField texto = ((JTextField) contenedor.getComponent(i));
                texto.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        MaterialDesingTema.addFocusOnSelectedComponent(texto, MaterialDesingTema.colorFocus);
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        MaterialDesingTema.addFocusOnSelectedComponent(texto, MaterialDesingTema.colorNoFocus);
                    }
                });
            } else if (contenedor.getComponent(i) instanceof JComboBox) {
                final JComboBox comp = ((JComboBox) contenedor.getComponent(i));
                comp.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        MaterialDesingTema.addFocusOnSelectedComponent(comp, colorFocus);
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        MaterialDesingTema.addFocusOnSelectedComponent(comp, colorNoFocus);
                    }
                });

            }
        }
    }
}
