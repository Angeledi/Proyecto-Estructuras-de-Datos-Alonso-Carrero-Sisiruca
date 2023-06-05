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
    
    public int returnUsuariobyname(String name) {
        int count = 0;
        Usuario pointer = getList().getUhead();
        if (!isEmpty()) {
            while (pointer != null) {
                if (name.equals(pointer.getName())) {
                    return count;
                }
                pointer = pointer.getNext();
                count++;
            }
        }
        return -1;
    }
    
    public int returnUsuariobynum(int num) {
        int count = 0;
        Usuario pointer = getList().getUhead();
        if (!isEmpty()) {
            while (pointer != null) {
                if (num == pointer.getU_num() ) {
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
            print += pointer_a.getName() + " adyancente a: ";
            for (int j = 0; j < getNumVerts(); j++) {
                if (getMatAd()[i][j] != 0) {
                    print += pointer_b.getName() + " " + getMatAd()[i][j] + "<-->";

                }
                if (j == getNumVerts() - 1) {
                    print += ".";
                }
                pointer_b = pointer_b.getNext();

            }
            print += "\n";
            pointer_a = pointer_a.getNext();
            pointer_b = getList().getUhead();
        }
        return print;
    
    }

    public void newArco(int a, int b, int peso) {

        getMatAd()[a][b] = peso;
        getMatAd()[b][a] = peso;

    }
    public void AddArcobynums(int num1, int num2, int peso){
        int a = returnUsuariobynum(num1);
        int b = returnUsuariobynum(num2);
        getMatAd()[a][b] = peso;
        getMatAd()[b][a] = peso;
        
    }
    
    public int islas_ReamplitudBfs() {
        int count = 0;
        Cola cola = new Cola ();
        boolean visitados [ ] = new boolean [getNumVerts()];
        int vertice; //vértice actual
        //Se inicializa el vector visitados [] a false
        for (int i = 0; i < getNumVerts() ; i++)
            visitados [i] = false;
        //El recorrido en amplitud se inicia en cada vértice no visitado
        for (int i = 0; i < getNumVerts() ; i++) {
        //se pone en la cola el vértide de partida y se marca como visitado
            if (!visitados [i]){
                cola.encolar(i);
                visitados [i] = true;
                while (!cola.isEmpty()) {
                    vertice = cola.dispatch(); //desencolar y tratar el vértice
                    //y encolo los nodos adyacentes a v.
                    for (int j = 0; j < getNumVerts() ; j++){
                        if ((vertice !=j) && getMatAd()[vertice][j]!=0 && (!visitados [j])) {
                            cola.encolar ( j );
                            visitados [j] = true;
                            count++;
                        }
                    }
                }
            }
        }
        return getNumVerts()- count;
    }
    
    public void imprimirTabla () {
        System.out.println ("La matriz contiene " + numVerts + " vértices: \n");
        for (int i = 0; i < numVerts; i++) {
            for (int j = 0; j < numVerts; j++) {
             //   if (matAd[i][j])
                    System.out.print ("1 ");
             //   else System.out.print ("0 ");
    
            }
        }
    }
    
    //procedimiento recursivo
    public void recorrerProfundidad (Grafo g, int v, boolean [ ] visitados) {
        //se marca el vértice v como visitado
        visitados [v] = true;
        for (int i = 0; i < numVerts; i++) {
            if (v != i && !visitados [i] && g.getMatAd()[v][i] != 0 ){
                recorrerProfundidad (g, i, visitados);}
        }
    }
    
   // procedimiento no recursivo
    public int islas_ReprofunDfs (Grafo g) {
        int count= 0;
        boolean visitados [ ] = new boolean [g.getNumVerts()];
        for (int i = 0; i < g.getNumVerts(); i++) //inicializar vector con campos false
            visitados [i] = false;
        for (int i = 0; i < g.getNumVerts(); i++) { //Relanza el recorrido en cada
            if (!visitados [i]) {//vértice visitado
                recorrerProfundidad (g, i, visitados);
                count++;
            }
        }
        return count;
    }
    
    public ListaN identifyPuentes(Grafo g){
        ListaN listaPuentes = new ListaN();
        String print;
        Grafo aux = new Grafo(g.getList());
        aux.setMatAd(g.getMatAd());
        Usuario pointer_a = aux.getList().getUhead();
        Usuario pointer_b = aux.getList().getUhead();
        int numislas = islas_ReprofunDfs(g);
        
        for (int i = 0; i < aux.getNumVerts(); i++) {
            print = pointer_a.getName() + "<-->";
            for (int j = 0; j < aux.getNumVerts(); j++) {
                int peso = aux.getMatAd()[i][j];
             
                aux.newArco(i, j, 0);
                int numislasaux = islas_ReprofunDfs(aux);
                if (numislasaux > numislas) {
                    print += pointer_b.getName() + "cuyo peso es: " + peso;
                    NodoN nodostr = new NodoN(print);
                    listaPuentes.insertFinal(nodostr);
                    System.out.println(nodostr.getElement());
                }
                aux.newArco(i, j, peso);
                pointer_b = pointer_b.getNext();

            }
            pointer_a = pointer_a.getNext();
            pointer_b = aux.getList().getUhead();
        }
        return listaPuentes;
    }
    
}