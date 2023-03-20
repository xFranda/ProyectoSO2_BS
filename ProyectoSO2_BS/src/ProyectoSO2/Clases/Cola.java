/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSO2.Clases;

/**
 *
 * @author frand
 */
public class Cola {
    
    //Creo que es posible utilizar una sola primitiva para las colas.
    
    private NodoTLOU Inicio, Final;
    
    String Cola = "";
    
    
    public Cola(){
        this.Inicio = null;
        this.Final = null;
    }
    
    
    //Metodo para insertar en la cola
    
    public void insertarCola(TLOU info){
    
           NodoTLOU nuevo = new NodoTLOU();
           nuevo.info = info;
           nuevo.sig = null;
           
           if (colaVacia()){
               Inicio = nuevo;
               Final = nuevo;
          
           }else{
               Final.sig = nuevo;
               Final = nuevo;
           
           }
    
    }
    
    //Metodo para returar de la cola una Serie
    public TLOU sacarCola(){
        if(!colaVacia()){
        
        TLOU info = Inicio.info;
        
        if (Inicio == Final){
            Inicio = null;
            Final = null;
        }else{
            Inicio = Inicio.sig;
        
        }
        return info;
        }else{
            return null;
        }
    
    
    
    }
    
    //Metodo para saber el tama;o de la cola, recorriendola
    
    public int size(Cola C){
    
           NodoTLOU temp = C.Inicio;
           int contador = 0;
           
           while(temp !=null){
           contador++;
           temp = temp.sig;
           }
           
           return contador;
       
    }
    
    
    //Metodo para conocer si la cola se encuentra vacia
    public boolean colaVacia(){
    
        if (Inicio == null){
            return true;
        }else {
            return false;
        }
    
    }
    
    //Metodo para transformar el cintenido de la cola en un String para la interfaz
    public String text(Cola A){
    
        NodoTLOU serie = A.Inicio;
        String texto = "";

        while (serie != null){

            TLOU temp = serie.info;
            texto = texto + "ID:" + temp.id + " Prioridad:" + temp.prioridad + " Contador:" + temp.contador + "Personaje: "+ temp.personaje + "\n"; 
            serie = serie.sig;
        }
    
        return texto;
    }
}
