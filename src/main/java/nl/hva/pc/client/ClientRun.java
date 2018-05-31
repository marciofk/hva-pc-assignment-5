package nl.hva.pc.client;

import nl.hva.pc.common.task.CelsiusToFahrenheitTask;
import nl.hva.pc.common.task.GregorySeriesTask;
import nl.hva.pc.remote.ExecutorService;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// TODO 07: Take a look at an application that uses the task executor
public class ClientRun {

    public static void main(String[] args) {

        try {
            // Getting the registry reference
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);

            // Getting the stub of the executor
            ExecutorService service = (ExecutorService) registry.lookup("executor");

            // TODO 08: Calculate 30 degrees celsius to farenheit using the remote service
            // Test the application to see if it works fine
            CelsiusToFahrenheitTask cfTask = new CelsiusToFahrenheitTask();
            double celsiusTemp = 30;
            double fahTemp = service.executeTask(cfTask,celsiusTemp);
            System.out.println(celsiusTemp + " celsius is " + fahTemp + " Fahrenheit");

            // TODO 09: Calculate the PI using 70000000 series using the remote service
            // Test the application to see if it works fine
            GregorySeriesTask gsTask = new GregorySeriesTask();
            double pi = service.executeTask(gsTask,70000000);
            System.out.println("sync: PI is " + pi);

            // TODO 11: Calculate the PI using 90000000 series (asynchronous)
            // Hint 1: You need to create a class that implements ServiceCallBack
            ServiceCallBack callback = getGregorySeriesCallBack();
            service.executeTaskAsync(gsTask,90000000,callback);


            System.out.println("Main method finished");

        } catch(Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static ServiceCallBack getGregorySeriesCallBack() {

        try {
            // Hint 2: You can use UnicastRemoteObject.exportObject to create a stub of your callback remote object
            GregorySeriesCallback callBack = new GregorySeriesCallback();

            return (ServiceCallBack) UnicastRemoteObject.exportObject(callBack, 0);
        } catch(RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}

class GregorySeriesCallback implements ServiceCallBack<Double> {

    @Override
    public void callback(Double result) throws RemoteException {
        // Hint 3: You can simply print the result in the callback method
        System.out.println("async pi: " + result);

        // TODO 12: You will see a side-effect: The callback object will still run and your client will never finish
        // Hint: Study UnicastRemoteObject.unexportObject

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000); // waiting a bit, giving time to the caller to leave
                    UnicastRemoteObject.unexportObject(GregorySeriesCallback.this,true);
                } catch (InterruptedException e) {
                    return;
                } catch (NoSuchObjectException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();
    }
}
