/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.networking;
import ewidencja.Model.Dyrektor;
import ewidencja.Model.Handlowiec;
import ewidencja.Model.Pracownik;
import java.io.*;
import java.net.*;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Console.*;

/**
 *
 * @author Szymon
 */
public class Client {
    
    public static List<Pracownik> runClient(String name,int port) throws IOException, ClassNotFoundException, NotBoundException
    {
        List<Pracownik> listaPracownikow = new ArrayList<Pracownik>();
        String serverName = name;
        Scanner scan = new Scanner(System.in);
        int serverPort = port;
        System.out.println("------------------------------------------------------------------");
        System.out.println("Login : ");
        String login = scan.nextLine();//"Simon";
        System.out.println("Hasło : ");
        String password = scan.nextLine();//"Fajnehaslo";
        try{
            boolean authenticate = ewidencja.rmi.Client.runClient("rmi://localhost:1234/validator",login,password);
        if (authenticate){
            Socket s = new Socket(serverName, serverPort);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            dos.writeUTF("say hi");

            String response = dis.readUTF();

            if (response.contains("OK"))
            {
                System.out.println("Nawiazano polaczenie.");

                JAXBContext jaxbContext = JAXBContext.newInstance(ou.xjc.ListaPracowników.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                javax.xml.stream.XMLStreamReader xmlStreamReader = javax.xml.stream.XMLInputFactory.newInstance().createXMLStreamReader( dis );
                ou.xjc.ListaPracowników lista = (ou.xjc.ListaPracowników) jaxbUnmarshaller.unmarshal(xmlStreamReader);
   
                
                List<ou.xjc.Pracownik> pracownicy = lista.getPracownicy();
                
                for(ou.xjc.Pracownik pracownik : pracownicy){
                    if (pracownik.getStanowisko().equals("Dyrektor"))
                    {
                        ou.xjc.Dyrektor temp =(ou.xjc.Dyrektor) pracownik;
                        Dyrektor newPracownik = new Dyrektor(
                            temp.getPesel(),
                            temp.getImie(),
                            temp.getNazwisko(),
                            temp.getStanowisko(),
                            temp.getWynagrodzenie(),
                            temp.getTelefon(),
                            temp.getDodatekSluzbowy(),
                            temp.getKartaSluzbowa(),
                            temp.getLimitKosztow());
                        listaPracownikow.add(newPracownik);
                    }
                    if (pracownik.getStanowisko().equals("Handlowiec"))
                    {
                        ou.xjc.Handlowiec temp =(ou.xjc.Handlowiec) pracownik;
                        Handlowiec newPracownik = new Handlowiec(
                            temp.getPesel(),
                            temp.getImie(),
                            temp.getNazwisko(),
                            temp.getStanowisko(),
                            temp.getWynagrodzenie(),
                            temp.getTelefon(),
                            temp.getProwizja(),
                            temp.getLimitProwizji()
                            );
                        listaPracownikow.add(newPracownik);
                    }
                    
                }
                xmlStreamReader.close();
            }
            else System.out.println("Jakis problem sie stal");
            System.out.println("Pobrano dane");
            dis.close();
            dos.close();
            s.close();
            return listaPracownikow;
        }
        else{
            System.out.println("Nieprawidłowe dane uwierzytelniania");
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
}
