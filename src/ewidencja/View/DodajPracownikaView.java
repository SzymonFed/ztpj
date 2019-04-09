/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.View;

import ewidencja.Model.Dyrektor;
import ewidencja.Model.Handlowiec;
import java.util.Scanner;
import ewidencja.View.MainMenu;
import java.util.Map;

/**
 *
 * @author Szymon
 */
public class DodajPracownikaView {
    
    static void printDetails()
    {
            System.out.println("[D]yrektor/[H]andlowiec");
            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();
            switch(answer){
                case "D":
                    Dyrektor dyrektor;
                    dyrektor = ewidencja.Controller.DodajPracownika.dodajDyrektora();
                    answer = scan.nextLine();
                    if (answer.isEmpty())
                    {
                        ewidencja.Controller.DodajPracownika.addToMap(db, dyrektor);
                        System.out.println("Dodano pracownika");
                    }
                    break;
                case "H":
                    Handlowiec handlowiec;
                    handlowiec = ewidencja.Controller.DodajPracownika.dodajHandlowca();
                    answer = scan.nextLine();
                    if (answer.isEmpty()) 
                    {   ewidencja.Controller.DodajPracownika.addToMap(db, handlowiec);
                        System.out.println("Dodano pracownika");
                    }
                    
                    break;
            }
            if (answer.equals("q")) ewidencja.View.MainMenu.chooseOperation();
    }
    
    
}
