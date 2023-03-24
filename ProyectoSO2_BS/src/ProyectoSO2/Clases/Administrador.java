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
    ColaRyM nivel1RM;
    ColaRyM nivel2RM;
    ColaRyM nivel3RM; 
    Cola refuerzo;
    ColaRyM refuerzoRM;
    
    public Administrador() throws IOException{
    
    idTLOU = 0;
    idRM=0;
    nivel1TLOU = new Cola();
    nivel2TLOU = new Cola();
    nivel3TLOU = new Cola();
    refuerzo = new Cola();
    refuerzoRM = new ColaRyM();
    nivel1RM = new ColaRyM(); 
    nivel2RM = new ColaRyM();
    nivel3RM = new ColaRyM();
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
    
    //Metodo para agregar una serie a la cola que le corresponde
    public void agregarTLOU() throws IOException{
    
        this.idTLOU++;
         int prioridad = PrioridadTLOU();
         String num = String.valueOf(new Random().nextInt(3)+1);
         String personaje = api.APIname(num);
         String image = api.APIimage(num);
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
    public void agregarRM() throws IOException{
    
        this.idRM++;       
         int prioridad = PrioridadRM();
         String num = String.valueOf(new Random().nextInt(3)+1);
         String nombre = api.APIname(num);
         String foto = api.APIimage(num);        
         int poder = new Random().nextInt(10)+1;
         RyM serie = new RyM (this.idRM,prioridad,nombre,poder, foto);
         
         switch (serie.prioridad) {                     
            case 1:
                nivel1RM.insertar(serie);
                break;
            case 2:
                nivel2RM.insertar(serie);
                break;
            case 3:
                nivel3RM.insertar(serie);
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
    
     public void actColasPrioridadRM(ColaRyM A, ColaRyM B){
    
        if(A.colaVacia()== false){
            
                for (int i = 0; i < A.tam(A);i++){
                
                       RyM temp = A.retirar();
                       temp.cont++;
                
                
                    if (temp.cont ==8){
                    
                        temp.cont = 0;
                        temp.prioridad--;
                        B.insertar(temp);
                    
                    }else{
                        A.insertar(temp);
                    }
                }
        }
    
    }
    
    
    //Metodo que se utiliza para actializar la cola de refuerzo
    public void actColaRefuerzo() {

        if (refuerzo.colaVacia() == false && refuerzoRM.colaVacia() == false) {       

            int prob = new Random().nextInt(100);   

            if (prob <= 40) {
                boolean activo = true;
        
                while (activo) {
                TLOU temp = refuerzo.sacarCola(); 
                RyM temp2 = refuerzoRM.retirar(); 
                
                if (temp.localizador == "TLOU"&& temp2.localizador == "RM"){
                    activo = false;
                    switch (temp.prioridad) {        

                    case 1:

                        nivel1TLOU.insertarCola(temp);   //Se inserta en cola a

                        

                    case 2:

                        nivel2TLOU.insertarCola(temp);   //Se inserta en cola b

                        

                    case 3:

                        nivel3TLOU.insertarCola(temp);  //Se inserta en cola c


                    default:
                        System.out.println("error");
                    
                    switch (temp2.prioridad) {        

                    case 1:

                        nivel1RM.insertar(temp2);   //Se inserta en cola f

                        break;

                    case 2:

                        nivel2RM.insertar(temp2);   //Se inserta en cola g

                        break;

                    case 3:

                        nivel3RM.insertar(temp2);  //Se inserta en cola h

                        break;

                    default:
                        System.out.println("error");
                        break;
                       
                    
                }
                }
                    
                
               
                }
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
    
     public RyM sigRM() {

        if (!nivel1RM.colaVacia()) {

            RyM serie = nivel1RM.retirar();
            return serie;

        } else if (!nivel2RM.colaVacia()) {

            RyM serie = nivel2RM.retirar();
            return serie;
            
        } else if (!nivel3RM.colaVacia()) {

            RyM serie = nivel3RM.retirar();
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
    
    public String stringRM1() {
        String texto = nivel1RM.texto(nivel1RM);
        return texto;
    }  
     public String stringRM2() {
        String texto = nivel2RM.texto(nivel2RM);
        return texto;
    }  
      public String stringRM3() {
        String texto = nivel3RM.texto(nivel3RM);
        return texto;
    }  

    public String stringRefuerzo() {
        String texto = refuerzo.text(refuerzo);
        String textoRM = refuerzoRM.texto(refuerzoRM);
        return texto+textoRM;
    }        
    
    
    
    
    
    
    
}
