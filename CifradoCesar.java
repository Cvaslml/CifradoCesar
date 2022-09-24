package controlador;

import java.io.IOException;
import java.util.Scanner;

public class CifradoCesar {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String texto;
        int n;
        char opcion;
        // Introducir un texto
        do {
            System.out.print("Introduce el texto: ");
            texto = sc.nextLine();
        } while (texto.isEmpty());
        // Introducir el valor del desplazamiento
        do {
            System.out.print("Introduce el numero de desplazamiento: ");
            n = sc.nextInt();
        } while (n < 1);

        // Introducir la operación a realizar: cifrar o descifrar
        do {
            sc.nextLine();
            System.out.print("(C) cifrar o (D) descifrar?: ");
            opcion = (char) System.in.read();
        } while (Character.toUpperCase(opcion) != 'C' && Character.toUpperCase(opcion) != 'D');
        if (Character.toUpperCase(opcion) == 'C') {
            System.out.println("Texto cifrado: " + cifradoCesar(texto, n));
        } else {
            System.out.println("Texto descifrado: " + descifradoCesar(texto, n));
        }
    }

    // método para cifrar el texto
    public static String cifradoCesar(String texto, int n) {
        StringBuilder cifrado = new StringBuilder();
        n = n % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + n) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + n - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + n));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + n) > 'Z') {
                    cifrado.append((char) (texto.charAt(i) + n - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + n));
                }
            }
        }
        return cifrado.toString();
    }

    // método para descifrar el texto
    public static String descifradoCesar(String texto, int n) {
        StringBuilder cifrado = new StringBuilder();
        n = n % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) - n) < 'a') {
                    cifrado.append((char) (texto.charAt(i) - n + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - n));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) - n) < 'A') {
                    cifrado.append((char) (texto.charAt(i) - n + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - n));
                }
            }
        }
        return cifrado.toString();
    }
}