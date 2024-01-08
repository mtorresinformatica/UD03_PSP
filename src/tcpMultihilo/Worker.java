/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpMultihilo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author DAM
 */
public class Worker extends Thread {

    private Socket socketCliente;
    private BufferedReader entrada = null;
    private PrintWriter salida = null;

    Worker(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    @Override
    public void run() {
        try {
            // Establece canal de entrada
            entrada = new BufferedReader(new InputStreamReader(
                    socketCliente.getInputStream()));
            // Establece canal de salida
            salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    socketCliente.getOutputStream())), true);

            // Realizamos la comunicación entre servidor y cliente
            // **** ES LO QUE CAMBIA EN CADA EJERCICIO ****
            // Hacemos una recepción de información desde el cliente
            String mensajeRecibido = entrada.readLine();
            System.out.println("<-- Cliente: " + mensajeRecibido);

            // Hacemos un envío al cliente
            String mensajeEnviado = "Mensaje enviado desde el servidor al cliente";
            salida.println(mensajeEnviado);
            System.out.println("--> Cliente: " + mensajeEnviado);
        } catch (Exception e) {
        }
    }

}
