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
        System.out.println("MENU");
        System.out.println("    1. Lista pracowników");
        System.out.println("    2. Dodaj pracownika");
        System.out.println("    3. Usuń pracownika");
        System.out.println("    4. Kopia zapasowa");
        System.out.print("Wybór: ");
    }
    
    public static void chooseOperation()
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
                DodajPracownikaView.printDetails();
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                chooseOperation();
                break;
        }
    }
}
