/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.networking;

import ewidencja.Model.Pracownik;
import java.net.Socket;
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Szymon
 */
public class ThreadedEchoHandler implements Runnable {
    
    private Socket incoming;
    public ThreadedEchoHandler(Socket i) {
        incoming = i;
    }
    public void run()
    {
        try
        {
            try
            {
                
                DataOutputStream dos = new DataOutputStream(incoming.getOutputStream());
                DataInputStream dis = new DataInputStream(incoming.getInputStream());
                
                String check = dis.readUTF();
                System.out.println("Ok, odebralem " + check);
                if(check.contentEquals("say hi"))
                {
                    dos.writeUTF("OK");
                    ObjectOutputStream oos = new ObjectOutputStream(dos);
                    List <Pracownik> temp = ewidencja.DAO.DAOWrapper.loadAllPracownik();
                    oos.writeObject(temp);
                    dis.close();
                    dos.close();
                }
            }
            catch (SQLException ex) {            
                Logger.getLogger(ThreadedEchoHandler.class.getName()).log(Level.SEVERE, null, ex);
            }            
             finally
            {
                incoming.close();
            }
        }
       
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
