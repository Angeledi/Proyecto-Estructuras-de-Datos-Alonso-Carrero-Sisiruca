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
public class Cola {
    private Nodo head;
    private Nodo tail;
    private int length;
    
    public Cola(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public Nodo getTail() {
        return tail;
    }

    public void setTail(Nodo tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
            
    public void encolar(int number) {
        Nodo nodito = new Nodo(number);
        if (isEmpty()) {
            setTail(nodito);
            setHead(nodito);
        } else{
            Nodo pointer = getTail();
            pointer.setNext(nodito);
            setTail(nodito);
        }
        length++;
    }

    public void decolear() {
        if(!isEmpty()) {
            Nodo pointer = getHead();
            setHead((Nodo) pointer.getNext());
            pointer.setNext(null);
            if (getHead() == null) {
                setTail(null);
            }
            length--;
        }
    }

    public int dispatch() {
        if(!isEmpty()) {
            Nodo pointer = getHead();
            setHead((Nodo) pointer.getNext());
            pointer.setNext(null);
            if (getHead() == null) {
                setTail(null);
            }
            length--;
            return pointer.getElement();
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return getHead() == null && getTail() == null;
    }

    public void showcola() {
        Nodo pointer = getHead();
        while (pointer != null) {
            System.out.print("["+pointer.getElement()+"]");
            pointer = (Nodo) pointer.getNext();
        }
    }
    
    
}
