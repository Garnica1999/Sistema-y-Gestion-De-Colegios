/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.directivo;

import javax.swing.JLabel;
import vista.Principal;
import vista.paneles.PanelDashboard;

/**
 *
 * @author Carlos
 */
@SuppressWarnings("serial")
public class PanelDirectivo extends PanelDashboard {

    private final Principal principal;
    private final String usuario;
    /**
     * Creates new form PanelDirectivo
     * @param principal
     * @param usuario
     */
    public PanelDirectivo(Principal principal, String usuario) {
        initComponents();
        this.principal = principal;
        this.usuario = usuario;
        cargarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelEstudiantes = new javax.swing.JPanel();
        jLabelImagenEstudiante = new javax.swing.JLabel();
        jLabelTotalEstudiantes = new javax.swing.JLabel();
        jPanelActividades = new javax.swing.JPanel();
        jLabelImagenActividades = new javax.swing.JLabel();
        jLabelTotalActividades = new javax.swing.JLabel();
        jPanelRutas = new javax.swing.JPanel();
        jLabelImagenRutas = new javax.swing.JLabel();
        jLabelTotalRutas = new javax.swing.JLabel();
        jPanelEps = new javax.swing.JPanel();
        jLabelImagenEPS = new javax.swing.JLabel();
        jLabelTotalEPS = new javax.swing.JLabel();
        jPanelCursos = new javax.swing.JPanel();
        jLabelImagenCursos = new javax.swing.JLabel();
        jLabelTotalCursos = new javax.swing.JLabel();
        jPanelDeudas = new javax.swing.JPanel();
        jLabelImagenDeudores = new javax.swing.JLabel();
        jLabelTotalDeudores = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanelEstudiantes.setBackground(new java.awt.Color(230, 230, 230));

        jLabelImagenEstudiante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagenEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/directivos/graduate-120px.png"))); // NOI18N

        jLabelTotalEstudiantes.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabelTotalEstudiantes.setForeground(new java.awt.Color(51, 51, 51));
        jLabelTotalEstudiantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalEstudiantes.setText("<html><body>Estudiantes Matriculados:<br><center></center></body></html>");
        jLabelTotalEstudiantes.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanelEstudiantesLayout = new javax.swing.GroupLayout(jPanelEstudiantes);
        jPanelEstudiantes.setLayout(jPanelEstudiantesLayout);
        jPanelEstudiantesLayout.setHorizontalGroup(
            jPanelEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImagenEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(jLabelTotalEstudiantes)
        );
        jPanelEstudiantesLayout.setVerticalGroup(
            jPanelEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstudiantesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImagenEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabelTotalEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelActividades.setBackground(new java.awt.Color(230, 230, 230));

        jLabelImagenActividades.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagenActividades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/directivos/school-calendar-120px.png"))); // NOI18N

        jLabelTotalActividades.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabelTotalActividades.setForeground(new java.awt.Color(51, 51, 51));
        jLabelTotalActividades.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalActividades.setText("<html><body>Actividades Este Mes:<br><center></center></body></html>");
        jLabelTotalActividades.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanelActividadesLayout = new javax.swing.GroupLayout(jPanelActividades);
        jPanelActividades.setLayout(jPanelActividadesLayout);
        jPanelActividadesLayout.setHorizontalGroup(
            jPanelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImagenActividades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelTotalActividades, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        jPanelActividadesLayout.setVerticalGroup(
            jPanelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActividadesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelImagenActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelRutas.setBackground(new java.awt.Color(230, 230, 230));

        jLabelImagenRutas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagenRutas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/directivos/school-bus-120px.png"))); // NOI18N

        jLabelTotalRutas.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabelTotalRutas.setForeground(new java.awt.Color(51, 51, 51));
        jLabelTotalRutas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalRutas.setText("<html><body>Rutas Registradas:<br><center></center></body></html>");
        jLabelTotalRutas.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanelRutasLayout = new javax.swing.GroupLayout(jPanelRutas);
        jPanelRutas.setLayout(jPanelRutasLayout);
        jPanelRutasLayout.setHorizontalGroup(
            jPanelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImagenRutas, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(jLabelTotalRutas)
        );
        jPanelRutasLayout.setVerticalGroup(
            jPanelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRutasLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabelImagenRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelEps.setBackground(new java.awt.Color(230, 230, 230));

        jLabelImagenEPS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagenEPS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/directivos/hospital-2-120px.png"))); // NOI18N

        jLabelTotalEPS.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabelTotalEPS.setForeground(new java.awt.Color(51, 51, 51));
        jLabelTotalEPS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalEPS.setText("<html><body>EPS Registradas:<br><center></center></body></html>");
        jLabelTotalEPS.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanelEpsLayout = new javax.swing.GroupLayout(jPanelEps);
        jPanelEps.setLayout(jPanelEpsLayout);
        jPanelEpsLayout.setHorizontalGroup(
            jPanelEpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImagenEPS, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(jLabelTotalEPS)
        );
        jPanelEpsLayout.setVerticalGroup(
            jPanelEpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEpsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelImagenEPS, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalEPS, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelCursos.setBackground(new java.awt.Color(230, 230, 230));

        jLabelImagenCursos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagenCursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/directivos/music-class-120px.png"))); // NOI18N

        jLabelTotalCursos.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabelTotalCursos.setForeground(new java.awt.Color(51, 51, 51));
        jLabelTotalCursos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalCursos.setText("<html><body>Cursos Registrados:<br><center></center></body></html>");
        jLabelTotalCursos.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanelCursosLayout = new javax.swing.GroupLayout(jPanelCursos);
        jPanelCursos.setLayout(jPanelCursosLayout);
        jPanelCursosLayout.setHorizontalGroup(
            jPanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImagenCursos, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(jLabelTotalCursos)
        );
        jPanelCursosLayout.setVerticalGroup(
            jPanelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCursosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelImagenCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelDeudas.setBackground(new java.awt.Color(230, 230, 230));

        jLabelImagenDeudores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagenDeudores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/directivos/calculadora-120px.png"))); // NOI18N

        jLabelTotalDeudores.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabelTotalDeudores.setForeground(new java.awt.Color(51, 51, 51));
        jLabelTotalDeudores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalDeudores.setText("<html><body>Deudores actuales:<br><center></center></body></html>");
        jLabelTotalDeudores.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanelDeudasLayout = new javax.swing.GroupLayout(jPanelDeudas);
        jPanelDeudas.setLayout(jPanelDeudasLayout);
        jPanelDeudasLayout.setHorizontalGroup(
            jPanelDeudasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImagenDeudores, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(jLabelTotalDeudores)
        );
        jPanelDeudasLayout.setVerticalGroup(
            jPanelDeudasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeudasLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelImagenDeudores, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalDeudores, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelEps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelRutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelActividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelDeudas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelActividades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelEstudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDeudas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelEps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(158, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelImagenActividades;
    private javax.swing.JLabel jLabelImagenCursos;
    private javax.swing.JLabel jLabelImagenDeudores;
    private javax.swing.JLabel jLabelImagenEPS;
    private javax.swing.JLabel jLabelImagenEstudiante;
    private javax.swing.JLabel jLabelImagenRutas;
    private javax.swing.JLabel jLabelTotalActividades;
    private javax.swing.JLabel jLabelTotalCursos;
    private javax.swing.JLabel jLabelTotalDeudores;
    private javax.swing.JLabel jLabelTotalEPS;
    private javax.swing.JLabel jLabelTotalEstudiantes;
    private javax.swing.JLabel jLabelTotalRutas;
    private javax.swing.JPanel jPanelActividades;
    private javax.swing.JPanel jPanelCursos;
    private javax.swing.JPanel jPanelDeudas;
    private javax.swing.JPanel jPanelEps;
    private javax.swing.JPanel jPanelEstudiantes;
    private javax.swing.JPanel jPanelRutas;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void cargarDatos() {
        imprimirTotalEstudiantes();
        imprimitTotalCursos();
        imprimirTotalRutas();
        imprimirTotalEps();
        imprimirTotalDeudas();
        imprimirTotalActividadesDelMes();
    }

    private void imprimirTotalEstudiantes() {
        int estudiantes = this.principal.obtenerCantidadEstudiantes();
        construirTexto(estudiantes, this.jLabelTotalEstudiantes, "Estudiantes Matriculados");
    }

    private void imprimitTotalCursos() {
        int cursos = this.principal.obtenerCantidadCursos();
        construirTexto(cursos, this.jLabelTotalCursos, "Cursos Registrados");
    }

    private void imprimirTotalRutas() {
        int rutas = this.principal.obtenerCantidadRutas();
        construirTexto(rutas, this.jLabelTotalRutas, "Rutas Registradas");
    }

    private void imprimirTotalEps() {
        int eps = this.principal.obtenerCantidadEps();
        construirTexto(eps, this.jLabelTotalEPS, "EPS Registradas");
    }

    private void imprimirTotalDeudas() {
        int deudas = this.principal.obtenerCantidadDeudas();
        construirTexto(deudas, this.jLabelTotalDeudores, "Deudores Actuales");
    }

    private void imprimirTotalActividadesDelMes() {
        int actividades = this.principal.obtenerCantidadActividadesMes();
        construirTexto(actividades, this.jLabelTotalActividades, "Actividades este mes");
    }
    
}