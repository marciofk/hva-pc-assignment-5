package nl.hva.pc.client;

import nl.hva.pc.remote.HelloWorldService;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// TODO 13: Run the client. Is it possible run it many times?
// TODO 15: Run the client. Please explain the error and try to solve it, based on the error on the Stack Trace
public class HelloClientRun {

    public static void main(String[] args) {

        try {
            // TODO 10: Get the running registry
            // you can use the method getRegistry of the class LocateRegistry

            // TODO 11: Get the remote object's stub
            // You can use the method lookup of the registry

            // TODO 12: Run the hello method

        } catch(Exception e) {
            throw new RuntimeException(e);
        }

    }

}
