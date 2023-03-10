/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package motovodic;

import java.util.logging.Level;
import java.util.logging.Logger;
import motovodic.controller.ObradaMotoKlub;
import motovodic.model.MotoKlub;
import motovodic.util.HibernateUtil;
import motovodic.util.MotoVodicException;



public class Start {

    public static void main(String[] args) {
        ObradaMotoKlub omk = new ObradaMotoKlub();
        
        MotoKlub motoklub = new MotoKlub();
        motoklub.setNaziv("ab");
        omk.setEntitet(motoklub);
        
        try {
            omk.create();
        } catch (MotoVodicException e) {
            System.out.println(e.getPoruka());
        }
        
        
        for(MotoKlub mk : omk.read()){
            System.out.println(mk.getNaziv());
            
        }
       
       
    }
}
