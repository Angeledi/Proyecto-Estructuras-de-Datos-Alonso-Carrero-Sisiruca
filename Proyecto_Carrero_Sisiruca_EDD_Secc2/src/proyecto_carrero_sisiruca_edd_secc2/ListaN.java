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
public class ListaN {
    private NodoN head;
    private int length;
    
    public ListaN(){
        this.head = null;
        this.length = 0;
    }

    public NodoN getHead() {
        return head;
    }

    public void setHead(NodoN head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    public boolean isEmpty(){
        return head == null;
    }

    public void insertFinal(NodoN nodito) {

        if (isEmpty()) {
            setHead(nodito);
        } else {
            NodoN pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = (NodoN) pointer.getNext();
            }
            pointer.setNext(nodito);
        }
        length++;
    }
    public void printListaN(){
        NodoN pointer = getHead();
        if (isEmpty()) {
            System.out.println("ListN is Empty");
        } else{
            while (pointer != null){
                System.out.print("["+pointer.getElement()+"]");
                pointer = (NodoN) pointer.getNext();
            }
        }
    }
    public String listNToString() {
        String print = "";
        NodoN pointer = getHead();
        for (int i = 0; i < getLength(); i++) {
            print += pointer.getElement() + "\n";
            pointer = (NodoN) pointer.getNext();
        }
        return print;
    }
    
}

