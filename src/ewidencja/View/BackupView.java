/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.View;

import java.util.Scanner;

/**
 *
 * @author Szymon
 */
public class BackupView {
    public static void View()
    {
        String answer;
        boolean check = true;
        Scanner scan = new Scanner(System.in);
        System.out.println("4. Kopia zapasowa");
        System.out.println("[Z]achowaj/[O]dtwórz: ");
        try
        {
            answer = scan.nextLine();
           
            switch(answer){
                    case "Z":
                    case "z":
                        ewidencja.View.SaveWindow.SaveWindow();
                        break;
                    case "O":
                    case "o":
                        ewidencja.View.LoadWindow.LoadWindow();
                        break;
                    default:
                        System.out.println("Wrong Answer, try again!");
                }
        }
        catch(Exception e)
        {
            System.out.println("Couldn't get right answer!")  ;
        }
    }  
}
