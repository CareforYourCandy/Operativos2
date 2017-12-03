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
public class MemoriaPrincipal {
    
    
    private Pagina[] memoriaPrincipal;

    
    public boolean estaPagina(Pagina pag) {
        for ( int i = 0; i < memoriaPrincipal.length; i++) {
            
            if (memoriaPrincipal[i] != null) {
                if (memoriaPrincipal[i] == pag) {
                    return true; 
                }
            }
        }
     
        return false; 
        
    }
    
    public boolean tienePagina(Proceso proceso) {
        for (int i = 0; i < memoriaPrincipal.length; i++) {
            if (memoriaPrincipal[i] != null) {
                if (memoriaPrincipal[i].getProcesoPadre() == proceso) {
                    return true; 
                }
            }
        }
        return false; 
    }
    
    public void introducirPagPrincipal(Pagina pag) {
            
            boolean introducido = false; 
            
            for (int i = 0; i < memoriaPrincipal.length; i++) {
                if (memoriaPrincipal[i] == null) {
                    memoriaPrincipal[i] = pag; 
                    introducido = true;
                    i = memoriaPrincipal.length; 
                }
            }
            if (!introducido) {
              Pagina menosProxima = memoriaPrincipal[0]; 
                int referenciaGuardada = memoriaPrincipal[0].getProcesoPadre().proximaReferencia(menosProxima);
                int posicion = 0; 
                for (int j = 0; j < memoriaPrincipal.length; j++) {
                    Pagina paginaActual = memoriaPrincipal[j];
                    int referenciaActual = paginaActual.getProcesoPadre().proximaReferencia(paginaActual);
                    
                    if (referenciaGuardada < referenciaActual) {
                        menosProxima = paginaActual;
                        posicion = j; 
                        referenciaGuardada = referenciaActual; 
                    }
                }
                 memoriaPrincipal[posicion] = pag;
            }
            
    }
    /*
      Pagina menosUsada = memoriaPrincipal[0]; 
                int numeroUsos = memoriaPrincipal[0].getProcesoPadre().numeroUsos(menosUsada);
                int posicion = 0; 
                for (int j = 0; j < memoriaPrincipal.length; j++) {
                    Pagina paginaActual = memoriaPrincipal[j]; 
                    int numeroActual = paginaActual.getProcesoPadre().numeroUsos(paginaActual);
                    
                   
                        if (numeroActual == numeroUsos) {
                            int actualLejania = -1;
                            int guardadaLejania = -1; 
                            for (int k = 0; k < paginaActual.getProcesoPadre().getOrdenEjecucion().size(); k++) {
                                actualLejania++;
                                if (paginaActual.getProcesoPadre().getOrdenEjecucion().get(k) == paginaActual) {
                                    k = paginaActual.getProcesoPadre().getOrdenEjecucion().size(); 
                                }
                            for (int l = 0; l < menosUsada.getProcesoPadre().getOrdenEjecucion().size(); l++) {
                                guardadaLejania++;
                                if (menosUsada.getProcesoPadre().getOrdenEjecucion().get(l) == menosUsada) {
                                    l = menosUsada.getProcesoPadre().getOrdenEjecucion().size();
                                }
                            }
                            if (actualLejania > guardadaLejania) {
                                 menosUsada = paginaActual; 
                                 numeroUsos = numeroActual; 
                                posicion = j; 
                            }
                            }
                        }
                        if (numeroActual < numeroUsos) {
                        menosUsada = paginaActual; 
                        numeroUsos = numeroActual; 
                        posicion = j; 
                    } 
                    }
                
                memoriaPrincipal[posicion] = pag;
                }
    */
    
    public void removerProceso(Proceso proceso) {
        for ( int i = 0; i < memoriaPrincipal.length; i++) {
            if (memoriaPrincipal[i] != null){
            if (memoriaPrincipal[i].getProcesoPadre() == proceso) {
                memoriaPrincipal[i] = null; 
            }
            }
            
        }
    }
    public MemoriaPrincipal(int size) {
        this.memoriaPrincipal = new Pagina[size]; 
    }
    
    public int getTamaño() {
        return memoriaPrincipal.length; 
    }

   

    public Pagina[] getMemoriaPrincipal() {
        return memoriaPrincipal;
    }
    
    
}
