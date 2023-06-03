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
    
//    public String recorridoBFS(){
//        int count = 0;
//        int aux = numVerts;
//        Cola cola= new Cola();
//        boolean visitados []= new boolean[getNumVerts()];
//        int v;
//        String print="";
//        //recorre el grafo
//        for (int i = 0; i < getNumVerts(); i++) {
//            if (!visitados[i]) {
//                //modifica la cola para meterle el primer nodo recorrido y algun otro que no tenga adyacencia con i
//                cola.encolar(i);
//                //marca como visitado el nodo recorrido
//                visitados[i]=true;
//                while (!cola.isEmpty()) {        
//                    //despacha los elementos para meterlos en el string y lo iguala a v para recorrer sus ady
//                    v=cola.dispatch();
//                   print+= returnUsuario(v).getName()+" "+returnUsuario(v).getU_num()+":\n";
//                    for (int j = 0; j < getNumVerts(); j++) {
//                        if (v!=j && getMatAd()[v][j]!=0 && !visitados[j]) {
//                            cola.encolar(j);
//                            visitados[j]=true;
//                            count++;
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(aux-count);
//        return print;     }
    
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
    
//    public int islas_ReprofunDfs(Grafo g, int v, boolean [ ] visitados){
//        int count = v;
//        visitados [v] = true;
//        System.out.println (v);
//        for (int i = 0; i < numVerts; i++) {
//            if (v != i && !visitados [i] && g.getMatAd()[v][i] != 0 ){
//                recorrerProfundidad (g, i, visitados);}
//                count++;
//        
//        }
//        return getNumVerts()- v;
//    }
    
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
        int count = 0;
        //se marca el vértice v como visitado
        visitados [v] = true;
        //el tratamiento del vértice consiste únicamente en imprimirlo en pantalla
        System.out.println (v);
        //se examinan los vértices adyacentes a v para continuar el recorrido
        for (int i = 0; i < numVerts; i++) {
            if (v != i && !visitados [i] && g.getMatAd()[v][i] != 0 ){
                recorrerProfundidad (g, i, visitados);}
                count++;
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
    
}
