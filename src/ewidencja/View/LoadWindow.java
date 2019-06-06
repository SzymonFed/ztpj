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
public class LoadWindow {
    public static void LoadWindow()
    {
        String answer;
        String end;
        String filename;
        Scanner scan = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------");
        System.out.println("Nazwa pliku : ");
        filename = scan.nextLine();
        try{
            ewidencja.Backup.Open.Open(filename);

        }
        catch (Exception e)
        {
            System.out.println("Cos sie popsulo");

        }
        
    }
}
