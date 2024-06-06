import java.util.*;
//fathan abdul aziz(607062300041)
class AdjacencyList {
    private Map<String, List<String>> adjList = new HashMap<>();  // Membuat peta untuk menyimpan daftar adjacency
    
    public void addEdge(String src, String dest) {
        // Menambahkan edge dari src ke dest
        adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
    }
    
    public List<String> getTetanggas(String node) {
        // Mengambil tetangga dari node yang diberikan
        return adjList.getOrDefault(node, new ArrayList<>());
    }
    
    public Set<String> getAllNodes() {
        // Mengambil semua node dalam graf
        return adjList.keySet();
    }
}

class BFS_peta {
    private AdjacencyList graph;  // Menyimpan referensi ke daftar adjacency
    
    public BFS_peta(AdjacencyList graph) {
        this.graph = graph;  // Menginisialisasi graf dari  Peta perancis
    }
    
    public void search(String startNode) {
        Set<String> visited = new HashSet<>();  // Menginisialisasi set untuk melacak node yang telah dikunjungi
        Queue<String> queue = new LinkedList<>();  // Menginisialisasi antrian untuk BFS_peta
        
        visited.add(startNode);  // Menambahkan node awal ke set yang telah dikunjungi
        queue.add(startNode);  // Menambahkan node awal ke antrian
        
        while (!queue.isEmpty()) {
            String node = queue.poll();  // Mengambil node dari antrian
            System.out.print(node + " ");  // Mencetak node
            
            for (String Tetangga : graph.getTetanggas(node)) {
                if (!visited.contains(Tetangga)) {
                    visited.add(Tetangga);  // Menandai tetangga
                    queue.add(Tetangga);  // Menambahkan tetangga
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList();
       
        BFS_peta bfs = new BFS_peta (adjacencyList);

        adjacencyList.addEdge("Paris(France)", "Brussels(Belgium)");
        adjacencyList.addEdge("Paris(France)", "Zurich(Switzerland)");
        
        adjacencyList.addEdge("Brussels(Belgium)", "Paris(France)");
        adjacencyList.addEdge("Brussels(Belgium)", "Amsterdam(Netherlands)");
        adjacencyList.addEdge("Brussels(Belgium)", "Zurich(Switzerland)");

        adjacencyList.addEdge("Zurich(Switzerland)", "Vienna(Austria)");
        adjacencyList.addEdge("Zurich(Switzerland)", "Paris(France)");
        adjacencyList.addEdge("Zurich(Switzerland)", "Prague(Republik Ceko)");
        adjacencyList.addEdge("Zurich(Switzerland)", "Brussels(Belgium)");
        
        adjacencyList.addEdge("Amsterdam(Netherlands)", "Brussels(Belgium)");
        adjacencyList.addEdge("Amsterdam(Netherlands)", "Hamburg(Jerman)");
        adjacencyList.addEdge("Amsterdam(Netherlands)", "Prague(Republik Ceko)");
        
        adjacencyList.addEdge("Vienna(Austria)", "Zurich(Switzerland)");
        adjacencyList.addEdge("Vienna(Austria)", "Prague(Republik Ceko)");
        adjacencyList.addEdge("Vienna(Austria)", "Budapest(Hungary)");

        adjacencyList.addEdge("Prague(Republik Ceko)", "Hamburg(Jerman)");
        adjacencyList.addEdge("Prague(Republik Ceko)", "Warsaw(Poland)");    
        adjacencyList.addEdge("Prague(Republik Ceko)", "Amsterdam(Netherlands)");
        adjacencyList.addEdge("Prague(Republik Ceko)", "Vienna(Austria)");
        adjacencyList.addEdge("Prague(Republik Ceko)", "Zurich(Switzerland)");

        adjacencyList.addEdge("Hamburg(Jerman)", "Warsaw(Poland)");
        adjacencyList.addEdge("Hamburg(Jerman)", "Prague(Republik Ceko)");
        adjacencyList.addEdge("Hamburg(Jerman)", "Amsterdam(Netherlands)");
        
        adjacencyList.addEdge("Warsaw(Poland)", "Hamburg(Jerman)");
        adjacencyList.addEdge("Warsaw(Poland)", "Prague(Republik Ceko)");
        adjacencyList.addEdge("Warsaw(Poland)", "Budapest(Hungary)");
        
        adjacencyList.addEdge("Budapest(Hungary)", "Warsaw(Poland)");
        adjacencyList.addEdge("Budapest(Hungary)", "Vienna(Austria)");

        bfs.search("Paris(France)");
        //maaf bu seharusnya urutan yang benar itu paris, brussels, zurich, amsterdam, vienna, orague, hamburg, warsaw, budapest
    }
}
