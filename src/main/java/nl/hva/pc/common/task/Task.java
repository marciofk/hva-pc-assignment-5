package nl.hva.pc.common.task;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

// TODO 01: Take a look at the Task interface
// A generic task interface has two types Parameter (P), and Result (R)
// The method "execute" passes P as a parameter and returns R as a result
public interface Task<P,R> extends Serializable {

    R execute(P param);
}