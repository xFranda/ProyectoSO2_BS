/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSO2.Clases;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author frand
 */
public class Administrador {
    
    int idTLOU;
    int idRM;
    
    API api;
    
    Cola nivel1TLOU;
    Cola nivel2TLOU;
    Cola nivel3TLOU; 
    //Crear aquí las 3 colas de prioridad de RM, pueden ser nivel1RM, nivel2RM y nivel3RM
    Cola refuerzo;
    
    public Administrador() throws IOException{
    
    idTLOU = 1;
    idRM=1;
    nivel1TLOU = new Cola();
    nivel2TLOU = new Cola();
    nivel3TLOU = new Cola();
    refuerzo = new Cola();
    //Crear aquí las colitas de RM
    api = new API();
    
    
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
    
    //Craer los lindos metodos de RM
    
    
    
    //Guiate de este miuntosTLOU y prioridadTLOU para el extra de lo aleatorio de tu serie.
    public int minutosTLOU(){
        int intro = 0;
        int inicio1 = 0;
        int inicio2 = 0;
        int cierre1 = 0;
        int cierre2 =0;
        int creditos = 0;
        int prob_calidad = 0;
        int minutos =0;
        
        //En este caso, un cap de TLOU tiene 1 intro, 2 inicios, 2 cierres y 1 credito.
        //Se inicializaran los valores de cada parte de un capitulo
        intro = new Random().nextInt(100)+1; //1 Intro = 0-100
        
        inicio1 = new Random().nextInt(100)+1; //2 Inicios = 0-200
        inicio2 = new Random().nextInt(100)+1;
        
        cierre1 = new Random().nextInt(100)+1; //2 Cierres = 0-200
        cierre2 = new Random().nextInt(100)+1;
        
        creditos = new Random().nextInt(100)+1; //1 Credito = 0-100
        
        prob_calidad = (intro+inicio1+inicio2+cierre1+cierre2+creditos)/6;
        
        minutos = 10+prob_calidad;
        
        return minutos;
    
    }
    public int PrioridadTLOU(){
        int minutos = minutosTLOU();
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
    
    //Metodo para agregar una serie a la cola que le corresponde
    public void agregarTLOU() throws IOException{
    
        this.idTLOU++;
        
        
         int prioridad = PrioridadTLOU();
         
         String personaje = api.APIname(String.valueOf(new Random().nextInt(3)+1));
         String image = api.APIimage(String.valueOf(new Random().nextInt(3)+1));
         int poder = new Random().nextInt(10)+1;
         TLOU serie = new TLOU (this.idTLOU,prioridad,personaje,image,poder);
         
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
    
    //Crear metodo de agregar RM
    
    
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
