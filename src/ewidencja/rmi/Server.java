/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.rmi;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;

/**
 *
 * @author Szymon
 */
public class Server {

    public static void serverRun(int port)
    {
        try{
        try
        {
            ValidatorImpl validator = new ValidatorImpl();
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind("validator", validator);
            System.out.println("Serwer RMI jest gotów do działania :)");
        }
        catch (RemoteException e){
            
        }
        }catch(Exception e)
        {
        }
    }
}
