package rsa;

import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;
import org.netbeans.lib.awtextra.*;

public class DescifrarWindow extends JFrame {
    private JButton btnRegresar, btnDescifrar;
    private JLabel lbl_title, lbl_d, lbl_n, lbl_cifrado, lbl_descifrado;
    private JTextField txt_d, txt_n, txt_cifrado;
    private JTextArea txt_descifrado;

    public DescifrarWindow() {
        setTitle("RSA - Descifrado");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel frame = new JPanel(new BorderLayout());
        frame.add(PanelVentana());

        add(frame);
    }

    private JPanel PanelVentana() {
        JPanel bg = new JPanel(new AbsoluteLayout());
        bg.setBackground(new Color(240, 240, 255));

        // Botón regresar
        btnRegresar = new JButton("Regresar");
        btnRegresar.setBackground(Color.RED);
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.setCursor(new java.awt.Cursor(HAND_CURSOR));
        btnRegresar.addActionListener(e -> regresarVentana());
        bg.add(btnRegresar, new AbsoluteConstraints(600, 25, 100, 40));

        // Label título
        lbl_title = new JLabel("Descifrado");
        lbl_title.setFont(new Font("Arial", Font.BOLD, 40));
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg.add(lbl_title, new AbsoluteConstraints(0, 35, 750, 50));

        // Label y campo para d
        lbl_d = new JLabel("Ingrese d:");
        lbl_d.setFont(new Font("Arial", Font.PLAIN, 16));
        bg.add(lbl_d, new AbsoluteConstraints(100, 110, 120, 30));

        txt_d = new JTextField(20);
        txt_d.setFont(new Font("Arial", Font.PLAIN, 18));
        bg.add(txt_d, new AbsoluteConstraints(300, 110, 300, 30));

        // Label y campo para n
        lbl_n = new JLabel("Ingrese n:");
        lbl_n.setFont(new Font("Arial", Font.PLAIN, 16));
        bg.add(lbl_n, new AbsoluteConstraints(100, 160, 120, 30));

        txt_n = new JTextField(20);
        txt_n.setFont(new Font("Arial", Font.PLAIN, 18));
        bg.add(txt_n, new AbsoluteConstraints(300, 160, 300, 30));

        // Label y campo para número cifrado
        lbl_cifrado = new JLabel("Ingrese el número cifrado:");
        lbl_cifrado.setFont(new Font("Arial", Font.PLAIN, 16));
        bg.add(lbl_cifrado, new AbsoluteConstraints(100, 210, 200, 30));

        txt_cifrado = new JTextField(40);
        txt_cifrado.setFont(new Font("Arial", Font.PLAIN, 18));
        bg.add(txt_cifrado, new AbsoluteConstraints(300, 210, 300, 30));

        // Botón descifrar
        btnDescifrar = new JButton("Descifrar");
        btnDescifrar.setBackground(new Color(20, 160, 40));
        btnDescifrar.setForeground(Color.WHITE);
        btnDescifrar.setCursor(new java.awt.Cursor(HAND_CURSOR));
        btnDescifrar.addActionListener(e -> descifrarNumero());
        bg.add(btnDescifrar, new AbsoluteConstraints(300, 280, 120, 40));

        // Label y área para resultado descifrado
        lbl_descifrado = new JLabel("Número descifrado:");
        lbl_descifrado.setFont(new Font("Arial", Font.PLAIN, 18));
        bg.add(lbl_descifrado, new AbsoluteConstraints(130, 360, 500, 50));

        txt_descifrado = new JTextArea(2, 20);
        txt_descifrado.setLineWrap(true);
        txt_descifrado.setEditable(false);
        txt_descifrado.setFont(new Font("Arial", Font.PLAIN, 16));
        txt_descifrado.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(txt_descifrado);
        scrollPane.setPreferredSize(new Dimension(300, 45));
        bg.add(scrollPane, new AbsoluteConstraints(300, 360, 300, 50));

        return bg;
    }

    public void descifrarNumero() {
        String dStr = txt_d.getText().trim();
        String nStr = txt_n.getText().trim();
        String cifradoStr = txt_cifrado.getText().trim();

        if (dStr.isEmpty() || nStr.isEmpty() || cifradoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes llenar todos los campos.");
            return;
        }

        try {
            BigInteger d = new BigInteger(dStr);
            BigInteger n = new BigInteger(nStr);
            String[] dividir = cifradoStr.split(" ");
            BigInteger[] cifrado = new BigInteger[dividir.length];
            for (int i = 0; i < dividir.length; i++) {
                cifrado[i] = new BigInteger(dividir[i]);
            }

            RSAAlgoritmo rsa = new RSAAlgoritmo();
            // Asignar manualmente d y n
            rsa.d = d;
            rsa.n = n;
            String descifrado = rsa.descifrar(cifrado);

            txt_descifrado.setText(descifrado);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Verifica que los datos sean válidos.");
        }
    }

    private void regresarVentana() {
        this.dispose();
        App inicio = new App();
        inicio.setVisible(true);
    }
}