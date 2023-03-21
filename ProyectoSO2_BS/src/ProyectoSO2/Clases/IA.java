/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSO2.Clases;

import ProyectoSO2.Dashboard;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

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
    
    public void recibirSeries(TLOU serieTLOU, Cola A, Cola B, Cola C, Cola D) {
        
        Icon icono;
        Image imagen = null;
        try {
            try {
            //Inicializar y asignar url de la imagen a mostrar
            URL url = new URL(serieTLOU.image);
            //Asignacion de url a la imagen
            imagen = ImageIO.read(url);
            icono = new ImageIcon(imagen);
            Dashboard.TLOUIcon.setIcon(icono); //Metodo para que se coloque un Ícono al dashboard
               } catch (IOException e) {
                                      e.printStackTrace();}
            
            int prob = new Random().nextInt(100);
            Thread.sleep(1000);  
            
            
            //probabilidad de encolarse de nuevo
            if (prob <= 27){
                
                serieTLOU.contador = 0;
                //serieRM.contador =0;
                
                switch (serieTLOU.prioridad) {

                    case 1:

                        A.insertarCola(serieTLOU);       
                        //E.insertarCola(serieRM) 
                        System.out.println("cola 1");

                        break;

                    case 2:

                        B.insertarCola(serieTLOU);          

                        System.out.println("cola 2");

                        break;

                    case 3:

                        C.insertarCola(serieTLOU);           

                        System.out.println("cola 3");

                        break;

                    default:
                        System.out.println("error");
                        break;
                
                  
                    //Para verificar la prioridad de la serie de RM que llegó y meterla en su cola
                    /*switch (serieRM.prioridad) {

                    case 1:

                        E.insertarCola(serieTLOU);       
                        //E.insertarCola(serieRM) 
                        System.out.println("cola 1");

                        break;

                    case 2:

                        F.insertarCola(serieTLOU);          

                        System.out.println("cola 2");

                        break;

                    case 3:

                        G.insertarCola(serieTLOU);           

                        System.out.println("cola 3");

                        break;

                    default:
                        System.out.println("error");
                        break;
                */
                
                
                
                }
            
            
                //Probabilidad de irse a refuerzo
            
            } else if (27 < prob && prob <= 60) {
                    
                    
                serieTLOU.contador = 0;                                     
                D.insertarCola(serieTLOU);                                     
                //D.insertarCola(serieRM); Para que se inserte la serie de RM en caso de requerir refuerzo las 2.
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
