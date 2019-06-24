/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.View;


import ewidencja.DAO.DAOWrapper;
import ewidencja.DAO.SQLPracownikParser;
import ewidencja.Model.DataBase;
import ewidencja.Model.Pracownik;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Szymon
 */
public class ListaPracownikow {
    static Scanner scan = new Scanner(System.in);
    public static void printDetails() throws SQLException
    {
        int workersCount = DAOWrapper.countPracownik();
        int i = 0;
        int j=1;
        if (workersCount<=0){
            System.out.println("---------------------------");
            System.out.println("1. Lista pracowników");
            System.out.println("Brak pracowników. Naciśnij Enter by wyjść.");
            promptEnterKey();
        }
        else
        
        for_loop:
        for(i = 1; i<=workersCount;i++)
        {
            String answer = "";
            System.out.println("---------------------------");
            System.out.println("1. Lista pracowników");
            while(DAOWrapper.loadPracownik(j)==null)j++;
            System.out.println(DAOWrapper.loadPracownik(j));
            System.out.println("---------------------------");
            System.out.println("            Pozycja: "+i+"/"+workersCount);
            j++;
            if(!promptForView())
            {
                break for_loop;
            }
        }
        
        
    }
    static boolean promptForView()
    {
        while(true)
        {
            System.out.println("[N] - następny");
            System.out.println("[Q] - powrót");
            String answer = scan.nextLine();
            switch(answer)
            {
                case "N":
                case "n":
                    return true;
                case "Q":
                case "q":
                    return false;
            }   
        }
    }
    public static void promptEnterKey()
    {
       
       Scanner scanner = new Scanner(System.in);
       scanner.nextLine();
    }
}
