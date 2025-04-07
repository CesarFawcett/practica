import java.util.HashMap;
import java.util.List;
import java.util.Map;
//sistema de recomendacion, aplicaremos grafos y hashMap
public class GrafoRecomendacion {
    private Map<Integer, List<Integer>> grafo; // Lista adyacencia
    private Map<Integer, Double> pageRank;     // Puntuacion PageRank

    public GrafoRecomendacion() {
        grafo = new HashMap<>();
        pageRank = new HashMap<>();
    }
}