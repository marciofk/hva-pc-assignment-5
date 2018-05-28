package nl.hva.pc.remote.impl;

import nl.hva.pc.remote.HelloWorldService;

import java.rmi.RemoteException;

// TODO 03: Change this class to be a "HelloWorld" remote implementation
public class HelloWorldServiceImpl {
    public void sayHello(String msg) {
        System.out.println("Saying " + msg);
    }
}
