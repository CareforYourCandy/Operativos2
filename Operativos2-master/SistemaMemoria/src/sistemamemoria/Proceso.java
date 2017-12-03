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
    boolean finalizado = false; 

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    
    
    public Proceso(int Numero) {
        this.numeroProceso = Numero;
    }
    
    public void insertarPaginaEjecucion(Pagina pag) {
        
        ordenEjecucion.add(pag); 
         
    }
    
    public void añadirEjecucion(int numeroPag) {
        
        insertarPaginaEjecucion(totalPaginas[numeroPag]); 
    }
    
    public void eliminarEjecucion() {
        
        ordenEjecucion.remove(ordenEjecucion.get(ordenEjecucion.size() - 1)); 
        
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
    
    public int proximaReferencia(Pagina pag) {
        int proximaReferencia = 0; 
        for ( int i = 0; i < ordenEjecucion.size(); i++) {
            proximaReferencia = i;
            if ( pag == ordenEjecucion.get(i)) {
                i = ordenEjecucion.size(); 
                
            }
        }
        return proximaReferencia; 
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
        
    public void imprimirOrden() {
       for (int i = 0; i < ordenEjecucion.size(); i++) {
           System.out.println(" " + ordenEjecucion.get(i).getNumeroPagina() + " ");
           
       } 
        
    
    }
    
    public int numeroUsos(Pagina pagina) {
        int vecesUsada = 0; 
        for (int i = 0; i < ordenEjecucion.size() ; i++) {
            if (ordenEjecucion.get(i) == pagina) {
                vecesUsada++; 
            }
        }
        return vecesUsada; 
    }    
        
    
    
    
}
