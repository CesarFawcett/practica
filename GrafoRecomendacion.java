import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GrafoRecomendacion {
    private Map<Integer, List<Integer>> grafo;
    private Map<Integer, Double> pageRank;
    private Set<Integer> todosNodos; 

    public GrafoRecomendacion() {
        grafo = new HashMap<>();
        pageRank = new HashMap<>();
        todosNodos = new HashSet<>();
    }

    public void agregarArista(int origen, int destino) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.get(origen).add(destino);
        todosNodos.add(origen);  // origen
        todosNodos.add(destino); // destino
    }

    public void calcularPageRank(int iteraciones) {
        // Inicializar 
        double inicialRank = 1.0 / todosNodos.size();
        for (int nodo : todosNodos) {
            pageRank.put(nodo, inicialRank);
        }

        // actualizar ranks
        for (int i = 0; i < iteraciones; i++) {
            Map<Integer, Double> nuevoRank = new HashMap<>();
            for (int nodo : todosNodos) {
                double sum = 0.0;
                for (int vecino : grafo.keySet()) {
                    if (grafo.get(vecino).contains(nodo)) {
                        sum += pageRank.get(vecino) / grafo.get(vecino).size();
                    }
                }
                nuevoRank.put(nodo, 0.15 / todosNodos.size() + 0.85 * sum);
            }
            pageRank = nuevoRank;
        }
    }

    public List<Integer> recomendarProductos(int usuario, int cantidad) {
        List<Integer> productos = grafo.get(usuario);
        if (productos == null) return new ArrayList<>();

        // productos por PageRank 
        productos.sort((a, b) -> Double.compare(pageRank.get(b), pageRank.get(a)));
        return productos.subList(0, Math.min(cantidad, productos.size()));
    }

    public static void main(String[] args) {
        GrafoRecomendacion sistema = new GrafoRecomendacion();
        sistema.agregarArista(1, 101);
        sistema.agregarArista(1, 102);
        sistema.agregarArista(2, 101);
        sistema.agregarArista(2, 103);
        sistema.agregarArista(3, 104);
        sistema.agregarArista(3, 101);
        sistema.calcularPageRank(10);
        List<Integer> recomendaciones = sistema.recomendarProductos(1, 2);
        System.out.println("Recomendaciones para el usuario 1: " + recomendaciones);
    }
}