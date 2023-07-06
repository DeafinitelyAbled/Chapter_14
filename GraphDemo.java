
import java.util.List;

public class GraphDemo {
    public static void main(String[] args) {
        Graph graph1 = new Graph();

        Vertex vertexA = graph1.addVertex("New York City, NY");
        Vertex vertexB = graph1.addVertex("Seattle, WA");
        Vertex vertexC = graph1.addVertex("Miami, FL");
        Vertex vertexD = graph1.addVertex("San-Francisco, CA");
        graph1.addUndirectedEdge(vertexA, vertexB, 2852);
        graph1.addUndirectedEdge(vertexA, vertexC, 1283);
        graph1.addUndirectedEdge(vertexA, vertexD, 2901);
        graph1.addUndirectedEdge(vertexB, vertexC, 3297);
        graph1.addUndirectedEdge(vertexB, vertexD, 809);
        graph1.addUndirectedEdge(vertexC, vertexD, 3046);

        // Show the graph's vertices and edges
        for (Vertex vertex : graph1.getVertices()) {
            System.out.println("Location: " + vertex.label);

            System.out.printf("  Drive from %s:%n", vertex.label);
            for (Edge outgoingEdge : graph1.getEdgesFrom(vertex)) {
                System.out.printf(
                        "   - %s to %s, %d miles%n",
                        vertex.label,
                        outgoingEdge.toVertex.label,
                        (int)outgoingEdge.weight);
            }

            System.out.printf("  Drive to %s:%n", vertex.label);
            for (Edge incomingEdge : graph1.getEdgesTo(vertex)) {
                System.out.printf(
                        "   - %s to %s, %d miles%n",
                        incomingEdge.fromVertex.label,
                        vertex.label,
                        (int)incomingEdge.weight);
            }
        }
    }
}
