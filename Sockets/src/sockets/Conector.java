package sockets;

import java.io.*;
import java.net.*;

/**
 *
 * @author ralison
 */
public class Conector {

    Socket cliente;
    int puerto = 9000;
    String ip = "172.17.8.34";
    BufferedReader entrada, teclado;
    PrintStream salida;

    public void Iniciar() {
        try {
            cliente = new Socket(ip, puerto); //Se crea el socket
            entrada = new BufferedReader(new InputStreamReader(
                    cliente.getInputStream())); //Se crea el canal de entrada
            teclado = new BufferedReader(new InputStreamReader(System.in));
            String tec = teclado.readLine();
            salida = new PrintStream(cliente.getOutputStream()); //Se crea canal de salida para enviar datos
            salida.println(tec);

            String rpta = entrada.readLine();
            System.out.println(rpta);

            entrada.close();
            salida.close();
            teclado.close();
            cliente.close();

        } catch (Exception e) {
        }
    }

}
