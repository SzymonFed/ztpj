/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ou.xjc;


import java.util.List;
import javax.xml.bind.annotation.*;


/**
 *
 * @author Szymon
 */
@XmlRootElement(name = "Pracownicy")
@XmlAccessorType (XmlAccessType.FIELD)
public class ListaPracowników {
    @XmlElement(name = "Pracownik")
    private List<ou.xjc.Pracownik> pracownicy = null;
    
    public List<ou.xjc.Pracownik> getPracownicy() {
        return pracownicy;
    }
 
    public void setPracownicy(List<ou.xjc.Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }
}
