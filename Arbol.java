class NodoArbol {
    int valor;
    NodoArbol izquierda, derecha;

    public NodoArbol(int item) {
        valor = item;
        izquierda = derecha = null;
    }
}
//arbol binario
public class Arbol {
    public static void main(String[] args) {
        NodoArbol raiz = new NodoArbol(10);
        raiz.izquierda = new NodoArbol(5);
        raiz.derecha = new NodoArbol(15);
        System.out.println("Raíz: " + raiz.izquierda.valor); 
        System.out.println("Raíz: " + raiz.derecha.valor); 
        System.out.println("Raíz: " + raiz.valor);
    }
}
