
package ws;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 3.2.2
 * 2018-04-08T22:51:58.415-03:00
 * Generated source version: 3.2.2
 *
 */

public class ConcesionariaCXFOne_PortTypeServer{

    protected ConcesionariaCXFOne_PortTypeServer() throws Exception {
        System.out.println("Starting Server");
        Object implementor = new ws.ConcesionariaCXFOne();
        String address = "http://localhost:9090/ConcesionariaCXFOnePort";
        Endpoint.publish(address, implementor);
    }

    public static void main(String args[]) throws Exception {
        new ConcesionariaCXFOne_PortTypeServer();
        System.out.println("Server ready...");

        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}

