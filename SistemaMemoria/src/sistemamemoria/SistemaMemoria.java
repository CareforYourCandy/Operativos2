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

    
    int numProcesos = 0; 
    MemoriaPrincipal mem;
    MemoriaVirtual memv; 
    public SistemaMemoria() {
        
    }

    public int getNumProcesos() {
        return numProcesos;
    }

    public MemoriaPrincipal getMemoriaPrincipal() {
        return mem;
    }

    public MemoriaVirtual getMemoriaVirtual() {
        return memv;
    }

    
    
    
    /**
     * @param args the command line arguments
     */
  
    public void iniciar (int memoriaSize) {
        mem = new MemoriaPrincipal(memoriaSize);
        memv = new MemoriaVirtual();
        System.out.println(mem.getTamaño());
    }
    
    public void crearProcesoSecuencial(int numpag) {
        Proceso proce = new Proceso (numProcesos);
        proce.ejecucionSecuencial(numpag);
        System.out.println("Se creo el proceso:" + numProcesos );
        numProcesos++; 
        memv.insertarProceso(proce);
        
        Pagina[] totalPags =  proce.getTotalPaginas();
        for (int i = 0; i < totalPags.length; i++) {
            memv.insertarPagina(totalPags[i]);
        }
        
        
        
    }
    
    public void ejecutarPagProcesoPrincipal (Proceso procesoEjecutar) {
        
        for (int i = 0; i < mem.getTamaño(); i++) {
            if (mem.getMemoriaPrincipal()[i] == procesoEjecutar.getOrdenEjecucion().get(0)) {
                procesoEjecutar.getOrdenEjecucion().remove(0); 
                i = mem.getTamaño(); 
             
            }
        }
    }
    
        public void ejecutarPagProcesoVirtual(Proceso procesoEjecutar) {
             for (int j = 0; j <  memv.getMemoriaVirtual().size(); j++ ) {
                if (memv.getMemoriaVirtual().get(j) == procesoEjecutar.getOrdenEjecucion().get(0)) {
                    introducirPagPrincipal(memv.getMemoriaVirtual().get(j));
                    ejecutarPagProcesoPrincipal(procesoEjecutar);
                    j = memv.getMemoriaVirtual().size(); 
                }
            }
        }
       
        public void introducirPagPrincipal(Pagina pag) {
            
            boolean introducido = false; 
            
            for (int i = 0; i < mem.getTamaño(); i++) {
                if (mem.getMemoriaPrincipal()[i] == null) {
                    mem.getMemoriaPrincipal()[i] = pag; 
                    introducido = true; 
                }
            }
            if (!introducido) {
                //Super algoritmo 
            }
            
        
    }
        public Proceso iniciarProcesoEspecifico(int numeroPags) {
            Proceso procesoNuevo = new Proceso(numProcesos);
            procesoNuevo.ejecucionRamificada(numeroPags);
            return procesoNuevo; 
        }
        
        public void agregarEjecucionEspecifica(int numero, Proceso proceso) {
            proceso.añadirEjecucion(numero); 
        }
        
        public void removerEjecucionEspecifica(Proceso proceso) {
            proceso.eliminarEjecucion();
        }
        
        public void guardarProcesoEspecifico(Proceso proceso) {
            memv.insertarProceso(proceso);
            proceso.imprimirOrden();
            for (int i = 0; i < proceso.getTotalPaginas().length; i++ ) {
                memv.insertarPagina(proceso.getTotalPaginas()[i]);
            }
            numProcesos++; 
            
        }
}
