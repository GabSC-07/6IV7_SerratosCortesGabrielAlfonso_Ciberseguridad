package pkg03des;

import javax.swing.*;
import java.io.File;

public class VentanaDES extends javax.swing.JFrame {
    private File archivo;
    
    public VentanaDES() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        btnCifrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        btnCargar = new javax.swing.JButton();
        btnDescifrar = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmo DES");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setName("frame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(650, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(650, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(159, 224, 249));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCifrar.setBackground(new java.awt.Color(255, 248, 178));
        btnCifrar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnCifrar.setText("Cifrar");
        btnCifrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 0), 2, true));
        btnCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCifrarActionPerformed(evt);
            }
        });
        bg.add(btnCifrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 170, 130, 45));

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        textArea.setRows(5);
        textArea.setMargin(new java.awt.Insets(8, 8, 8, 8));
        jScrollPane1.setViewportView(textArea);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 240, 420, 115));

        btnCargar.setBackground(new java.awt.Color(252, 227, 162));
        btnCargar.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        btnCargar.setText("Cargar archivo");
        btnCargar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 102, 0), 3, true));
        btnCargar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        bg.add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 85, 200, 50));

        btnDescifrar.setBackground(new java.awt.Color(255, 248, 178));
        btnDescifrar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnDescifrar.setText("Descifrar");
        btnDescifrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 0), 2, true));
        btnDescifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescifrarActionPerformed(evt);
            }
        });
        bg.add(btnDescifrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 170, 130, 45));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(159, 224, 249));
        jTextField2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Algoritmo DES");
        jTextField2.setBorder(null);
        bg.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 20, 300, 50));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        JFileChooser chooser = new JFileChooser();
        int resultado = chooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            archivo = chooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Archivo cargado: " + archivo.getName());
        }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCifrarActionPerformed
        if (archivo != null) {
            try {
                Main.cifrarArchivo(archivo);
                JOptionPane.showMessageDialog(this, "Archivo cifrado creado: " + archivo.getName() + ".cifrado");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al cifrar: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe cargar un archivo primero.");
        }
    }//GEN-LAST:event_btnCifrarActionPerformed

    private void btnDescifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescifrarActionPerformed
        if (archivo != null) {
            try {
                String resultado = Main.descifrarArchivo(archivo);
                textArea.setText(resultado);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al descifrar: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe cargar un archivo primero.");
        }
    }//GEN-LAST:event_btnDescifrarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaDES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnCifrar;
    private javax.swing.JButton btnDescifrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
