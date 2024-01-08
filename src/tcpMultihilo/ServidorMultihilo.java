/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpMultihilo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author DAM
 */
public class ServidorMultihilo {
    
    public static final int PORT = 4444;

    public static void main(String[] args) throws IOException {
        // Establece el puerto en el que escucha peticiones
        ServerSocket socketServidor = null;
        try {
            socketServidor = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("No puede escuchar en el puerto: " + PORT);
            System.exit(-1);
        }

        Socket socketCliente = null;
        BufferedReader entrada = null;
        PrintWriter salida = null;

        System.out.println("Escuchando: " + socketServidor);
        try {
            while (true) {
            // Se bloquea hasta que recibe alguna petición de un cliente
            // abriendo un socket para el cliente
            socketCliente = socketServidor.accept();
            System.out.println("Conexión aceptada: " + socketCliente);
            // Para seguir aceptando peticiones de otros clientes
            // se crea un nuevo hilo que se encargará de la comunicación con el cliente
            new Worker(socketCliente).start();
        }

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        salida.close();
        entrada.close();
        socketCliente.close();
        socketServidor.close();
    }
}
