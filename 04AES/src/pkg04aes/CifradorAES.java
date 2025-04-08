package pkg04aes;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

public class CifradorAES {
    // Generar las subllaves y metodos para cifrar y descrifarr
    
    // Un método para la llave
    public static final byte[] keyvalue = new byte[]{
        /* Recordemos que dentro de AES se van a manejar diferentes tamaños de
        la llave de acuerdo al tipo de operación
         128    16 caractéres | 9 rondas
         192    24 caractéres | 11 rondas
         256    32 caractéres | 13 rondas */
        
        'q', 'w', 'e', 'r', 't', 'y', 'u', 'i',
        'q', 'w', 'e', 'r', 't', 'y', 'u', 'i'
    };
    
    // Vamos a definir la instancia del algorítmo
    private static final String instancia = "AES";
    
    
    public static String encrypt( String Data ) throws Exception{
        /*Para poder cifrar debemos de generar las subclaves necesarias para 
        ejecutar el algoritmo acorde al número de rondas, para ello vamos 
        a ocupar un método de generación de claves*/
        
        Key subllave = generateKey();
        
        // Inicializamos el cifrado
        Cipher cifrado = Cipher.getInstance(instancia);       
        cifrado.init(Cipher.ENCRYPT_MODE, subllave);
        
        // Obtener el mensaje que se quiere cifrar y lo transformamos en bytes
        byte[] encValores = cifrado.doFinal( Data.getBytes() );
        System.out.println( "Mensaje cifrado sin formato: " + encValores );
        
        /* Debemos aplicar formato de codificación base 64 a partir de
        la librería sun con un objeto BASE64Encoder */
        //String valores_enc_format = new BASE64Encoder().encode(encValores);
        
        String cadenaEncriptada = encValores.toString();
        return cadenaEncriptada;
    }
    
    public static String decrypt( String valoresencriptados ) throws Exception{
        Key subllave = generateKey();
        
        // Inicializamos el cifrado
        Cipher cifrado = Cipher.getInstance(instancia);       
        cifrado.init(Cipher.DECRYPT_MODE, subllave);
        
        // Obtener el mensaje que se quiere cifrar y lo transformamos en bytes
        //byte[] decValores = new BASE64Encoder().decodeBuffer(valoresencriptados);
        
        byte[] decValores = cifrado.doFinal(valoresencriptados.getBytes());
        System.out.println( "Mensaje descifrado sin formato: " + decValores );
        
        //String valores_enc_format = new BASE64Encoder().encode(encValores);
        
        String valoresDescifrados = new String(decValores);
        return valoresDescifrados;
    }
    
    private static Key generateKey() throws Exception{
        // Vamos a ocupar llaves a partir de SecretKeySpec
        Key subllavekawaii = new SecretKeySpec(keyvalue, instancia);
        return subllavekawaii;
    }
}
