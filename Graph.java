
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Graph {
    private HashMap<Vertex, ArrayList<Edge>> fromEdges;
    private HashMap<Vertex, ArrayList<Edge>> toEdges;

    public Graph() {
        fromEdges = new HashMap<Vertex, ArrayList<Edge>>();
        toEdges = new HashMap<Vertex, ArrayList<Edge>>();
    }

    public Vertex addVertex(String newVertexLabel) {
        Vertex newVertex = new Vertex(newVertexLabel);

        fromEdges.put(newVertex, new ArrayList<Edge>());
        toEdges.put(newVertex, new ArrayList<Edge>());

        return newVertex;
    }

    public Edge addDirectedEdge(Vertex fromVertex, Vertex toVertex) {
        return addDirectedEdge(fromVertex, toVertex, 1.0);
    }

    public Edge addDirectedEdge(Vertex fromVertex, Vertex toVertex, double weight) {
        if (hasEdge(fromVertex, toVertex)) {
            return null;
        }

        Edge newEdge = new Edge(fromVertex, toVertex, weight);

        fromEdges.get(fromVertex).add(newEdge);
        toEdges.get(toVertex).add(newEdge);

        return newEdge;
    }

    public Edge[] addUndirectedEdge(Vertex vertexA, Vertex vertexB) {
        return addUndirectedEdge(vertexA, vertexB, 1.0);
    }

    public Edge[] addUndirectedEdge(Vertex vertexA, Vertex vertexB, double weight) {
        Edge edge1 = addDirectedEdge(vertexA, vertexB, weight);
        Edge edge2 = addDirectedEdge(vertexB, vertexA, weight);
        Edge[] result = { edge1, edge2 };
        return result;
    }

    public Collection<Edge> getEdges() {
        HashSet<Edge> edges = new HashSet<Edge>();
        for (ArrayList<Edge> edgeList : fromEdges.values()) {
            edges.addAll(edgeList);
        }
        return edges;
    }

    public Collection<Edge> getEdgesFrom(Vertex fromVertex) {
        return fromEdges.get(fromVertex);
    }

    public Collection<Edge> getEdgesTo(Vertex toVertex) {
        return toEdges.get(toVertex);
    }

    public Vertex getVertex(String vertexLabel) {
        for (Vertex vertex : getVertices()) {
            if (vertex.label.equals(vertexLabel)) {
                return vertex;
            }
        }
        return null;
    }

    public Collection<Vertex> getVertices() {
        return fromEdges.keySet();
    }

    public boolean hasEdge(Vertex fromVertex, Vertex toVertex) {
        if (!fromEdges.containsKey(fromVertex)) {

            return false;
        }

        ArrayList<Edge> edges = fromEdges.get(fromVertex);
        for (Edge edge : edges) {
            if (edge.toVertex == toVertex) {
                return true;
            }
        }

        return false;
    }
}
