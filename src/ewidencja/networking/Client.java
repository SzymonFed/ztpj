/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.networking;
import ewidencja.Model.Pracownik;
import static ewidencja.WorkersList.workersGlobalList;
import java.io.*;
import java.net.*;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Szymon
 */
public class Client {
    
    public static List<Pracownik> runClient(String name,int port) throws IOException, ClassNotFoundException, NotBoundException
    {
        List<Pracownik> listaPracownikow = new ArrayList<Pracownik>();
        String serverName = name;
        Scanner scan = new Scanner(System.in);
        int serverPort = port;
        System.out.println("------------------------------------------------------------------");
        System.out.println("Login : ");
        String login = scan.nextLine();//"Simon";
        System.out.println("Hasło : ");
        String password = scan.nextLine();//"Fajnehaslo";
        try{
            boolean authenticate = ewidencja.rmi.Client.runClient("rmi://localhost:1234/validator",login,password);
        if (authenticate){
            Socket s = new Socket(serverName, serverPort);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            dos.writeUTF("say hi");

            String response = dis.readUTF();

            if (response.contains("OK"))
            {
                System.out.println("Nawiazano polaczenie.");

                ObjectInputStream ois = new ObjectInputStream(dis);
                listaPracownikow = ((List<Pracownik>) ois.readObject());
                ois.close();
            }
            else System.out.println("Jakis problem sie stal");
            System.out.println("Pobrano dane");


            dis.close();
            dos.close();
            s.close();
            return listaPracownikow;
        }
        else{
            System.out.println("Nieprawidłowe danue uwierzytelniania");
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
}
