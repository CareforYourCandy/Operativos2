/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamemoria;

import java.util.List; 
import java.util.ArrayList; 

/**
 *
 * @author Luciano Pinedo
 */
public class Proceso {
   
    List<Pagina> ordenEjecucion = new ArrayList<Pagina>();   
    Pagina[] totalPaginas;
    int numeroProceso; 

    public Proceso(int Numero) {
        this.numeroProceso = Numero;
    }
    
    public void insertarPaginaEjecucion(Pagina pag) {
        
        ordenEjecucion.add(pag); 
         
    }
    
    public void ejecucionSecuencial (int totalPaginas) {
        this.totalPaginas = new Pagina[totalPaginas]; 
        
        
        
    for (int i = 0; i < totalPaginas; i++ ) {
       
        Pagina Matienzo = new Pagina(i, this); 
        this.totalPaginas[i] = Matienzo; 
        insertarPaginaEjecucion(Matienzo); 
        
    }    
    }
    
    public void ejecucionRamificada ( int totalPag) {
        this.totalPaginas = new Pagina[totalPag]; 
        
        for (int i = 0; i < totalPag; i++) {
            Pagina superMatienzo = new Pagina(i, this);
            this.totalPaginas[i]  = superMatienzo;
                   
        }
        
       
        
        
    } 

    public int getNumeroProceso() {
        return numeroProceso;
    }

    public List<Pagina> getOrdenEjecucion() {
        return ordenEjecucion;
    }

    public Pagina[] getTotalPaginas() {
        return totalPaginas;
    }
        
    
    
    
        
    
    
    
}
