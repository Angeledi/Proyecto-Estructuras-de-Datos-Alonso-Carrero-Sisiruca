/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_alonso_carrero_sisiruca_edd_secc2;

/**
 *
 * @author acarr
 */
public class Proyecto_Alonso_Carrero_Sisiruca_EDD_Secc2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.setUhead(new Usuario("pepito", 56));
        lista.InsertFinal("@cosi", 24);
        Grafo grafo = new Grafo(lista);
        grafo.printGrafo();
        grafo.printAdy();
        Grafo grafo2= new Pruebas().leer_txt();
        System.out.println(grafo2.printGrafo());
        System.out.println(grafo2.printAdy());
        
        
    }
    
}
