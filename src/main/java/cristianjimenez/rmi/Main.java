package cristianjimenez.rmi;

import cristianjimenez.rmi.net.RmiServer;

public class Main {

    static void main(String[] args) {
        RmiServer service = new RmiServer();
        try {
            service.start();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
