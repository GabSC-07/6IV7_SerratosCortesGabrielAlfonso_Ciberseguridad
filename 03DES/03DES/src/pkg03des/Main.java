package pkg03des;

// es para definir entradas y salidas del sistema
// para el manejo de archivos
import java.io.*;
// es para el calculo de subllaves
import java.security.*;
// es para definir el algoritmos de cifrado
import javax.crypto.*;

// para el algoritmo
import javax.crypto.interfaces.*;
// para definir el tamaño de la clave y subclevas
import javax.crypto.spec.*;




public class Main {
    public static void main(String[] args) throws Exception{
        /*
        Lo primero es que vamos ac rear un programa mediante el cual debe de leer un archivo
        de texto plano, se debe introducir una clave, debe de cifrarlo y genrerar el archivo correspondiente cifrado
        */
        
        // Vamos a usar DES
        // Comprobar que exista un archivo cargado
        if(args.length != 1){
            mensajeAyuda();
            System.exit(1);
        }
        
        // PASO 1: Debemos de definir el algoritmo y su clave
        System.out.println("1. Genara las claves DES");
        //Para generar las calaves utiliczamos la clase KeyGenerator
        KeyGenerator generadorDES = KeyGenerator.getInstance("DES");
        System.out.println("");
        
        //Debemos inicialiazr el tamaño de la clave
        generadorDES.init(56); //el tamño de cla clave es de 64 - 8 bits de paridad
        //Wel algoritmo envia error si nos exactamente 56
        
        // tenemos dos opciones, la creamos de forma manual o utilizamos la clase SescretKey
        //Se ies de forma manual se ingresa por parte del usuario, se valida el tamaño (8 caracteres)
        // transformamos la clave en bits
        
        
        // Estas son las subclaves para las 16 rondas
        SecretKey clave = generadorDES.generateKey();
        
        System.out.println("La clave es: "+ clave);
        // No es posible distinguir los bytes de un caracter sino es ta codificado
        mostrarBytes( clave.getEncoded() );
        
        System.out.println( "Clave codificada : " + clave.getEncoded() );
        System.out.println("");
        
        /*
        El tipo de cifrado es DES, es de tipo simetrico
        significa que la clave de cifrado es la misma para descifrar.
        Hay que definir el modo de operacion del cifrado:
        
        Flujo es por Bloques
        ECB
        Si va a tener o no relleno
        Debemos de aplicar un estandar para dicho relleno
        Programar PKCS5
        */
       
        Cipher cifrador = Cipher.getInstance("DES/ECB/PKCS5Padding");
        
        // Vamos a crear el menu para cifrar y descifrar
        System.out.println("2. Cifrar un fichero con DES : " 
                + args[0] + "dejamos el resultado en: " 
                + args[0] + ".cifrado");
        
        
        // Tenemos que cargar el archivo y ejecutar el irfado
        
        cifrador.init(Cipher.ENCRYPT_MODE, clave);
        
        // Aqui es donde es mportante recordar el modo
        // ECB no puede automatizar el flujo del bloque
        
        byte[] buffer = new byte[1000];
        
        // Este arreglo sirve para guardar el resultado
        byte[] buffercifrado;
        
        //definir el archivo
        FileInputStream entrada = new FileInputStream(args[0]);
        FileOutputStream salida = new FileOutputStream(args[0]+".cifrado");
        
        
        int bytes_leidos = entrada.read(buffer, 0, 1000);
        
        while(bytes_leidos != -1){
            buffercifrado = cifrador.update(buffer, 0, 1000);
            salida.write(buffercifrado);
            bytes_leidos = entrada.read(buffer, 0, bytes_leidos);
        }
        
        // Construir salida
        buffercifrado = cifrador.doFinal();
        // Genero el archivo e alida
        salida.write(buffercifrado);
        
        entrada.close();
        salida.close();
        
        
        // Ahora a descifrar
        System.out.println("3. Descifrar un fichero con DES : " 
                + args[0] + ".cifrado " 
                + args[0] + ".descifrado");
        
        
        // Tenemos que cargar el archivo y ejecutar el irfado
        
        cifrador.init(Cipher.DECRYPT_MODE, clave);
        
        // Este arreglo sirve para guardar el resultado
        byte[] bufferdescifrado;
        
        //definir el archivo
        entrada = new FileInputStream(args[0]+".cifrado");
        salida = new FileOutputStream(args[0]+".descifrado");        
        
        bytes_leidos = entrada.read(buffer, 0, 1000);
        
        while(bytes_leidos != -1){
            bufferdescifrado = cifrador.update(buffer, 0, 1000);
            salida.write(bufferdescifrado);
            bytes_leidos = entrada.read(buffer, 0, bytes_leidos);
        }
        
        // Construir salida
        bufferdescifrado = cifrador.doFinal();
        // Genero el archivo e alida
        salida.write(bufferdescifrado);
        
        entrada.close();
        salida.close();
    }
    
    private static void mensajeAyuda(){
        System.out.println("Ejemplo de un programa que sirve para cifrar y descrifar con DES");
        System.out.println("Favor de ingresar un archivo de texto plano, sino no funciona osea .txt");
    }

    private static void mostrarBytes(byte[] buffer) {
        //Gracias a que es ECB solo tenemos que escribir el formato de tipo de buffer para el archivo
        System.out.write(buffer, 0, buffer.length);
    }
}


