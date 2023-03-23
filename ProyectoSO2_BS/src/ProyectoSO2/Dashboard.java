/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSO2;

import ProyectoSO2.Nacho.Reproductor;

/**
 *
 * @author frand
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        IconTLOU = new javax.swing.JPanel();
        TLOUIcon = new javax.swing.JLabel();
        Cola1TLOU = new javax.swing.JScrollPane();
        Prioridad1 = new javax.swing.JTextArea();
        Cola2TLOU = new javax.swing.JScrollPane();
        Prioridad2 = new javax.swing.JTextArea();
        Cola3TLOU = new javax.swing.JScrollPane();
        Prioridad3 = new javax.swing.JTextArea();
        jScrollPaneRefuerzos = new javax.swing.JScrollPane();
        Refuerzos = new javax.swing.JTextArea();
        HalfTime = new javax.swing.JButton();
        idTLOU = new javax.swing.JTextField();
        nombreTLOU = new javax.swing.JTextField();
        poderTLOU = new javax.swing.JTextField();
        Prioridad1TLOU = new javax.swing.JLabel();
        Prioridad2TLOU = new javax.swing.JLabel();
        Prioridad3TLOU = new javax.swing.JLabel();
        IDTLOU = new javax.swing.JLabel();
        NameTLOU = new javax.swing.JLabel();
        PoderTLOU = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(1366, 768));
        jPanel1.setMinimumSize(new java.awt.Dimension(1366, 768));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TLOUIcon.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout IconTLOULayout = new javax.swing.GroupLayout(IconTLOU);
        IconTLOU.setLayout(IconTLOULayout);
        IconTLOULayout.setHorizontalGroup(
            IconTLOULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TLOUIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        IconTLOULayout.setVerticalGroup(
            IconTLOULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TLOUIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );

        jPanel1.add(IconTLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, 260, 240));

        Prioridad1.setEditable(false);
        Prioridad1.setColumns(20);
        Prioridad1.setRows(5);
        Cola1TLOU.setViewportView(Prioridad1);

        jPanel1.add(Cola1TLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 460, 290, 100));

        Prioridad2.setEditable(false);
        Prioridad2.setColumns(20);
        Prioridad2.setRows(5);
        Cola2TLOU.setViewportView(Prioridad2);

        jPanel1.add(Cola2TLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 630, 290, 100));

        Prioridad3.setEditable(false);
        Prioridad3.setColumns(20);
        Prioridad3.setRows(5);
        Cola3TLOU.setViewportView(Prioridad3);

        jPanel1.add(Cola3TLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 630, 300, 100));

        Refuerzos.setEditable(false);
        Refuerzos.setColumns(20);
        Refuerzos.setRows(5);
        jScrollPaneRefuerzos.setViewportView(Refuerzos);

        jPanel1.add(jScrollPaneRefuerzos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 340, 170));

        HalfTime.setText("Half-Time");
        HalfTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HalfTimeActionPerformed(evt);
            }
        });
        jPanel1.add(HalfTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, -1, -1));

        idTLOU.setEditable(false);
        idTLOU.setRequestFocusEnabled(false);
        idTLOU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTLOUActionPerformed(evt);
            }
        });
        jPanel1.add(idTLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 120, 30, -1));

        nombreTLOU.setEditable(false);
        jPanel1.add(nombreTLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 180, 150, -1));

        poderTLOU.setEditable(false);
        jPanel1.add(poderTLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 240, 30, -1));

        Prioridad1TLOU.setForeground(new java.awt.Color(255, 255, 255));
        Prioridad1TLOU.setText("Prioridad 1");
        jPanel1.add(Prioridad1TLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 430, -1, -1));

        Prioridad2TLOU.setForeground(new java.awt.Color(255, 255, 255));
        Prioridad2TLOU.setText("Prioridad 2");
        jPanel1.add(Prioridad2TLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 590, -1, -1));

        Prioridad3TLOU.setForeground(new java.awt.Color(255, 255, 255));
        Prioridad3TLOU.setText("Prioridad 3");
        jPanel1.add(Prioridad3TLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 590, -1, -1));

        IDTLOU.setForeground(new java.awt.Color(255, 255, 255));
        IDTLOU.setText("ID");
        jPanel1.add(IDTLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 100, -1, -1));

        NameTLOU.setForeground(new java.awt.Color(255, 255, 255));
        NameTLOU.setText("Nombre");
        jPanel1.add(NameTLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 160, -1, -1));

        PoderTLOU.setForeground(new java.awt.Color(255, 255, 255));
        PoderTLOU.setText("Poder ");
        jPanel1.add(PoderTLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 220, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProyectoSO2/Imagenes/Proyecto SO HboMax Interface (1366 × 768 px) (1).png"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HalfTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HalfTimeActionPerformed
        // TODO add your handling code here:
        Reproductor.launch();
    }//GEN-LAST:event_HalfTimeActionPerformed

    private void idTLOUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTLOUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTLOUActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Cola1TLOU;
    private javax.swing.JScrollPane Cola2TLOU;
    private javax.swing.JScrollPane Cola3TLOU;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton HalfTime;
    private javax.swing.JLabel IDTLOU;
    public javax.swing.JPanel IconTLOU;
    private javax.swing.JLabel NameTLOU;
    private javax.swing.JLabel PoderTLOU;
    public static javax.swing.JTextArea Prioridad1;
    private javax.swing.JLabel Prioridad1TLOU;
    public static javax.swing.JTextArea Prioridad2;
    private javax.swing.JLabel Prioridad2TLOU;
    public static javax.swing.JTextArea Prioridad3;
    private javax.swing.JLabel Prioridad3TLOU;
    public static javax.swing.JTextArea Refuerzos;
    public static javax.swing.JLabel TLOUIcon;
    public static javax.swing.JTextField idTLOU;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneRefuerzos;
    public static javax.swing.JTextField nombreTLOU;
    public static javax.swing.JTextField poderTLOU;
    // End of variables declaration//GEN-END:variables
}
