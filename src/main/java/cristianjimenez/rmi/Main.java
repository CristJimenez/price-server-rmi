package cristianjimenez.rmi;

import cristianjimenez.rmi.net.RmiServer;

public class Main {

    public static void main(String[] args) {
        RmiServer service = new RmiServer();
        try {
            service.start();
            System.out.println("Server started on port 9007...");
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
