package cristianjimenez.rmi.net;

import cristianjimenez.rmi.lib.IRemoteCalculatePrice;
import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Server;

import java.io.IOException;

public class RmiServer {

    private int port = 9007;
    private CallHandler invoker;
    private Server server;
    private CalculatePriceImpl calculatePrice;
    private IRemoteCalculatePrice remoteCalculatePrice;

    public RmiServer() {
        invoker = new CallHandler();
        server = new Server();
        calculatePrice = new CalculatePriceImpl();
    }

    public void start() throws Exception {
        try {
            invoker.registerGlobal(IRemoteCalculatePrice.class, calculatePrice);
            server.bind(port, invoker);
        } catch (LipeRMIException ex) {
            throw new Exception("Error: unable to invoke remote methods");
        } catch (IOException ex) {
            throw new Exception("Error: I/O");
        }
    }

    public void stop() {
        server.close();
    }
}
