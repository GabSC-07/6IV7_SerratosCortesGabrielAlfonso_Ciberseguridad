package rsa;

public class App extends javax.swing.JFrame {

    public App() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        lbl_extra = new javax.swing.JLabel();
        btn_descifrar = new javax.swing.JButton();
        btn_cifrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RSA - INICIO");
        setMaximumSize(new java.awt.Dimension(750, 500));
        setResizable(false);

        bg.setBackground(new java.awt.Color(204, 255, 204));
        bg.setPreferredSize(new java.awt.Dimension(750, 500));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_title.setFont(new java.awt.Font("Arial", 1, 70)); // NOI18N
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("RSA");
        lbl_title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bg.add(lbl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 750, -1));

        lbl_extra.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbl_extra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_extra.setText("Elige una opción");
        bg.add(lbl_extra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 750, -1));

        btn_descifrar.setBackground(new java.awt.Color(255, 204, 255));
        btn_descifrar.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        btn_descifrar.setText("Descifrar");
        btn_descifrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 153), 3, true));
        btn_descifrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_descifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_descifrarActionPerformed(evt);
            }
        });
        bg.add(btn_descifrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 290, 80));

        btn_cifrar.setBackground(new java.awt.Color(255, 255, 204));
        btn_cifrar.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        btn_cifrar.setText("Cifrar");
        btn_cifrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 3, true));
        btn_cifrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cifrarActionPerformed(evt);
            }
        });
        bg.add(btn_cifrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 290, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cifrarActionPerformed
        this.dispose();
        
        CifrarWindow cifrar = new CifrarWindow();
        cifrar.setVisible(true);
    }//GEN-LAST:event_btn_cifrarActionPerformed

    private void btn_descifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_descifrarActionPerformed
        this.dispose();
        
        DescifrarWindow descifrar = new DescifrarWindow();
        descifrar.setVisible(true);
    }//GEN-LAST:event_btn_descifrarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new App().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btn_cifrar;
    private javax.swing.JButton btn_descifrar;
    private javax.swing.JLabel lbl_extra;
    private javax.swing.JLabel lbl_title;
    // End of variables declaration//GEN-END:variables
}
