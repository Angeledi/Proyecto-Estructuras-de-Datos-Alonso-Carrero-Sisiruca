/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_carrero_sisiruca_edd_secc2;

/**
 *
 * @author acarr
 */
public class NodoN {
    private Object element;
    private NodoN next;
    
    public NodoN(Object element){
        this.element = element;
        this.next = null;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public NodoN getNext() {
        return next;
    }

    public void setNext(NodoN next) {
        this.next = next;
    }
    
    
    
}
