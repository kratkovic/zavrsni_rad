/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.util;



public class MotoVodicException extends Exception{
    
    private String poruka;
    
    public MotoVodicException(String poruka){
        super();
        this.poruka = poruka;
    }
    public String getPoruka(){
        return poruka;
    }
}
