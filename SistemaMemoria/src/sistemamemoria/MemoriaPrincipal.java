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
    
    int tamaño; 
    Pagina[] memoriaPrincipal;
    List<Proceso> principalProcesos = new ArrayList<Proceso>();
    
    public void insertarPaginaPrincipal(Pagina pag) {
        
        for (int i = 0; i < memoriaPrincipal.length; i++) {
            if (memoriaPrincipal[i] == null) {
                memoriaPrincipal[i] = pag;
                i = memoriaPrincipal.length; 
            }
            
        }
        
        insertarProcesoPrincipal(pag.getProcesoPadre()); 
        
    }
    
    public void insertarProcesoPrincipal(Proceso proceso) {
        
        if (principalProcesos.contains(proceso) == false) {
            principalProcesos.add(proceso); 
        }
    }
    
    
    
    
}
