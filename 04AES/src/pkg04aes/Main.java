package pkg04aes;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("Ejemplo de cifrado AES");
        String mensaje = "haba una vez un patito que decia miau miau";
        
        String mensajeCifrado = CifradorAES.encrypt(mensaje);
        System.out.println("El mensaje cifrado es: " + mensajeCifrado);
        
        String mensajeDescifrado = CifradorAES.decrypt(mensaje);
        System.out.println("El mensaje cifrado es: " + mensajeDescifrado);
    }
}
