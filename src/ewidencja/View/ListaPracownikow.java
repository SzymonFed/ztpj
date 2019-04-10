/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.View;


import ewidencja.Model.DataBase;
import ewidencja.Model.Pracownik;
import java.util.Scanner;

/**
 *
 * @author Szymon
 */
public class ListaPracownikow {
    static Scanner scan = new Scanner(System.in);
    public static void printDetails()
    {
        
        int i = 0;
        if (DataBase.pracownicy.isEmpty()){
            System.out.println("---------------------------");
            System.out.println("1. Lista pracowników");
            System.out.println("Brak pracowników. Naciśnij Enter by wyjść.");
            promptEnterKey();
        }
        else
        for_loop:
        for(Pracownik value : DataBase.pracownicy.values())
        {
            String answer = "";
            System.out.println("---------------------------");
            System.out.println("1. Lista pracowników");
            i++;
            System.out.println(value.toString());
            System.out.println("---------------------------");
            System.out.println("            Pozycja: "+i+"/"+DataBase.pracownicy.size());
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
