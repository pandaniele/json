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
public class Libro {
       String genere;
    String titolo;
    String autore;
    float prezzo;
    
   public Libro(){
       titolo="";
       autore="";
        genere="";
       prezzo=0;
   }
   
   public void setAutore(String ab){
           autore=ab;
   }
    public void setGenere(String ab){
        genere=ab;
   }
      public void setTitolo(String ab){
        titolo=ab;
   }
     public void setPrezzo(float ab){
         prezzo=ab;
   }
     
     public String getAutore(){
         return autore;
     }
    
      public String getGenere(){
         return genere;
     }
      
       public String getTitolo(){
         return titolo;
     }
         public float getPrezzo(){
         return prezzo;
     }
    
    
}

