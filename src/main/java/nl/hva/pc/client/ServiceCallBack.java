package nl.hva.pc.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceCallBack<R> extends Remote {

    void callback(R result) throws RemoteException;

}
