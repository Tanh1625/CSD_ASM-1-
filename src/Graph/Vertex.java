/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author vungu
 */
public class Vertex {
    String lable;
    HashMap<Vertex, Integer> adjList;

    public Vertex(String lable) {
        this.lable = lable;
        this.adjList = new HashMap<>();
    }
    
}

