package com.dg;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetUtilTest {

    public void getHostname(){
        try {
            final InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("IP Address: "+inetAddress.getHostName());
            System.out.println("Hostname: "+inetAddress.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
