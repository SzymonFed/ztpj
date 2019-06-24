/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.networking;

import ewidencja.Model.Pracownik;
import ewidencja.Model.Dyrektor;
import ewidencja.Model.Handlowiec;
import java.net.Socket;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.dom.DOMResult;
import ou.xjc.*;
/**
 *
 * @author Szymon
 */
public class ThreadedEchoHandler implements Runnable {
    
    private Socket incoming;
    public ThreadedEchoHandler(Socket i) {
        incoming = i;
    }
    public void run()
    {
        try
        {
            try
            {
                
                DataOutputStream dos = new DataOutputStream(incoming.getOutputStream());
                DataInputStream dis = new DataInputStream(incoming.getInputStream());
                
                String check = dis.readUTF();
                System.out.println("Ok, odebralem " + check);
                if(check.contentEquals("say hi"))
                {
                    dos.writeUTF("OK");
                    
                    
                    List <Pracownik> temp = ewidencja.DAO.DAOWrapper.loadAllPracownik();
                    List <ou.xjc.Pracownik> temp2 = new ArrayList<>();
                    ListaPracowników temp3 = new ListaPracowników();
                    temp3.setPracownicy(new ArrayList<>());
                    for (Pracownik pracownik : temp)
                    {
                        if (pracownik instanceof Dyrektor && pracownik.getStanowisko().equals("Dyrektor"))
                        {
                            Dyrektor dyrektor = (Dyrektor)pracownik;
                            ou.xjc.Dyrektor dyr= new ou.xjc.Dyrektor();
                            dyr.setPesel(dyrektor.getPesel());
                            dyr.setImie(dyrektor.getImie());
                            dyr.setNazwisko(dyrektor.getNazwisko());
                            dyr.setStanowisko(dyrektor.getStanowisko());
                            dyr.setWynagrodzenie(dyrektor.getWynagrodzenie());
                            dyr.setTelefon(dyrektor.getTelefon());
                            dyr.setDodatekSluzbowy(dyrektor.getDodatekSluzbowy());
                            dyr.setKartaSluzbowa(dyrektor.getKartaSluzbowa());
                            dyr.setLimitKosztow(dyrektor.getLimitKosztow());
                            temp3.getPracownicy().add(dyr);
                            
                        }
                        else if (pracownik instanceof Handlowiec && pracownik.getStanowisko().equals("Handlowiec"))
                        {                        
                            Handlowiec handlowiec = (Handlowiec)pracownik;
                            ou.xjc.Handlowiec han= new ou.xjc.Handlowiec();
                            han.setPesel(handlowiec.getPesel());
                            han.setImie(handlowiec.getImie());
                            han.setNazwisko(handlowiec.getNazwisko());
                            han.setStanowisko(handlowiec.getStanowisko());
                            han.setWynagrodzenie(handlowiec.getWynagrodzenie());
                            han.setTelefon(handlowiec.getTelefon());
                            han.setProwizja(handlowiec.getProwizja());
                            han.setLimitProwizji(handlowiec.getLimitProwizji());
                            temp3.getPracownicy().add(han);
                            
                        }
                    }

                    JAXBContext jaxbContext = JAXBContext.newInstance(ou.xjc.ListaPracowników.class);
                    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    jaxbMarshaller.marshal(temp3,new File("D:/pracownicy.xml"));
                    XMLStreamWriter xsw =  XMLOutputFactory.newInstance().createXMLStreamWriter(dos);
                    jaxbMarshaller.marshal(temp3, xsw);
                    dis.close();
                    dos.close();
                }
            }
            catch (SQLException ex) {            
                Logger.getLogger(ThreadedEchoHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JAXBException ex) {
                Logger.getLogger(ThreadedEchoHandler.class.getName()).log(Level.SEVERE, null, ex);

            } catch (XMLStreamException ex) {
                Logger.getLogger(ThreadedEchoHandler.class.getName()).log(Level.SEVERE, null, ex);
            }            
             finally
            {
                incoming.close();
            }
        }
       
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
