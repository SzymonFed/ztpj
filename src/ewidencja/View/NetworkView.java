/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.View;

import ewidencja.DAO.DAOWrapper;
import ewidencja.Model.*;
import ewidencja.Model.Pracownik;
import static ewidencja.View.ListaPracownikow.scan;
import static ewidencja.WorkersList.workersGlobalList;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.InetAddress;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Szymon
 */
public class NetworkView {
    
    public static void View() throws IOException, ClassNotFoundException, NotBoundException, SQLException
    {
        List<Pracownik> listaPracownikow = new ArrayList<Pracownik>();
        String adress = "localhost";
        String rmiAdress = "rmi://localhost/validator";
        int port = 1111;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("5.1 Pobierz dane z sieci");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Adres : "+ adress);
        //String adress = scan.nextLine();
        System.out.println("Port : "+ port);
        //int port = Integer.parseInt(scan.nextLine());
        
  
        ewidencja.networking.Client client = new ewidencja.networking.Client();
        
        listaPracownikow = client.runClient(adress,port);
                
        trySave(listaPracownikow);
        //System.out.println("ENTER - powrót do ekranu głównego");

    }
    static void trySave(List<Pracownik> lista) throws SQLException
    {
        if (lista == null) return;
        System.out.print("Czy zapisać pobrane dane?[T]/[N] ");
        String answer = scan.nextLine();
        while_loop:
        while(true)
        switch(answer)
        {
            case "T":
            case "t":
                System.out.println("Zapisywanie...");
                for (int i = 0; i<lista.size();i++)
                {
                    if (lista.get(i) instanceof Dyrektor) DAOWrapper.savePracownik((Dyrektor)lista.get(i)); 
                    else if(lista.get(i) instanceof Handlowiec) DAOWrapper.savePracownik((Handlowiec)lista.get(i));
                }
                break while_loop;
            case "N":
            case "n":
                break while_loop;
            default:
                
                
        }   
    }
}
