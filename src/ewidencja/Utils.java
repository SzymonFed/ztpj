/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja;

/**
 *
 * @author Szymon
 */
import java.util.Scanner;

public class Utils
{
    static Scanner scanner = new Scanner(System.in);

    static int prompForInteger(String message)
    {
        while(true)
        {
            try
            {
                System.out.print(message);
                String response = scanner.nextLine();
                return Integer.parseInt(response);
            }
            catch(NumberFormatException ex)
            {
                // do nothing
            }
        }
    }
    public static double promptForDouble(String message)
    {
        while(true)
        {
            try
            {
                System.out.print(message);
                String response = scanner.nextLine();
                return Double.parseDouble(response);
            }
            catch(NumberFormatException ex)
            {
                // do nothing
            }
        }
    }

    public static String promptForString(String message)
    {
        while(true)
        {
            System.out.print(message);
            String response = scanner.nextLine();
            if(response.trim().length() > 0)
                return response;
            System.out.println("Wartosc nie moze byc pusta");
        }
    }

    static String promptForNullableString()
    {
        String response = scanner.nextLine();
        if (response.trim().length() == 0)
            return null;

        return response;
    }
    

    public static String promptForPesel(String message)
    {
        while(true)
        {
            System.out.print(message);
            String response = scanner.nextLine();
            if(response.trim().length() ==11)
                return response;
            System.out.println("Pesel musi mieć określoną długość");
        }
    }
}