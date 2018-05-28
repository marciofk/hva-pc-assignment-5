package nl.hva.pc.client;

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
            Registry registry = LocateRegistry.getRegistry(1099);

            // Getting the stub of the executor
            ExecutorService service = (ExecutorService) registry.lookup("executor");

            // TODO 08: Calculate 30 degrees celsius to farenheit using the remote service
            // Test the application to see if it works fine

            // TODO 09: Calculate the PI using 70000000 series using the remote service
            // Test the application to see if it works fine

            // TODO 11: Calculate the PI using 90000000 series (asynchronous)
            // Hint 1: You need to create a class that implements ServiceCallBack
            // Hint 2: You can use UnicastRemoteObject.exportObject to create a stub of your callback remote object
            // Hint 3: You can simply print the result in the callback method

            // TODO 12: You will see a side-effect: The callback object will still run and your client will never finish
            // Hint: Study UnicastRemoteObject.unexportObject

            System.out.println("Main method finished");

        } catch(Exception e) {
            throw new RuntimeException(e);
        }

    }
}
