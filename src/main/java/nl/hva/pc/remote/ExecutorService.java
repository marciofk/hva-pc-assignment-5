package nl.hva.pc.remote;

import nl.hva.pc.client.ServiceCallBack;
import nl.hva.pc.common.task.Task;

import java.rmi.Remote;
import java.rmi.RemoteException;

// TODO 04: Take a look at the "ExecutorService" interface
// Objects of this type allows clients to send tasks to be remotely executed in the server side
// Note that the executor has two methods:
// - executeTask allows the synchronous execution of a task
// - executeTaskAsync is the asynchronous version, allowing to send and forget.
//   the service execute a callback function on the client-side when the taks finishes

public interface ExecutorService extends Remote {

    <P,R> R executeTask(Task<P,R> t, P param) throws RemoteException;

    <P,R> void executeTaskAsync(Task<P,R> t, P param, ServiceCallBack<R> callbackObject) throws RemoteException;

}
