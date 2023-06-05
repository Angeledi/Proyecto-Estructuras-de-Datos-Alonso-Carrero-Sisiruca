/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_carrero_sisiruca_edd_secc2;

/**
 *
 * @author Angel Carrero y Augusto Sisiruca
 */

public class Usuario {
    private String name;
    private int u_num;
    private Usuario next;
    
    
    public Usuario(String name, int u_num){
        this.name = name;
        this.u_num = u_num;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getU_num() {
        return u_num;
    }

    public void setU_num(int u_num) {
        this.u_num = u_num;
    }

    public Usuario getNext() {
        return next;
    }

    public void setNext(Usuario next) {
        this.next = next;
    }
    
      
}
