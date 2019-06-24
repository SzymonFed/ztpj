/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.Controller;

import ewidencja.DAO.DAOWrapper;
import ewidencja.DAO.PracownikDAO;
import java.util.Scanner;
import static ewidencja.Utils.*;
import java.sql.SQLException;
import ewidencja.Model.Pracownik;
import ewidencja.Model.Handlowiec;
import ewidencja.Model.Dyrektor;

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
          //String stanowisko = promptForString("Stanowisko: ");
          double wynagrodzenie = promptForDouble("Wynagrodzenie: ");
          String telefon = promptForString("Telefon: ");
          return new Pracownik (pesel,imie,nazwisko,"",wynagrodzenie,telefon);
    }
    
    public static Dyrektor dodajDyrektora()
    {
        Pracownik pracownik = dodajPracownika();
        String stanowisko = "Dyrektor";
        double dodatekSluzbowy = promptForDouble("Dodatek służbowy: ");
        String kartaSluzbowa = promptForString("Numer karty służbowej: ");
        double limitKosztow = promptForDouble("Limit kosztów: ");
        return new Dyrektor(
                pracownik.getPesel()
                ,pracownik.getImie()
                ,pracownik.getNazwisko()
                ,stanowisko
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
        String stanowisko = "Handlowiec";
        return new Handlowiec(
                pracownik.getPesel()
                ,pracownik.getImie()
                ,pracownik.getNazwisko()
                ,stanowisko
                ,pracownik.getWynagrodzenie()
                ,pracownik.getTelefon()
                ,prowizja
                ,limitProwizji);
    }
   
    
    public static void printDetails() throws SQLException
    {

        System.out.println("---------------------------");
        System.out.print("[D]yrektor/[H]andlowiec:    ");

        String answer = scan.nextLine();
        System.out.println("---------------------------");
        switch(answer)
        {
            case "D":
            case "d":
                Dyrektor dyrektor = ewidencja.Controller.DodajPracownika.dodajDyrektora() ;
                confirmSave(dyrektor);
                break;
            case "H":
            case "h":
                Handlowiec handlowiec = ewidencja.Controller.DodajPracownika.dodajHandlowca() ;
                confirmSave(handlowiec);
                break;
                        
            default: 
                System.out.println("Niepoprawna opcja.");

        }
    }
    public static void confirmSave(Object pracownik) throws SQLException
    {
        if (pracownik!=null)
        {
            System.out.println("[Z] - zapisz");
            System.out.println("[Q] - powrót");
            if (promptForSave())
            {
                if (pracownik instanceof Dyrektor) DAOWrapper.savePracownik((Dyrektor)pracownik);
                else if(pracownik instanceof Handlowiec) DAOWrapper.savePracownik((Handlowiec)pracownik);
                /*if (pracownik instanceof Pracownik) DAOWrapper.savePracownik((Pracownik)pracownik);*/
            }
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
