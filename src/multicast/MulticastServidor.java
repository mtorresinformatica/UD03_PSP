/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 *
 * @author DAM
 */
public class MulticastServidor {

    public static void main(String args[]) throws Exception {
// Enviamos la información introducida por teclado hasta que se envíe un *
        Scanner in = new Scanner(System.in);
//Se crea el socket multicast.
        MulticastSocket ms = new MulticastSocket();
// Se escoge un puerto para el server
        int puerto = 12345;
// Se escoge una dirección para el grupo
        InetAddress grupoMulticast = InetAddress.getByName("225.0.0.1");
        String cadena = "";
        while (!cadena.trim().equals("*")) {
            System.out.print("Datos a enviar al grupo: ");
            cadena = in.nextLine();
// Enviamos el mensaje a todos los clientes que se hayan unido al grupo
            DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupoMulticast, puerto);
            ms.send(paquete);
        }
// Cerramos recursos
        ms.close();
        System.out.println("Socket cerrado...");
    }
}
