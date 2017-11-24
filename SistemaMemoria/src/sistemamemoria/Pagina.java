/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamemoria;

/**
 *
 * @author Luciano Pinedo
 */
public class Pagina {
    
    int numeroPagina;
    Proceso procesoPadre; 

    public Pagina(int numeroPagina, Proceso procesoPadre) {
        this.numeroPagina = numeroPagina;
        this.procesoPadre = procesoPadre;
    }
    
    

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public Proceso getProcesoPadre() {
        return procesoPadre;
    }
    
    
    
    
}
