/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author DAM
 */
public class MulticastCliente {
    
public static void main(String args[]) throws Exception {
//Se crea el socket multicast
// El puerto debe ser el mismo en todos los clientes, ya que el
// servidor multicast envía la información a la IP multicast y a un puerto
int puerto = 12345;//Puerto multicast
MulticastSocket ms = new MulticastSocket(puerto);
//Nos unimos al grupo multicast
InetAddress grupo = InetAddress.getByName("225.0.0.1");
ms.joinGroup(grupo);
//ms.joinGroup(mcastaddr, netIf);
String msg = "";
while (!msg.trim().equals("*")) {
// El buffer se crea dentro del bucle para que se sobrescriba
// con cada nuevo mensaje
byte[] buf = new byte[1000];
DatagramPacket paquete = new DatagramPacket(buf, buf.length);
//Recibe el paquete del servidor multicast
ms.receive(paquete);
msg = new String(paquete.getData());
System.out.println("Recibo: " + msg.trim());
}
// Abandonamos grupo
ms.leaveGroup(grupo);
//ms.leaveGroup(mcastaddr, netIf);
// Cerramos recursos
ms.close();
System.out.println("Socket cerrado...");
}
}