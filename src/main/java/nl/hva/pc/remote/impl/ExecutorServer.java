package nl.hva.pc.remote.impl;

import nl.hva.pc.remote.ExecutorService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// TODO 05: Take a look at the executor server
public class ExecutorServer {

    public static void main(String[] args) {

        try {
            // Create the service object
            ExecutorService svc = new ExecutorServiceImpl();

            // Generating a stub for the service
            ExecutorService stub = (ExecutorService) UnicastRemoteObject.exportObject(svc,0);

            // Creating the registry server
            Registry registry = LocateRegistry.createRegistry(1099);

            // Registering the stub
            registry.bind("executor",stub);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
