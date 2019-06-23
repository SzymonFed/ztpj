/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.networking;

import java.io.*;
import java.io.IOException;
import java.net.*;

/**
 *
 * @author Szymon
 */
public class ServerSideSocket{
    public void ServerRun()
    {
        try
        {
            int i = 1;
            ServerSocket ss = new ServerSocket(1111); 
            System.out.println("Server listening at " + InetAddress.getLocalHost() + " on port " + ss.getLocalPort());
            while(true)
            {
                Socket incoming = ss.accept();
                System.out.println("Spawning " + i);
                Runnable r = new ThreadedEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                i++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();/*ZAMIAST TEGO JAKIS FAJNY SPRAWDACZ CZY SERWER O TEJ NAZWIE JUZ STOI*/
        }
        
    }
}
