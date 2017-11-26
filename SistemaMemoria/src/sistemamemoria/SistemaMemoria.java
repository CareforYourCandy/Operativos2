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
public class SistemaMemoria {

    public SistemaMemoria() {
    }

    
    
    
    /**
     * @param args the command line arguments
     */
  
    public void iniciar (int memoriaSize) {
        MemoriaPrincipal mem = new MemoriaPrincipal(memoriaSize);
        System.out.println(mem.getTamaño());
    }
}
