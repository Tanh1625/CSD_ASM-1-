/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Graph;

/**
 *
 * @author ACER
 */
public class CSDslot9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Graph graph = new Graph();

             
        graph.addVertex("0");
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");
        graph.addVertex("7");
        graph.addVertex("8");
        
        graph.addEdgeDirection("8", "2", 2);
        graph.addEdgeDirection("8", "6", 6);
        graph.addEdgeDirection("8", "7", 7);
        graph.addEdgeDirection("2", "1", 8);
        graph.addEdgeDirection("2", "3", 7);
        graph.addEdgeDirection("2", "5", 4);
        graph.addEdgeDirection("5", "6", 2);
        graph.addEdgeDirection("5", "3", 14);
        graph.addEdgeDirection("5", "4", 10);
        graph.addEdgeDirection("6", "7", 1);
        graph.addEdgeDirection("7", "1", 11);
        graph.addEdgeDirection("7", "0", 8);
        graph.addEdgeDirection("1", "0", 4);
        graph.addEdgeDirection("3", "4", 9);
        
        graph.primJanik(graph, "8").display();

    }

}
