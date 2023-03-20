/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSO2.Clases;

import ProyectoSO2.main;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author frand
 */
public class API {
    
    String id;
    String name;
    String image;
    
    
    
    public API() throws IOException{
        
        this.id = "";
        this.name = "";
        this.image = "";
        
    }
    
    public String APIid (String num) throws IOException{
    //Solicitar peticion
        
        try {
        //https://rickandmortyapi.com/api/character/1
  
        URL url = new URL("https://rickandmortyapi.com/api/character/"+num);
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        
        //Revision de la peticion
        
        int response_code = conn.getResponseCode();
        if (response_code != 200){
            throw new RuntimeException("Ocurrio un error: "+ response_code);
        }else {
            //Abrir un scanner que lea el flujo de datos 
        
             StringBuilder information = new StringBuilder();
             
             Scanner scanner = new Scanner(url.openStream());
             
             while (scanner.hasNext()) {
             
                 information.append(scanner.nextLine());
             }
             String[] datos = information.toString().split(",",12);
             scanner.close();
             
             int contador = 0;
            //Pintar nuestra informacion obtenida por consola
            String personaje = "";
            this.id = datos[0].split(":")[1];
            
        }
        
        
        
        
        } catch (MalformedURLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return id;
    
    }
    
    public String APIname (String num) throws IOException{
    //Solicitar peticion
        
        try {
        //https://rickandmortyapi.com/api/character/1
  
        URL url = new URL("https://rickandmortyapi.com/api/character/"+num);
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        
        //Revision de la peticion
        
        int response_code = conn.getResponseCode();
        if (response_code != 200){
            throw new RuntimeException("Ocurrio un error: "+ response_code);
        }else {
            //Abrir un scanner que lea el flujo de datos 
        
             StringBuilder information = new StringBuilder();
             
             Scanner scanner = new Scanner(url.openStream());
             
             while (scanner.hasNext()) {
             
                 information.append(scanner.nextLine());
             }
             String[] datos = information.toString().split(",",12);
             scanner.close();
             
             int contador = 0;
            //Pintar nuestra informacion obtenida por consola
            String personaje = "";
            this.name = datos[1].split(":")[1];
            
        }
        
        
        
        
        } catch (MalformedURLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return name;
    
    }
  
    public String APIimage (String num) throws IOException{
    //Solicitar peticion
        
        try {
        //https://rickandmortyapi.com/api/character/1
  
        URL url = new URL("https://rickandmortyapi.com/api/character/"+num);
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        
        //Revision de la peticion
        
        int response_code = conn.getResponseCode();
        if (response_code != 200){
            throw new RuntimeException("Ocurrio un error: "+ response_code);
        }else {
            //Abrir un scanner que lea el flujo de datos 
        
             StringBuilder information = new StringBuilder();
             
             Scanner scanner = new Scanner(url.openStream());
             
             while (scanner.hasNext()) {
             
                 information.append(scanner.nextLine());
             }
             String[] datos = information.toString().split(",",12);
             scanner.close();
             
             int contador = 0;
            //Pintar nuestra informacion obtenida por consola
            String personaje = "";
            this.image =(datos[10].split("")[0]+ datos[10].split(":")[1]+':'+datos[10].split(":")[2]).replaceAll("\"", "");
            
        }
        
        
        
        
        } catch (MalformedURLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return image;
    
    }
  
}
    


/*System.out.println(datos[1].split(":")[1]);
            System.out.println(datos[10].split(":")[1]+':'+datos[10].split(":")[2]);*/

