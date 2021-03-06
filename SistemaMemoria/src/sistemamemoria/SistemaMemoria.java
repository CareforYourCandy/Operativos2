/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamemoria;
import java.util.ArrayList; 
/**
 *
 * @author Luciano Pinedo
 */
public class SistemaMemoria {

    
    private int numProcesos = 0; 
    private MemoriaPrincipal mem;
    private MemoriaVirtual memv; 
    private ArrayList<Proceso> allProcesos = new ArrayList<>(); 
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
        allProcesos.add(proce); 
        memv.insertarProceso(proce);
        
        Pagina[] totalPags =  proce.getTotalPaginas();
        for (int i = 0; i < totalPags.length; i++) {
            memv.insertarPagina(totalPags[i]);
        }
        
        
        
    }
    
    public Proceso buscarProceso(int idProceso) {
        for (int i = 0; i < allProcesos.size(); i++) {
            if (allProcesos.get(i).getNumeroProceso() == idProceso) {
                return allProcesos.get(i); 
            }
        }
        return null; 
    }
    
   
    public void ejecutarProceso(Proceso proceso) {
        Pagina paginaEjecutar = proceso.getOrdenEjecucion().get(0); 
        if (mem.estaPagina(paginaEjecutar)) {
            proceso.getOrdenEjecucion().remove(0);
            System.out.println("LA PAGINA ESTA");
            
        } 
        else {
            System.out.println("La pagina no esta en memoria principal");
            mem.introducirPagPrincipal(paginaEjecutar);
            proceso.getOrdenEjecucion().remove(0);
        }
    
    }
    
    public boolean revisarFinal(Proceso proceso)  {
        if (proceso.getOrdenEjecucion().isEmpty()) {
            return true; 
        }
        return false; 
        
    }
    public void finalizarProceso(Proceso proceso) throws InterruptedException  {
        System.out.println("El proceso ha finalizado su ejecución");
        Thread.sleep(2000);
        allProcesos.remove(proceso); 
        mem.removerProceso(proceso); 
        proceso.setFinalizado(true);
        
    }
      /*   
        public void introducirPagPrincipal(Pagina pag) {
            
            boolean introducido = false; 
            
            for (int i = 0; i < mem.getTamaño(); i++) {
                if (mem.getMemoriaPrincipal()[i] == null) {
                    mem.getMemoriaPrincipal()[i] = pag; 
                    introducido = true; 
                }
            }
            if (!introducido) {
                Pagina menosUsada = mem.getMemoriaPrincipal()[0]; 
                int numeroUsos = mem.getMemoriaPrincipal()[0].getProcesoPadre().numeroUsos(menosUsada);
                int posicion = 0; 
                for (int j = 0; j < mem.getTamaño(); j++) {
                    Pagina paginaActual = mem.getMemoriaPrincipal()[j]; 
                    int numeroActual = paginaActual.getProcesoPadre().numeroUsos(paginaActual);
                    
                    if (numeroActual < numeroUsos) {
                        menosUsada = paginaActual; 
                        numeroUsos = numeroActual; 
                        posicion = j; 
                    }
                }
                memv.insertarPagina(menosUsada);
                mem.getMemoriaPrincipal()[posicion] = pag; 
            }
            
        
    }
        */
      
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
            allProcesos.add(proceso); 
            
        }
        
        public int procesoTotalPaginasPrincipal (Proceso proceso) {
            int cont = 0; 
            
            for (int i = 0; i < mem.getTamaño(); i++) {
                if (mem.getMemoriaPrincipal()[i] != null) {
                if ( mem.getMemoriaPrincipal()[i].getProcesoPadre() == proceso) {
                   cont++;  
                }
                }
                
            }
            return cont; 
        }

    public ArrayList<Proceso> getAllProcesos() {
        return allProcesos;
    }
        
        
}
