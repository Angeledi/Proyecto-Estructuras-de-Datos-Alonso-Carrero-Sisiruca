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
public class Lista {
    private Usuario uhead;
    private int size;
    
    public Lista(){
        this.uhead = null;
        this.size =0;
    
    }

    public Usuario getUhead() {
        return uhead;
    }
   

    public void setUhead(Usuario uhead) {
        this.uhead = uhead;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        return uhead == null;
    }

    public Usuario InsertFinal(String name, int number) {

        Usuario u_nuevo = new Usuario(name, number);
        if (isEmpty()) {
            setUhead(u_nuevo);
        } else {
            Usuario pointer = getUhead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(u_nuevo);
        }
        size++;
        return u_nuevo;
    }
    
}
