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
import motovodic.util.PocetniInsert;
import motovodic.view.SplashScreen;



public class Start {

    public static void main(String[] args) {
     //new SplashScreen().setVisible(true);
        new PocetniInsert();
        }
       
       
    }

