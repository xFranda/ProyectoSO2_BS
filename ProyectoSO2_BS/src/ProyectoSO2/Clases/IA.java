/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSO2.Clases;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author frand
 */
public class IA {
    
    int TLOUlistos;
    int RMlistos;
    
    
    public IA () {
    
    this.TLOUlistos =0;
    this.RMlistos=0;
    
    }
    
    public int getListosTLOU(){
        return TLOUlistos;
    }
    
    public int getListosRM(){
        return RMlistos;
    }
    
    public void recibirSeries(TLOU serie, Cola A, Cola B, Cola C, Cola D) {
        
        try {
            
            int prob = new Random().nextInt(100);
            Thread.sleep(1000);  
            
            
            //probabilidad de encolarse de nuevo
            if (prob <= 27){
                
                serie.contador = 0;
                
                switch (serie.prioridad) {

                    case 1:

                        A.insertarCola(serie);       

                        System.out.println("cola 1");

                        break;

                    case 2:

                        B.insertarCola(serie);          

                        System.out.println("cola 2");

                        break;

                    case 3:

                        C.insertarCola(serie);           

                        System.out.println("cola 3");

                        break;

                    default:
                        System.out.println("error");
                        break;
                
                
                
                
                }
            
            
                //Probabilidad de irse a refuerzo
            
            } else if (27 < prob && prob <= 60) {
                    
                    
                serie.contador = 0;                                     
                D.insertarCola(serie);                                     

                System.out.println("Refuerzo");
                

                
                
            //probabilidad de salir al mercado
            }else {
                
                this.TLOUlistos++;
                System.out.println("Salio al mercadito");
            }
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}