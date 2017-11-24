/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamemoria;

import java.util.List;


/**
 *
 * @author Luciano Pinedo
 */

import java.util.ArrayList; 
import java.util.List;
        
public class MemoriaVirtual {
    
    
    List<Pagina> memoriaVirtual; 
    List<Proceso> procesosVirtual; 

    public MemoriaVirtual() {
        this.procesosVirtual = new ArrayList<>();
        this.memoriaVirtual = new ArrayList<>();
    }
    
    public void insertarPagina(Pagina pag) {
        
        Proceso padre = pag.getProcesoPadre(); 
        
        if (procesosVirtual.contains(padre) == false) {
            procesosVirtual.add(padre); 
        }
        
        
        memoriaVirtual.add(pag); 
    }
    
    
}
