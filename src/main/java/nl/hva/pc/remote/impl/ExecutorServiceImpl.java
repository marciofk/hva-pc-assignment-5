package nl.hva.pc.remote.impl;

import nl.hva.pc.client.ServiceCallBack;
import nl.hva.pc.common.task.Task;
import nl.hva.pc.remote.ExecutorService;

import java.rmi.RemoteException;

// TODO 06: Take a look at the implementation of the executor
public class ExecutorServiceImpl implements ExecutorService {
    @Override

    public <P, R> R executeTask(Task<P, R> task, P param) throws RemoteException {

        R result = task.execute(param);

        return result;
    }

    @Override
    public <P, R> void executeTaskAsync(Task<P, R> task, P param, ServiceCallBack<R> callbackObject) throws RemoteException {

        // TODO 10: schedule the task execution
        // Hint 1: Create a thread to execute the task

        new Thread() {
            @Override
            public void run() {
                R result = task.execute(param);
                try {
                    // Hint 2: As soon as the task finishes, you can notify the client using callback
                    callbackObject.callback(result);
                } catch (RemoteException e) {
                    throw new RuntimeException("A remote exception has ocurred",e);
                }
            }
        }.start();


    }

}
