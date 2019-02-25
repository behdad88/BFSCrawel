package com.behdad;

public class Main {

    public static void main(String[] args) {

        String root = "http://www.inkarnet.com";
        BFS bfs = new BFS();
        bfs.discoverWeb(root);
    }
}
