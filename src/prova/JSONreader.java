/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;

/**
 *
 * @author pandl
 */
import java.io.*;
import javax.json.*;

public class JSONreader {
    public static final String JSON_FILE="libri.json";
    
    public static void main(String[] args) throws IOException{
        Libro libri[];
        InputStream input=new FileInputStream(JSON_FILE);
        
        //creazione di un oggetto JsonReader
        
        JsonReader jsonReader = Json.createReader(input);
        
        //lettura dell'oggetto JSON radice
        
        JsonObject jsonObject=jsonReader.readObject();
        
        //chiusura dello stream e dell'oggetto JsonReader
        
        jsonReader.close();
        input.close();
        
        //lettura dell'oggetto JSON valore della propieta' biblioteca
      JsonObject innerJsonObject= jsonObject.getJsonObject("libreria");
      
      //lettura dell'array JSON "libri" e dimensionamento dell'array JAVA
      
      JsonArray jsonArray=innerJsonObject.getJsonArray("libri");
      libri= new Libro[jsonArray.size()];
      
      //ciclo di lettura dei singoli elementi dell'array
      int index=0;
      for(JsonValue element : jsonArray){
          Libro libro= new Libro();
          //recupero delle propieta' dell'oggetto JSON
          libro.setGenere(element.asJsonObject().getString("genere"));
           libro.setTitolo(element.asJsonObject().getString("titolo"));
            libro.setAutore(element.asJsonObject().getString("autore"));
            libro.setPrezzo((float)(element.asJsonObject().getJsonNumber("prezzo").doubleValue()));
            
            libri[index++]=libro;
      }
      
        //ciclo di visualizzazione dell'array Java
        
        for(index=0; index<libri.length; index++){
            System.out.println(libri[index]);
        }
    }
    
    
    }
    
    

