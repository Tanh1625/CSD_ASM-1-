/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author vungu
 */
public class Graph {

    Set<Vertex> vertices;

    public Graph() {
        this.vertices = new HashSet<>();
    }

    public Vertex addVertex(String v) {
        Vertex newV = new Vertex(v);
        this.vertices.add(newV);
        return newV;
    }

    public Vertex getVertex(String v) {
        for (Vertex vertex : vertices) {
            if (vertex.lable.equals(v)) {
                return vertex;
            }
        }
        return null;
    }

    public void addEdge(String u, String v, int weight) {
        Vertex vertexU = this.getVertex(u);
        Vertex vertexV = this.getVertex(v);
        if (vertexU == null) {
            vertexU = this.addVertex(u);
        }
        if (vertexV == null) {
            vertexV = this.addVertex(v);
        }
        vertexU.adjList.put(vertexV, weight);
    }
    
    public void removeEdge(String u, String v, int weight) {
        Vertex vertexU = this.getVertex(u);
        Vertex vertexV = this.getVertex(v);
        if (vertexU == null) {
            return;
        }
        if (vertexV == null) {
            return;
        }
        vertexU.adjList.remove(vertexV);
        vertexV.adjList.remove(vertexU);
    }
    

    public void addEdgeDirection(String u, String v, int weight) {
//        Vertex vertexU = this.getVertex(u);
//        Vertex vertexV = this.getVertex(v);
//        if (vertexU == null) {
//            return;
//        }
//        if (vertexV == null) {
//            this.vertices.add(new Vertex(v));
//        }
//        vertexU.adjList.put(vertexV, weight);
//        vertexV.adjList.put(vertexU, weight);
        addEdge(u, v, weight);
        addEdge(v, u, weight);
    }

    public void display() {
        this.vertices.stream().forEach(Vertex
                -> {
            System.out.print(Vertex.lable + " -> ");
            Vertex.adjList.entrySet().forEach(entry -> System.out.print("(" + entry.getKey().lable + ", " + entry.getValue() + ")"));
            System.out.println();
        }
        );
    }

//    public void bfs(String startLabel){
//        Vertex startNode = this.getVertex(startLabel);
//        if (startNode == null) {
//            System.out.println("Start vertex not found");
//            return;
//        }
//
//        ArrayQueue<Vertex> queue = new ArrayQueue<>(1000);
//        Set<Vertex> visited = new HashSet<>();
//
//        queue.enqueue(startNode);
//        visited.add(startNode);
//
//        while(!queue.isEmpty()){
//            Vertex current = queue.dequeue();
//            System.out.print(current.lable + " ");
//
//            for(Map.Entry<Vertex, Integer> neighborEntry : current.adjList.entrySet()){
//                Vertex neighbor = neighborEntry.getKey();
//                if(!visited.contains(neighbor)){
//                    queue.enqueue(neighbor);
//                    visited.add(neighbor);
//                }
//            }
//        }
//    }
    public void bfs(String startLabel) {
        Vertex startNode = this.getVertex(startLabel);
        if (startNode == null) {
            System.out.println("Start vertex not found");
            return;
        }

        ArrayQueue<Vertex> queue = new ArrayQueue<>(1000);
        Set<Vertex> visited = new HashSet<>();

        queue.enqueue(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            Vertex current = queue.dequeue();
            System.out.print(current.lable + " ");

            current.adjList.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey((v1, v2) -> v1.lable.compareTo(v2.lable)))
                    .forEach(entry -> {
                        Vertex neighbor = entry.getKey();
                        if (!visited.contains(neighbor)) {
                            queue.enqueue(neighbor);
                            visited.add(neighbor);
                        }
                    });
        }
        System.out.println();
    }

    public void dfs(String startLabel) {
        Vertex startNode = this.getVertex(startLabel);
        if (startNode == null) {
            System.out.println("Start vertex not found");
            return;
        }

        ArrayStack<Vertex> stack = new ArrayStack<>(1000);
        Set<Vertex> visited = new HashSet<>();

        stack.push(startNode);

        while (!stack.isEmpty()) {
            Vertex current = stack.pop();
            if (!visited.contains(current)) {
                System.out.print(current.lable + " ");
                visited.add(current);

                // Add neighbors to stack in sorted order
                current.adjList.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey((v1, v2) -> v2.lable.compareTo(v1.lable))) // reverse order for stack
                        .forEach(entry -> stack.push(entry.getKey()));
            }
        }
        System.out.println();
    }

    public void Dijkstra(String start, String destination) {
        HashMap<Vertex, Integer> distance = new HashMap<>();
        this.vertices.stream().forEach(Vertex -> distance.put(Vertex, Integer.MAX_VALUE));
        HashMap<Vertex, Vertex> previous = new HashMap<>();
        ArrayQueue<Vertex> queue = new ArrayQueue<>(1000);
        ArrayList<Vertex> vistited = new ArrayList<>();
        Vertex startVertext = this.getVertex(start);
        queue.enqueue(startVertext);
        distance.put(startVertext, 0);
        previous.put(startVertext, startVertext);
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.dequeue();
            //distance.entrySet().stream().forEach(entry -> System.out.println("(" + entry.getKey().lable + ", " + entry.getValue() + ")")); 
            if (!vistited.contains(currentVertex)) {
                currentVertex.adjList.entrySet().stream().forEach(entry -> {
                    int totalDistance = distance.get(entry.getKey()) + entry.getValue();
                    if (totalDistance < distance.get(currentVertex)) {
                        distance.put(entry.getKey(), totalDistance);
                        previous.put(entry.getKey(), currentVertex);
                    }
                    if (!vistited.contains(entry.getKey())) {
                        queue.enqueue(entry.getKey());
                    }
                });
            }
            vistited.add(currentVertex);
        }
        Vertex destinationVertex = this.getVertex(destination);
        ArrayList<Vertex> path = this.getPath(previous, startVertext, destinationVertex);
        String p = path.stream().map(vertex -> vertex.lable).collect(Collectors.joining(" -> "));
        System.out.println(p);
    }

    private ArrayList getPath(HashMap<Vertex, Vertex> previous, Vertex startVertex, Vertex destinationVertex) {
        ArrayList<Vertex> path = new ArrayList<>();
        path.add(destinationVertex);
        while(previous.get(destinationVertex) != startVertex){
            path.add(previous.get(destinationVertex));
            destinationVertex = previous.get(destinationVertex);
        }
        path.add(startVertex);
        Collections.reverse(path);
        return path;
    }
    
//     private List<Vertex> getPath(HashMap<Vertex, Vertex> previous, Vertex startVertex, Vertex destinationVertex) {
//        List<Vertex> path = new LinkedList<>();
//        for (Vertex at = destinationVertex; at != null; at = previous.get(at)) {
//            path.add(at);
//            if (at.equals(startVertex)) {
//                Collections.reverse(path);
//                return path;
//            }
//        }
//        return null;
//    }
    
    
    public Graph primJanik(Graph g, String start){
        Graph mst = new Graph();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparing(Edge::getWeight));
        List<Vertex> visited = new ArrayList<>();
        Vertex startVertex = g.getVertex(start);
        visited.add(startVertex);
        startVertex.adjList.forEach((adjVertex, weight) -> priorityQueue.add(new Edge(startVertex, adjVertex, weight)));
        while(!priorityQueue.isEmpty()){
            Edge minEdge = priorityQueue.poll();
            if(!visited.contains(minEdge.to)){
                mst.addEdgeDirection(minEdge.from.lable, minEdge.to.lable, minEdge.weight);
                minEdge.to.adjList.forEach((adjVertex, weight) -> priorityQueue.add(new Edge(minEdge.to, adjVertex, weight)));
            }
            visited.add(minEdge.to);
        }
        return mst;
    }
    
    public List<String> getEulerianPathStartingVertices (Graph graph){
        List<String> startingVertices = new ArrayList<>();
        List<String> startVerticePath = new ArrayList<>();
        
        int oddDegreeCount = 0;
        
        for(Vertex vertex: graph.vertices){
            startingVertices.add(vertex.lable);
            if(vertex.adjList.size() % 2 != 0){
                oddDegreeCount++;
                startVerticePath.add(vertex.lable);
            }
        }
        
        if(oddDegreeCount == 0){
            System.out.println("CIRCLE");
            return startingVertices;
        }else if(oddDegreeCount == 2){
            System.out.println("PATH");
            return startVerticePath;
        }else{
            return new ArrayList<>(); // empty list if no Eulerian path
        }
    }

}
