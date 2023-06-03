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
       
        Grafo grafo= new Pruebas().leer_txt();
        System.out.println(grafo.printGrafo());
        System.out.println(grafo.printAdy());
    //    grafo.amplitud();
        System.out.println("");
        System.out.println(grafo.islas_ReamplitudBfs());
       // int is = grafo.islas_ReprofunDfs(grafo, 0,new boolean[grafo.getNumVerts()]);
     //   System.out.println(is+"<");
      System.out.println("");
        int num = grafo.islas_ReprofunDfs(grafo);
        System.out.println(num);
        
        
    }
    
}
