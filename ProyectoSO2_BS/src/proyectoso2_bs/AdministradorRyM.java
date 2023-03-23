/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso2_bs;

/**
 *
 * @author Gab
 */
public class AdministradorRyM {
     int idRM;
    
    
    //Ignora esto es pa mezclarlo con el otro
    ColaRyM nivel1RM;
    ColaRyM nivel2RM;
    ColaRyM nivel3RM; 
    
    
    public AdministradorRyM(){
       nivel1RM = new ColaRyM(); 
       nivel2RM = new ColaRyM();
       nivel3RM = new ColaRyM();
    }
    
    public ColaRyM getNivel1RM() {
        return nivel1RM;
    }

    public ColaRyM getNivel2RM() {
        return nivel2RM;
    }

    public ColaRyM getNivel3RM() {
        return nivel3RM;
    }

    public int getIdRM() {
        return idRM;
    }
}
