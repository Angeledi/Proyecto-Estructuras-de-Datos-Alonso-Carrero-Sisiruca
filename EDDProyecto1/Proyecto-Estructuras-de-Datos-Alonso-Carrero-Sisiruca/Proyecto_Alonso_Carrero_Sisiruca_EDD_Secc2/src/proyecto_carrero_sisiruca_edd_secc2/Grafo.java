/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_carrero_sisiruca_edd_secc2;

/**
 *
 * @author Angel Carrero y  Augusto Sisiruca
 */
public class Grafo {
    private int numVerts;
    private Lista list;
    private int[][] matAd;
    
    
    public Grafo(Lista lista) {
        numVerts = lista.getSize();
        matAd = new int[numVerts][numVerts];
        list = lista;
        for (int i = 0; i < numVerts; i++) {
            for (int j = 0; i < numVerts; i++) {
                matAd[i][j] = 0;
            }
        }

    }

    public int getNumVerts() {
        return numVerts;
    }

    public void setNumVerts(int numVerts) {
        this.numVerts = numVerts;
    }

    public Lista getList() {
        return list;
    }

    public void setList(Lista list) {
        this.list = list;
    }

    public int[][] getMatAd() {
        return matAd;
    }

    public void setMatAd(int[][] matAd) {
        this.matAd = matAd;
    }
    public boolean isEmpty() {
        return list.getUhead()== null;
    }
    
    public void RecorridoBFS(){
        
    }
    
    public Usuario returnUsuario(int number) {
        
        Usuario pointer = getList().getUhead();
        for (int i = 0; i < number; i++) {
            pointer = pointer.getNext();
        }

        return pointer;
    }
    
    public int returnUsuariobynum(int num) {
        int count = 0;
        Usuario pointer = getList().getUhead();
        if (!isEmpty()) {
            while (pointer != null) {
                if (num == pointer.getU_num()) {
                    return count;
                }
                pointer = pointer.getNext();
                count++;
            }
        }
        return -1;
    }
    
    public void InsertarVertice(String name, int number) {
        Usuario n_usuario = new Usuario(name, number);

        if (isEmpty()) {
            getList().setUhead(n_usuario);
        } else {
            n_usuario.setNext(getList().getUhead());
            getList().setUhead(n_usuario);
        }

        numVerts++;

    }
    
    public void aumentarVerticesInsertar(String name,  int number) {
        Usuario n_usuario = new Usuario(name, number);
        Usuario pointer = getList().getUhead();
        if (isEmpty()) {
            getList().setUhead(n_usuario);
        } else {
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(n_usuario);
        }

        int Matrizaux[][] = getMatAd();
        int Matrizaux2[][] = new int[getNumVerts() + 1][getNumVerts() + 1];
        //crea una nueva matriz con 1 espacio más para insertar en ella todo lo que ya estaba en la anterior, y procede a insertar el nuevo elemento

        for (int i = 0; i < getNumVerts(); i++) {
            for (int j = 0; j < getNumVerts(); j++) {
                Matrizaux2[i][j] = Matrizaux[i][j];
            }
        }
        setMatAd(Matrizaux2);
        getList().setSize(getList().getSize() + 1);
        numVerts++;

    }
    public String printGrafo() {
        String print = "";
        Usuario pointer_a = getList().getUhead();
        Usuario pointer_b = getList().getUhead();
        for (int i = 0; i < getNumVerts(); i++) {

            for (int j = 0; j < getNumVerts(); j++) {
                if (getMatAd()[i][j] != 0) {
                    print += pointer_a.getName() + "," + pointer_b.getName() + "," + getMatAd()[i][j] + "\n";
                }
                pointer_b = pointer_b.getNext();
            }
            pointer_a = pointer_a.getNext();
            pointer_b = getList().getUhead();
        }
        return print;
    }
//print con los nombres de los almacenes y sus adyacencias (A puede ir a tal y a tal, B puede ir a tal y tal etc)
    public String printAdy() {
        String print = "";
        Usuario pointer_a = getList().getUhead();
        Usuario pointer_b = getList().getUhead();
        for (int i = 0; i < getNumVerts(); i++) {
            print += pointer_a.getName() + "<-->";
            for (int j = 0; j < getNumVerts(); j++) {
                if (getMatAd()[i][j] != 0) {
                    print += pointer_b.getName() + " " + getMatAd()[i][j] + "<-->";

                }
                if (j == getNumVerts() - 1) {
                    print += "//";
                }
                pointer_b = pointer_b.getNext();

            }
            print += "\n";
            pointer_a = pointer_a.getNext();
            pointer_b = getList().getUhead();
        }
        return print;
    }

    public void AddArco(int a, int b, int peso) {

        getMatAd()[a][b] = peso;
        getMatAd()[b][a] = peso;

    }
    
}