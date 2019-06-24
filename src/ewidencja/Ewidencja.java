/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import static ewidencja.View.MainMenu.chooseOperation;
import java.sql.SQLException;
import ewidencja.networking.*;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Ewidencja  {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException, NotBoundException 
    {   
        Thread rmiThread = new Thread(() -> {
            try{
                ewidencja.rmi.Server.serverRun(1234);
            }
            catch(Exception e)
            {}
        });
        rmiThread.start();
        Thread serverThread = new Thread(() -> {
            try{
            ewidencja.networking.ServerSideSocket server = new ewidencja.networking.ServerSideSocket();
            server.ServerRun();
            }
            catch(Exception e)
            {
                /* tymczasowe rozwiazanie*/
            }

        });
        serverThread.start();        
        
        chooseOperation();

    }
}
