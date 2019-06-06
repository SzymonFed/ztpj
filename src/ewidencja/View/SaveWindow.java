/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.View;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Szymon
 */
public class SaveWindow {
    public static void SaveWindow()
    {
        String answer;
        String end = ".bin";
        String filename;
        boolean check=true;
        Scanner scan = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------");
        System.out.println("Kompresja [G]zip/[Z]ip : ");
        answer = scan.nextLine();
        /*while(check){
            switch(answer){
                case "G":
                case "g":
                    end = ".bin";
                    check=false;
                    break;
                case "Z":
                case "z":
                    end = ".bin";
                    check=false;
                    break;
                default:
                    System.out.println("Wrong answer!");
                    check=true;
            }
        }*/
        System.out.println("Nazwa pliku : ");
        filename = scan.nextLine();
        try{
            ewidencja.Backup.Save.Save(filename+end);
        }
        catch (Exception e)
        {
            System.out.println("Cos sie popsulo");
        }
        
    }
    
}
