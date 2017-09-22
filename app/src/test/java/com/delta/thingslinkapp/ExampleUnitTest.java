package com.delta.thingslinkapp;

import org.junit.Test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {


        String mS = GetInetAddress("172.17.52.43");
        System.out.println(mS);
        assertEquals(4, 2 + 2);
    }
    public String GetInetAddress(String host) {
        String IPAddress = "dg3smt-server.delta.crop";
        InetAddress ReturnStr1 = null;
        try {
            ReturnStr1 = java.net.InetAddress.getByName(host);
            IPAddress = ReturnStr1.getHostAddress();
            isAddressAvailable(IPAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return IPAddress;
        }
        return IPAddress;
    }

    void isAddressAvailable(String ip){
        try{
            InetAddress address = InetAddress.getByName(ip);//ping this IP

            if(address instanceof java.net.Inet4Address){
                System.out.println(ip + " is ipv4 address");
            }else
            if(address instanceof java.net.Inet6Address){
                System.out.println(ip + " is ipv6 address");
            }else{
                System.out.println(ip + " is unrecongized");
            }

            if(address.isReachable(5000)){
                System.out.println("SUCCESS - ping " + address.getHostAddress() + " with no interface specified");
            }else{
                System.out.println("FAILURE - ping " + address.getHostAddress() + " with no interface specified");
            }

            System.out.println("\n-------Trying different interfaces--------\n");

            Enumeration<NetworkInterface> netInterfaces =
                    NetworkInterface.getNetworkInterfaces();
            while(netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                System.out.println(
                        "Checking interface, DisplayName:" + ni.getDisplayName() + ", Name:" + ni.getName());
                if(address.isReachable(ni, 0, 5000)){
                    System.out.println("SUCCESS - ping " + ip);
                }else{
                    System.out.println("FAILURE - ping " + ip);
                }

                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while(ips.hasMoreElements()) {
                    System.out.println("IP: " + ips.nextElement().getHostAddress());
                }
                System.out.println("-------------------------------------------");
            }
        }catch(Exception e){
            System.out.println("error occurs.");
            e.printStackTrace();
        }
    }
}