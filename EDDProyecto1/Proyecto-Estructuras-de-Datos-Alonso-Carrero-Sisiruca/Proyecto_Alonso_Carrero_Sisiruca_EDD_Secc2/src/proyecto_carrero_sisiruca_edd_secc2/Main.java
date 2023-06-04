/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_carrero_sisiruca_edd_secc2;

/**
 *
 * @author Angel Carrero y Augusto Sisiruca
 */
public class Main {
    
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.setUhead(new Usuario("pepito", 56));
        lista.InsertFinal("@cosi", 24);
        Grafo grafo = new Grafo(lista);
        grafo.printGrafo();
        grafo.printAdy();
        Grafo grafo2= new Funciones().leerTxt();
        System.out.println(grafo2.printGrafo());
        System.out.println(grafo2.printAdy());
        
        
    }
}
