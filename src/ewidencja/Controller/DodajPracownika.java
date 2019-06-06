/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.Controller;

import ewidencja.Model.*;
import java.util.Scanner;
import static ewidencja.Utils.*;
import java.util.Map;

/**
 *
 * @author Szymon
 */
public class DodajPracownika 
{
    static Scanner scan = new Scanner(System.in);
    
    public static Pracownik dodajPracownika()
    {
          String pesel = promptForPesel("PESEL: ");
          String imie = promptForString("Imię: ");
          String nazwisko = promptForString("Nazwisko: ");
          String stanowisko = promptForString("Stanowisko: ");
          double wynagrodzenie = promptForDouble("Wynagrodzenie: ");
          String telefon = promptForString("Telefon: ");
          return new Pracownik (pesel,imie,nazwisko,stanowisko,wynagrodzenie,telefon);
    }
    
    public static Dyrektor dodajDyrektora()
    {
        Pracownik pracownik = dodajPracownika();
        double dodatekSluzbowy = promptForDouble("Dodatek służbowy: ");
        String kartaSluzbowa = promptForString("Numer karty służbowej: ");
        double limitKosztow = promptForDouble("Limit kosztów: ");
        return new Dyrektor(
                pracownik.getPesel()
                ,pracownik.getImie()
                ,pracownik.getNazwisko()
                ,pracownik.getStanowisko()
                ,pracownik.getWynagrodzenie()
                ,pracownik.getTelefon()
                ,dodatekSluzbowy
                ,kartaSluzbowa
                ,limitKosztow);
    }
    public static Handlowiec dodajHandlowca()
    {
        Pracownik pracownik = dodajPracownika();
        double prowizja = promptForDouble("Prowizja: ");
        double limitProwizji = promptForDouble("limitProwizji: ");
        
        return new Handlowiec(
                pracownik.getPesel()
                ,pracownik.getImie()
                ,pracownik.getNazwisko()
                ,pracownik.getStanowisko()
                ,pracownik.getWynagrodzenie()
                ,pracownik.getTelefon()
                ,prowizja
                ,limitProwizji);
    }
    public static void addToMap(Map<String,Pracownik> pracownicy,Pracownik pracownik)
    {
         pracownicy.put(pracownik.getPesel(),pracownik);
    }
    public static void printDetails()
    {

        System.out.println("---------------------------");
        System.out.print("[D]yrektor/[H]andlowiec:    ");

        String answer = scan.nextLine();
        System.out.println("---------------------------");
        Pracownik pracownik = null;
        switch(answer)
        {
            case "D":
            case "d":
                pracownik = ewidencja.Controller.DodajPracownika.dodajDyrektora();
                break;
            case "H":
            case "h":
                pracownik = ewidencja.Controller.DodajPracownika.dodajHandlowca();
                break;
            default: 
                System.out.println("Niepoprawna opcja.");
                break;
        }
        if (pracownik!=null){
            if (!DataBase.pracownicy.containsKey(pracownik.getPesel())){
                System.out.println("[Z] - zapisz");
                System.out.println("[Q] - powrót");
                if (promptForSave())
                {

                    DodajPracownika.addToMap(DataBase.pracownicy,pracownik);
                }
            }
            else System.out.println("Pracownik z tym PESELem już istnieje.");
        }
        
           
    }
    static boolean promptForSave()
    {
        while(true)
        {
            String answer = scan.nextLine();
            if (answer.length()>0)
                {
                    switch(answer.charAt(0)){
                        case 'Z':
                        case'z':
                            return true;
                        case 'Q':
                        case 'q':
                            return false;
                    }
                }
        System.out.println("Niepoprawna opcja.");
        System.out.println("[Z] - zapisz");
        System.out.println("[Q] - powrót");
        }
    }
     
}
