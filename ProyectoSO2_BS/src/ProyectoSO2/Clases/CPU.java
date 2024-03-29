/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSO2.Clases;

import ProyectoSO2.Dashboard;
import java.io.IOException;
import java.util.Random;
import javax.swing.Icon;

/**
 *
 * @author frand
 */
public class CPU {
    
    int contador_ciclos; //Variable para contar cuando pasen cada 2 ciclos
    
    String cola1TLOU;
    String cola2TLOU;
    String cola3TLOU;
    String cola1RM;
    String cola2RM; 
    String cola3RM;
    String refuerzo;
    String refuerzoRM;
    Administrador admin;
    IA gtp4;
    
    
    public CPU () throws InterruptedException, IOException {
        
        admin = new Administrador(); //Inicializamos al administrador
        gtp4 = new IA();            //Inicializamos la inteligencia artificial
        Dashboard dashboard = new Dashboard(); //Inicializamos la interfaz
    
        this.contador_ciclos=0;
        
        int p = new Random().nextInt(3)+1;
        TLOU serieTLOU = null;
        RyM serieRM = null; 
        //new TLOU(admin.getIdTLOU(),p,"Rick Sanchez","https://rickandmortyapi.com/api/character/avatar/1.jpeg",5);
        //admin.listaPrioridadTLOU(serieTLOU);
        
        
        boolean activo = true;
        
        while (activo) {

            admin.actColasPrioridad(admin.nivel3TLOU, admin.nivel2TLOU);//El administrador ejecuta la funcion de actualizar colas
            admin.actColasPrioridad(admin.nivel2TLOU, admin.nivel1TLOU);
            admin.actColasPrioridadRM(admin.nivel3RM, admin.nivel2RM);
            admin.actColasPrioridadRM(admin.nivel2RM, admin.nivel1RM);
            admin.actColaRefuerzo();

            cola1TLOU = admin.stringTLOU_N1();       //Obtiene la lista de prioridad 1 en un String
            cola2TLOU = admin.stringTLOU_N2();       //Obtiene la lista de prioridad 2 en un String
            cola3TLOU = admin.stringTLOU_N3();       //Obtiene la lista de prioridad 3 en un String
            refuerzo = admin.stringRefuerzo();
            
            cola1RM = admin.stringRM1();       //Obtiene la lista de prioridad 1 en un String
            cola2RM = admin.stringRM2();       //Obtiene la lista de prioridad 2 en un String
            cola3RM = admin.stringRM3();       //Obtiene la lista de prioridad 3 en un String
            refuerzoRM = admin.stringRefuerzo();
                    
            Dashboard.Prioridad1.setText(cola1TLOU);
            Dashboard.Prioridad2.setText(cola2TLOU);
            Dashboard.Prioridad3.setText(cola3TLOU);
            Dashboard.Prioridad4.setText(cola1RM);
            Dashboard.Prioridad5.setText(cola2RM);
            Dashboard.Prioridad6.setText(cola3RM);
            Dashboard.Refuerzos.setText(refuerzo);
            

            if (serieTLOU != null && serieRM != null ) {
                 System.out.println("ID:" + serieRM.id + " Prioridad:" + serieRM.prioridad + " Contador: " + serieRM.cont + " Personaje: "+serieRM.nombre + " Poder: "+serieRM.poder +"RM");
                 System.out.println(admin.stringRM1());

                System.out.println("ID:" + serieTLOU.id + " Prioridad:" + serieTLOU.prioridad + " Contador: " + serieTLOU.contador + " Personaje: "+serieTLOU.personaje + " Poder: "+serieTLOU.poder +"TLOU");
                gtp4.recibirSeries(serieTLOU, serieRM, admin.nivel1TLOU, admin.nivel2TLOU, admin.nivel3TLOU, admin.refuerzo, admin.nivel1RM, admin.nivel2RM, admin.nivel3RM, admin.refuerzoRM);        //La IA que realizara las comparaciones de series
            }

            cola1TLOU = admin.stringTLOU_N1();       //Obtiene la lista de prioridad 1 en un String
            cola2TLOU = admin.stringTLOU_N2();       //Obtiene la lista de prioridad 2 en un String
            cola3TLOU = admin.stringTLOU_N3();       //Obtiene la lista de prioridad 3 en un String
            refuerzo = admin.stringRefuerzo();           //Obtiene la lista de reparacion en un String
            cola1RM = admin.stringRM1();       //Obtiene la lista de prioridad 1 en un String
            cola2RM = admin.stringRM2();       //Obtiene la lista de prioridad 2 en un String
            cola3RM = admin.stringRM3();       //Obtiene la lista de prioridad 3 en un String
            
            
            Dashboard.Prioridad1.setText(cola1TLOU);
            Dashboard.Prioridad2.setText(cola2TLOU);
            Dashboard.Prioridad3.setText(cola3TLOU);
            Dashboard.Refuerzos.setText(refuerzo);
            Dashboard.Prioridad4.setText(cola1RM);
            Dashboard.Prioridad5.setText(cola2RM);
            Dashboard.Prioridad6.setText(cola3RM);
            Dashboard.Refuerzos.setText(refuerzo);
                        
            if (contador_ciclos == 2) {  //Si ya se recorrieron dos ciclos entra en esta condicional
                
                
            contador_ciclos = 0;
            System.out.println("Agregando");
            admin.agregarRM();
            admin.agregarTLOU();//Se agrega TLOU
            Thread.sleep(1000);

            }

            Thread.sleep(1000);  //Se duermo un segundo el programa para que se pueda revisar bien

            serieTLOU = admin.sigTLOU();
            serieRM = admin.sigRM();
            contador_ciclos++;

        }

        
    }
    
    
}
