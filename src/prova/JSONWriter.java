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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

public class JSONWriter {
    public static final String JSON_FILE="libri.json";
    public static void main(String [] args) throws IOException{
        
        ArrayList<Libro> libri = new ArrayList<Libro>();
  
        //2 numero di oggetti
        libri.add(new Libro());
        libri.get(0).setGenere("fantasy");
        libri.get(0).setTitolo("Lo Hobbit");
        libri.get(0).setAutore("J.R.R.Tolkien");
        libri.get(0).setPrezzo(9.99f);
        
        libri.add(new Libro());
        libri.get(1).setGenere("fantasy");
        libri.get(1).setTitolo("Il signore degli anelli");
        libri.get(1).setAutore("J.R.R.Tolkien");
        libri.get(1).setPrezzo(30.00f);
        
        //creazione dei costruttori degli oggetti/array JSON
        JsonObjectBuilder rootObject =Json.createObjectBuilder();
         JsonObjectBuilder booksObject =Json.createObjectBuilder();
            JsonArrayBuilder bookArray =Json.createArrayBuilder();
         
            //ciclo creazione di oggetti JSON come elementi di un array
            for(Libro libro : libri){
                 JsonObjectBuilder bookObject =Json.createObjectBuilder(); 
                 bookObject.add("genere", libro.getGenere());
                 bookObject.add("titolo", libro.getTitolo());
                 bookObject.add("autore", libro.getAutore());
                 bookObject.add("prezzo", libro.getPrezzo());
                 bookArray.add(bookObject.build());
            }
            
            //creazione gerarchica oggetti JSON
            booksObject.add("libri", bookArray.build());
            rootObject.add("libreria", booksObject.build());
            //STRINGA JSON =OGGETTO JSON
            //VALORI POSSONO ESSERE OGGETTI.
            OutputStream output = new FileOutputStream(JSON_FILE);
        
        JsonWriter jsonWriter = Json.createWriter(output);
        
        jsonWriter.writeObject(rootObject.build());
        
        jsonWriter.close();
        
        output.close();
    
}
}
