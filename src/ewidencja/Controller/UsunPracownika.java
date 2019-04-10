/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.Controller;

import ewidencja.Model.DataBase;
import ewidencja.Model.Pracownik;

import static ewidencja.Utils.promptForPesel;
import java.util.Scanner;

/**
 *
 * @author Szymon
 */
public class UsunPracownika {
    static Scanner scan = new Scanner(System.in);
    public static void deleteWorker()
    {
        
        System.out.print("----------------------------");
        
        String answer = promptForPesel("Podaj identyfikator PESEL:  ");
        if(DataBase.pracownicy.containsKey(answer))
        {
           Pracownik pracownik = DataBase.pracownicy.get(answer);
           System.out.println(pracownik.toString2());
           System.out.println("[Enter] - potwierdź");
           System.out.println("[Q] - porzuć");
            if (promptForDelete())
            {
                DataBase.pracownicy.remove(pracownik.getPesel());
                System.out.println("Pomyślnie sunięto pracownika.");
            }

        }
        else {
            System.out.println("Pracownik nie istnieje");
            ewidencja.View.MainMenu.chooseOperation();
        }
        

    }
    static boolean promptForDelete()
    {
        while(true)
        {
            String answer = scan.nextLine();
            if (answer.length()>0)
                {
                    switch(answer.charAt(0)){
                        case 'Z':
                        case 'z':
                            return true;
                        case 'Q':
                        case 'q':
                            return false;
                    }
                }
        System.out.println("Niepoprawna opcja."); 
        }
    }
    
}
