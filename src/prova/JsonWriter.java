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
import java.math.BigDecimal;
 import javax.json.*;


public class JsonWriter {
    public static final String JSON_FILE="libri.json";
    public static void main(String [] args) throws IOException{
        Libro libri[]=new Libro[2];
        //2 numero di oggetti
        libri[0]=new Libro();
        libri[0].setGenere("fantasy");
        libri[0].setTitolo("Lo Hobbit");
        libri[0].setAutore("J.R.R.Tolkien");
        libri[0].setPrezzo(9.99f);
        
        libri[1]=new Libro();
        libri[1].setGenere("fantasy");
        libri[1].setTitolo("Il signore degli anelli");
        libri[1].setAutore("J.R.R.Tolkien");
        libri[1].setPrezzo(30.00f);
        
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
    }
}
