/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.rmi;
import java.rmi.*;
import java.net.*;
import java.util.Calendar;
/**
 *
 * @author Szymon
 */
public class Client {
    public static boolean runClient(String server, String userName, String password) throws NotBoundException
    {

        try
        {
            Object remote = Naming.lookup(server);
            Validator reply = (Validator)remote;
            String token = reply.getNewToken(userName,password);
            boolean validate = reply.validate(reply.getNewToken(userName,password));
            return validate;
        }
        catch (MalformedURLException me){
            System.out.println(server + " is not a valid url.");
        }
        catch(RemoteException nbe){
            System.out.println("Could not find requested object in the server");
        }
        return false;
    }

}
