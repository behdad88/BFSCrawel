package com.behdad;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String url;
    private boolean visited;
    private List<Vertex> adjacencyLists;

    public Vertex(String url) {
        this.url = url;
        this.adjacencyLists = new ArrayList<Vertex>();
    }

    public void addNeighbour(Vertex vertex){
        this.adjacencyLists.add(vertex);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getAdjacencyLists() {
        return adjacencyLists;
    }

    @Override
    public String toString() {
        return " " + url;
    }
}
