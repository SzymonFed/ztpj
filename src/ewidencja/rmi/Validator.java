/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.rmi;
import java.rmi.*;
/**
 *
 * @author Szymon
 */
public interface Validator extends Remote {
    String getNewToken(String userName, String password) throws RemoteException;
    public boolean validate(String token) throws RemoteException;
}
