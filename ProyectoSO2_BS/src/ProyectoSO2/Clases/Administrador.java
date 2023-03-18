/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSO2.Clases;

import java.util.Random;

/**
 *
 * @author frand
 */
public class Administrador {
    
    int idTLOU;
    int idRM;
    
    Cola nivel1TLOU;
    Cola nivel2TLOU;
    Cola nivel3TLOU;
    Cola refuerzo;
    
    public Administrador(){
    
    idTLOU = 1;
    idRM=1;
    nivel1TLOU = new Cola();
    nivel2TLOU = new Cola();
    nivel3TLOU = new Cola();
    refuerzo = new Cola();
    
    
    }
    
    public Cola getRefuerzo() {
        return refuerzo;
    }
    public Cola getNivel1TLOU() {
        return nivel1TLOU;
    }

    public Cola getNivel2TLOU() {
        return nivel2TLOU;
    }

    public Cola getNivel3TLOU() {
        return nivel3TLOU;
    }

    public int getIdTLOU() {
        return idTLOU;
    }
    
    public int Prioridad(int minutos){
        minutos = minutos;
        int prioridad =0;
        if (minutos <60){
             //Prioridad mas baja
             prioridad = 3;
         }
         
        if (minutos <90 ){
            //Prioridad media
            prioridad = 2;
        }
        
        if (minutos >= 90 ){
            //Prioridad alta
            prioridad = 1;
        }
        return prioridad;
    
    }
    
    //Metodo para agregar una serie a la cola que le corresponde
    //Mas tarde le creare la funcion para mejorarla
    public void agregarTLOU(){
    
        this.idTLOU++;
        
         int minutos = new Random().nextInt(100)+1;
         int prioridad = Prioridad(minutos);
         TLOU serie = new TLOU (this.idTLOU,prioridad);
         
         switch (serie.prioridad) {                     

            case 1:

                nivel1TLOU.insertarCola(serie);
                break;

            case 2:

                nivel2TLOU.insertarCola(serie);
                break;

            case 3:

                nivel3TLOU.insertarCola(serie);
                break;

            default:
                System.out.println("error");
                break;

        }
         
         
    
    }
    
    //Metodo para actualizar la prioridad de las series y las colas.
    
    public void actColasPrioridad(Cola A, Cola B){
    
        if(A.colaVacia()== false){
            
                for (int i = 0; i < A.size(A);i++){
                
                       TLOU temp = A.sacarCola();
                       temp.contador++;
                
                
                    if (temp.contador ==8){
                    
                        temp.contador = 0;
                        temp.prioridad--;
                        B.insertarCola(temp);
                    
                    }else{
                        A.insertarCola(temp);
                    }
                }
        }
    
    }
    
    //Metodo que se utiliza para actializar la cola de refuerzo
    public void actColaRefuerzo() {

        if (refuerzo.colaVacia() == false) {       

            int prob = new Random().nextInt(100);   

            if (prob <= 70) {

                TLOU temp = refuerzo.sacarCola();      

                switch (temp.prioridad) {        

                    case 1:

                        nivel1TLOU.insertarCola(temp);   //Se inserta en cola a

                        break;

                    case 2:

                        nivel2TLOU.insertarCola(temp);   //Se inserta en cola b

                        break;

                    case 3:

                        nivel3TLOU.insertarCola(temp);  //Se inserta en cola c

                        break;

                    default:
                        System.out.println("error");
                        break;
                }
            }

        }

    } 

    

    public TLOU sigTLOU() {

        if (!nivel1TLOU.colaVacia()) {

            TLOU serie = nivel1TLOU.sacarCola();
            return serie;

        } else if (!nivel2TLOU.colaVacia()) {

            TLOU serie = nivel2TLOU.sacarCola();
            return serie;
            
        } else if (!nivel3TLOU.colaVacia()) {

            TLOU serie = nivel3TLOU.sacarCola();
            return serie;
        } else {
            return null;
        }
    } 

    //Funciones para actualizar las colas en formato de texto para la interfaz
    public String stringTLOU_N1() {

        String texto = nivel1TLOU.text(nivel1TLOU);

        return texto;
    }  //Me devuelve la cola en un String

    public String stringTLOU_N2() {
        String texto = nivel2TLOU.text(nivel2TLOU);

        return texto;
    }  

    public String stringTLOU_N3() {
        String texto = nivel3TLOU.text(nivel3TLOU);

        return texto;
    }  

    public String stringRefuerzo() {
        String texto = refuerzo.text(refuerzo);
        return texto;
    }        
    
    
    
    
    
    
    
}
