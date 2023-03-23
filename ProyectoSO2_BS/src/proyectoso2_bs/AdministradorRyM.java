/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso2_bs;

import java.util.Random;

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
    
    public int minutosRM(){
        int introRM = 0; 
        int inicioRM1 = 0;
        int inicioRM2 = 0;
        int cierreRM = 0;
        int creditosRM = 0;
        int prob_calidadRM = 0;
        int minutos =0;
        
        // RM tiene 1 intro, dos inicios, 1 cierre, 1 credito 
        introRM = new Random().nextInt(100)+1; //1 Intro = 0-100        
        inicioRM1 = new Random().nextInt(100)+1; //2 Inicios = 0-200
        inicioRM2 = new Random().nextInt(100)+1;
        cierreRM = new Random().nextInt(100)+1; //2 Cierres = 0-200       
        creditosRM = new Random().nextInt(100)+1; //1 Credito = 0-100      
        prob_calidadRM = (introRM+inicioRM1+inicioRM2+cierreRM+creditosRM)/6;        
        minutos = 10+prob_calidadRM;       
        return minutos;   
    }
        
  public int PrioridadRM(){
        int minutos = minutosRM();
        int prioridad =0;     
        if (minutos <60){
             //Prioridad mas baja
             prioridad = 3;
         }       
        else if (minutos <90 ){
            //Prioridad media
            prioridad = 2;
        }  
        else if (minutos >= 90 ){
            //Prioridad alta
            prioridad = 1;
        }
        return prioridad; 
    }
    
}
    

