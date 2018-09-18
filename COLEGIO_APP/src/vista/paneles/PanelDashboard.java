/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles;

import javax.swing.JLabel;

/**
 *
 * @author Carlos
 */
@SuppressWarnings("serial")
public abstract class PanelDashboard extends BasicPanelComponents{
    
    protected void construirTexto(Object data, JLabel target, String mensaje){
        String inicioTexto = "<html><body>";
        String finalTexto = "</body></html>";
        
        String cad = inicioTexto + mensaje + ": " + "<br><center>" + data + "</center>" + finalTexto;
        
        target.setText(cad);
    }
    protected abstract void cargarDatos();
    
}
