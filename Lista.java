import java.util.LinkedList;

public class Lista {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(2); 
        lista.addFirst(3); 
        lista.add(1); 
        lista.addFirst(4); 
        System.out.println(lista); 
    }
}
