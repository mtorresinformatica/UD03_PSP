/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author DAM
 */
public class ClienteUDP {

    public static void main(String[] argv) throws Exception {
    // IP y puerto al que se envía el Datagrama
        InetAddress destino = InetAddress.getLocalHost();
        int port = 12345;
    // Buffer para recibir el datagrama
        byte[] buffer = new byte[1024];
    // El mensaje a enviar en el Datagrama se convierte a bytes
        String mensajeEnviado = "Enviando Saludos !!";
        buffer = mensajeEnviado.getBytes(); //codifico String a bytes
    // Se preparara el DatagramPacket que se va a enviar
        DatagramPacket datagramaEnviado = new DatagramPacket(buffer, buffer.length, destino, port);
    // En este caso, especificamos un puerto, aunque podríamos dejarlo para
    // que el SO asigne uno libre
        DatagramSocket socket = new DatagramSocket(34567);
        System.out.println("Host destino : " + destino.getHostName());
        System.out.println("IP Destino : " + destino.getHostAddress());
        System.out.println("Puerto local del socket: " + socket.getLocalPort());
        System.out.println("Puerto al que envio: " + datagramaEnviado.getPort());
    // Envío del Datagrama
        socket.send(datagramaEnviado);
    // Cierre y liberación de recursos
        socket.close();
    }
}
