package rsa;

import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;
import org.netbeans.lib.awtextra.*;

public class CifrarWindow extends JFrame {
    private JButton btnRegresar, btnCifrar;
    private JLabel lbl_title, lbl_cifrar, lbl_cifrado;
    private JLabel txt_p, txt_q, txt_n, txt_fi, txt_e, txt_d;
    private JTextField txt_numcifrado;
    private JTextArea numcifrado;
    
    BigInteger n, p, q, fi, e, d;
    String mensaje;

    public CifrarWindow() {
        setTitle("RSA - Cifrado");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel frame = new JPanel( new BorderLayout() );
        frame.add( PanelVentana() );
        
        add(frame);
    }
    
    private JPanel PanelVentana(){
        // El fondo
        JPanel bg = new JPanel( new AbsoluteLayout() );
        bg.setBackground( new Color(255, 240, 200) );
        
        // Botón regresar
        btnRegresar = new JButton("Regresar");
        btnRegresar.setBackground(Color.RED);
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.setCursor(new java.awt.Cursor(HAND_CURSOR));
        btnRegresar.addActionListener(e -> regresarVentana());
        bg.add(btnRegresar, new AbsoluteConstraints(600, 25, 100, 40));
        
        // Label título
        lbl_title = new JLabel("Cifrado");
        lbl_title.setFont(new Font("Arial", Font.BOLD, 40));
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg.add(lbl_title, new AbsoluteConstraints(0, 35, 750, 50));
        
        // Número a cifrar
        lbl_cifrar = new JLabel("Ingresa el número a cifrar (máximo 3 dígitos):");
        lbl_cifrar.setFont(new Font("Arial", Font.PLAIN, 16));
        bg.add(lbl_cifrar, new AbsoluteConstraints(70, 80, 500, 50));

        txt_numcifrado = new JTextField(20);
        txt_numcifrado.setFont(new Font("Arial", Font.PLAIN, 18));
        bg.add(txt_numcifrado, new AbsoluteConstraints(100, 130, 130, 30));
        
        btnCifrar = new JButton("Cifrar");
        btnCifrar.setBackground(new Color(20, 160, 40));
        btnCifrar.setForeground(Color.WHITE);
        btnCifrar.setCursor(new java.awt.Cursor(HAND_CURSOR));
        btnCifrar.addActionListener(e -> cifrarNumero());
        bg.add(btnCifrar, new AbsoluteConstraints(250, 130, 90, 30));
        
        // Labels Elementos RSA
        txt_p = new JLabel("P: ");
        txt_p.setForeground(new Color(20, 25, 160));
        txt_p.setFont(new Font("Arial", Font.BOLD, 18));
        bg.add(txt_p, new AbsoluteConstraints(100, 200, 100, 50));
        
        txt_q = new JLabel("Q: ");
        txt_q.setForeground(new Color(20, 25, 160));
        txt_q.setFont(new Font("Arial", Font.BOLD, 18));
        bg.add(txt_q, new AbsoluteConstraints(100, 250, 100, 50));
        
        txt_n = new JLabel("N: ");
        txt_n.setForeground(new Color(20, 25, 160));
        txt_n.setFont(new Font("Arial", Font.BOLD, 18));
        bg.add(txt_n, new AbsoluteConstraints(300, 200, 150, 50));
        
        txt_fi = new JLabel("Fi: ");
        txt_fi.setForeground(new Color(20, 25, 160));
        txt_fi.setFont(new Font("Arial", Font.BOLD, 18));
        bg.add(txt_fi, new AbsoluteConstraints(300, 250, 150, 50));
        
        txt_e = new JLabel("E: ");
        txt_e.setForeground(new Color(20, 25, 160));
        txt_e.setFont(new Font("Arial", Font.BOLD, 18));
        bg.add(txt_e, new AbsoluteConstraints(500, 200, 150, 50));
        
        txt_d = new JLabel("D: ");
        txt_d.setForeground(new Color(20, 25, 160));
        txt_d.setFont(new Font("Arial", Font.BOLD, 18));
        bg.add(txt_d, new AbsoluteConstraints(500, 250, 150, 50));
        
        // Número cifrado    
        lbl_cifrado = new JLabel("Número cifrado: ");
        lbl_cifrado.setFont(new Font("Arial", Font.PLAIN, 18));
        bg.add(lbl_cifrado, new AbsoluteConstraints(150, 350, 500, 50));

        numcifrado = new JTextArea(2, 20);
        numcifrado.setLineWrap(true);
        numcifrado.setEditable(false);
        numcifrado.setFont(new Font("Arial", Font.PLAIN, 16));
        numcifrado.setBackground(Color.WHITE);
        JScrollPane scrollPane2 = new JScrollPane(numcifrado);
        scrollPane2.setPreferredSize(new Dimension(300, 45));
        bg.add(scrollPane2, new AbsoluteConstraints(300, 350, 300, 50));
        
        return bg;
    }

    public void cifrarNumero(){
        mensaje = txt_numcifrado.getText().trim();
        try {
            int numero = Integer.parseInt(mensaje);
            if (numero < 0 || numero > 999) {
            JOptionPane.showMessageDialog(this, "El número debe tener máximo 3 dígitos (0 - 999)");
            return;
            }
        }catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Debes ingresar un número válido");
        return;
        }
        RSAAlgoritmo rsa = new RSAAlgoritmo();
        rsa.generarPrimos();
        rsa.generarClaves();

        p = rsa.getP();
        q = rsa.getQ();
        n = rsa.getN();
        fi = rsa.getFi();
        e = rsa.getE();
        d = rsa.getD();

        txt_p.setText("P: " + p);
        txt_q.setText("Q: " + q);
        txt_n.setText("N: " + n);
        txt_fi.setText("Fi: " + fi);
        txt_e.setText("E: " + e);
        txt_d.setText("D: " + d);

        BigInteger[] mensajeCifrado = rsa.cifrar(mensaje);

        StringBuilder cifradoStr = new StringBuilder();
        for (BigInteger num : mensajeCifrado) {
        cifradoStr.append(num.toString()).append(" ");
        }
        numcifrado.setText(cifradoStr.toString());
    }

    private void regresarVentana() {
        this.dispose();
        
        App inicio = new App();
        inicio.setVisible(true);
    }
}