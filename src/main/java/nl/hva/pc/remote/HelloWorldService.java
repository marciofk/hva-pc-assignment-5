package nl.hva.pc.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

// TODO 01: Make this interface remote
public interface HelloWorldService {

    // TODO 02: Change the signature of this method, allowing it throw a RemoteException
    // TODO 14: Change the parameter string to nl.hva.pc.common.Message. You will also need to adapt the implementation
    void sayHello(String msg);
}
