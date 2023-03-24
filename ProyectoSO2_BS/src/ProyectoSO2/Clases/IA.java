/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSO2.Clases;

import ProyectoSO2.Dashboard;
import java.awt.Image;
import java.io.FileWriter;
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
    
    public void recibirSeries(TLOU serieTLOU, RyM serieRM, Cola A, Cola B, Cola C, Cola D, ColaRyM F,ColaRyM G, ColaRyM H, ColaRyM I) {
        
        Icon icono;
        Icon iconoRM;
        Image imagen = null;
        try {
            try {
            //Inicializar y asignar url de la imagen a mostrar
            URL url = new URL(serieTLOU.image);
            //Asignacion de url a la imagen
            imagen = ImageIO.read(url);
            icono = new ImageIcon(imagen);
            
            URL urlRM = new URL(serieRM.foto);
            //Asignacion de url a la imagen
            imagen = ImageIO.read(urlRM);
            iconoRM = new ImageIcon(imagen);
            
            Dashboard.TLOUIcon.setIcon(icono); //Metodo para que se coloque un Ícono al dashboard serieTLOU.poder
            Dashboard.idTLOU.setText(String.valueOf(serieTLOU.id));
            Dashboard.nombreTLOU.setText(serieTLOU.personaje);
            Dashboard.poderTLOU.setText(String.valueOf(serieTLOU.poder));
            Dashboard.RMIcon.setIcon(iconoRM);
            Dashboard.idRM.setText(String.valueOf(serieRM.id));
            Dashboard.nombreRM.setText(serieRM.nombre);
            Dashboard.poderRM.setText(String.valueOf(serieRM.poder));
            
               } catch (IOException e) {
                                      e.printStackTrace();}
            
            
            
            
            int prob = new Random().nextInt(100);
            Thread.sleep(2000);  
            
            
            
            //probabilidad de encolarse de nuevo
            if (prob <= 27){
                
                serieTLOU.contador = 0;
                serieRM.cont =0;
                
                switch (serieTLOU.prioridad) {

                    case 1:

                        A.insertarCola(serieTLOU);       
                      
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
                
                }
                    //Para verificar la prioridad de la serie de RM que llegó y meterla en su cola
                    switch (serieRM.prioridad) {

                    case 1:

                          
                        F.insertar(serieRM); 
                        System.out.println("cola 4");

                        break;

                    case 2:

                        G.insertar(serieRM);       

                        System.out.println("cola 5");

                        break;

                    case 3:

                        H.insertar(serieRM);       

                        System.out.println("cola 6");

                        break;

                    default:
                        System.out.println("error");
                        break;
                
                
                
                
                }
            
            
                //Probabilidad de irse a refuerzo
            
            } else if (27 < prob && prob <= 60) {
                    
                    
                serieTLOU.contador = 0;                                     
                D.insertarCola(serieTLOU);                                     
                I.insertar(serieRM);
                System.out.println("Refuerzo");
                serieRM.cont = 0;
                
                

                
                
            //probabilidad de salir al mercado
            }else{
                
                if (serieTLOU.poder>serieRM.poder){
                    System.out.println("Gano TLOU");
                    String tlou = "ID:" + serieTLOU.id + " Prioridad:" + serieTLOU.prioridad + " Contador: " + serieTLOU.contador + " Personaje: "+serieTLOU.personaje+ " "+ serieTLOU.localizador +"\n";
                    txt(tlou);
                    this.TLOUlistos++;
                }
                if (serieRM.poder > serieTLOU.poder){
                    System.out.println("Gano RM");
                    String rm = "ID:" + serieRM.id + " Prioridad:" + serieRM.prioridad + " Contador: " + serieRM.cont + " Personaje: "+serieRM.nombre+" "+ serieTLOU.localizador +"\n";
                    txt(rm);
                    this.RMlistos++;
                }
                if (serieTLOU.poder == serieRM.poder){
                    D.insertarCola(serieTLOU);
                    I.insertar(serieRM);
                    System.out.println("Refuerzo por empatadores");
                }
                
                
                
                
            }
            Dashboard.TLOUIcon.setIcon(null);
            Dashboard.idTLOU.setText("");
            Dashboard.nombreTLOU.setText("");
            Dashboard.poderTLOU.setText("");
            Dashboard.RMIcon.setIcon(null);
            Dashboard.idRM.setText("");
            Dashboard.nombreRM.setText("");
            Dashboard.poderRM.setText("");
            Dashboard.RMListo.setText(String.valueOf(this.RMlistos));
            Dashboard.TLOUListo.setText(String.valueOf(this.TLOUlistos));
            
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public void txt (String ganador){
    try {
            String filename = "C:/Users/frand/OneDrive/Documentos/NetBeansProjects/ProyectoSO2_BS/datos.txt";
            FileWriter writer = new FileWriter(filename,true);
            writer.write(ganador);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
    }
    
    
    
    
}
    
    
}
