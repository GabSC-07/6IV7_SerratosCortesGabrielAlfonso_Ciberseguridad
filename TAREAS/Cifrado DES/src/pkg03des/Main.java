package pkg03des;

import javax.crypto.*;
import java.io.*;
import java.security.*;
import javax.crypto.spec.SecretKeySpec;

public class Main {

    private static SecretKey clave;

    static {
        try {
            KeyGenerator generador = KeyGenerator.getInstance("DES");
            generador.init(56);
            clave = generador.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new VentanaDES().setVisible(true);
        });
    }

    public static void cifrarArchivo(File archivo) throws Exception {
        Cipher cifrador = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cifrador.init(Cipher.ENCRYPT_MODE, clave);

        try (FileInputStream entrada = new FileInputStream(archivo);
             FileOutputStream salida = new FileOutputStream(archivo.getAbsolutePath() + ".cifrado")) {

            byte[] buffer = new byte[1000];
            int bytesLeidos;
            while ((bytesLeidos = entrada.read(buffer)) != -1) {
                byte[] cifrado = cifrador.update(buffer, 0, bytesLeidos);
                if (cifrado != null) {
                    salida.write(cifrado);
                }
            }
            byte[] cifradoFinal = cifrador.doFinal();
            salida.write(cifradoFinal);
        }
    }

    public static String descifrarArchivo(File archivoOriginal) throws Exception {
        Cipher cifrador = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cifrador.init(Cipher.DECRYPT_MODE, clave);

        File archivoCifrado = new File(archivoOriginal.getAbsolutePath() + ".cifrado");
        ByteArrayOutputStream resultado = new ByteArrayOutputStream();

        try (FileInputStream entrada = new FileInputStream(archivoCifrado)) {
            byte[] buffer = new byte[1000];
            int bytesLeidos;
            while ((bytesLeidos = entrada.read(buffer)) != -1) {
                byte[] descifrado = cifrador.update(buffer, 0, bytesLeidos);
                if (descifrado != null) {
                    resultado.write(descifrado);
                }
            }
            byte[] finalDescifrado = cifrador.doFinal();
            resultado.write(finalDescifrado);
        }

        return resultado.toString("UTF-8");
    }
}
