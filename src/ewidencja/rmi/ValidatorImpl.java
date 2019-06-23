/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewidencja.rmi;
import java.rmi.*;
import java.util.*;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Szymon
 */
public class ValidatorImpl extends UnicastRemoteObject implements Validator
{
    
    Map memberMap;
    static private Map<String,Date> tokenMap =new HashMap<>();
    public ValidatorImpl() throws RemoteException
    {
        memberMap = new HashMap();
        memberMap.put("Simon", "Fajnehaslo");
    }
    public Map getMemberMap(){
        return memberMap;
    }
    
    public String getNewToken(String userName,String password) 
    {
        if (getMemberMap().containsKey(userName)
                && getMemberMap().get(userName).equals(password))
        {
            String token = Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes());
            tokenMap.put(token,new Date());
            return token;
        }
        return null;
    }
    public boolean validate(String token) throws RemoteException
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -2);
        if (tokenMap.containsKey(token))
        {
            boolean check = tokenMap.get(token).after(calendar.getTime());
            tokenMap.remove(token);
            return check;
        }
        return false;
    }
    
}
