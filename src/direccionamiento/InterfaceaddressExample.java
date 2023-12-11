/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package direccionamiento;

import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.List;

/**
 *
 * @author DAM
 */
public class InterfaceaddressExample
{
    public static void main(String[] args) throws SocketException
    {
        // Modify according to your system
        NetworkInterface nif = NetworkInterface.getByIndex(1);
        List<InterfaceAddress> list = nif.getInterfaceAddresses();

        for (InterfaceAddress iaddr : list)
        {
            // getAddress() method
            System.out.println("getAddress() : " + iaddr.getAddress());

            // getBroadcast() method
            System.out.println("getBroadcast() : " + iaddr.getBroadcast());

            // getNetworkPrefixLength() method
            System.out.println("PrefixLength : " + iaddr.getNetworkPrefixLength());

            // hashCode() method
            System.out.println("Hashcode : " + iaddr.hashCode());

            // toString() method
            System.out.println("toString() : " + iaddr.toString());
        }
    }
}

