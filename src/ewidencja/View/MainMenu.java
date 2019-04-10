/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.View;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
/**
 *
 * @author Szymon
 */
public class MainMenu {
    private static void showOptions()
    {
        System.out.println("---------------------------");
        System.out.println("MENU");
        System.out.println("    1. Lista pracowników");
        System.out.println("    2. Dodaj pracownika");
        System.out.println("    3. Usuń pracownika");
        System.out.println("    4. Kopia zapasowa");
        System.out.println("    0. Wyjdź");
        System.out.print("Wybór: ");
    }
    
    public static void chooseOperation()
    {
        while_loop:
        while(true)
        {
            int answer;
            showOptions();
        
            Scanner scan = new Scanner(System.in);
            try
            {
                answer = parseInt(scan.nextLine());
            }
            catch(NumberFormatException e)
            {
                System.err.println("Wproadzono nieprawidłową opcję!");
                answer = 0;
            }
            switch (answer)
            {
                case 1:
                    ListaPracownikow.printDetails();
                    break;
                case 2:
                    ewidencja.Controller.DodajPracownika.printDetails();
                    break;
                case 3:
                    ewidencja.Controller.UsunPracownika.deleteWorker();
                    break;
                case 4:
                    System.out.println("Not yet implemented!");
                    break;
                case 0:
                    break while_loop;
                default: System.err.println("Wproadzono nieprawidłową opcję!");
            }
        }
    }
}
