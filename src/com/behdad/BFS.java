package com.behdad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BFS {

    private Queue<String> queue;
    private List<String> discoveredWebLists;

    public BFS(){
        this.queue = new LinkedList<String>();
        this.discoveredWebLists = new ArrayList<String>();
    }

    public void discoverWeb(String root){

        this.queue.add(root);
        this.discoveredWebLists.add(root);

        while (!queue.isEmpty()){

            String v = this.queue.remove();
            try {
                String rawHtml = readURL(v);
                String regEx = "https://(\\w+\\.)*(\\w+)";
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(rawHtml);

                while (matcher.find()){

                    String w = matcher.group();
                    if (!discoveredWebLists.contains(w)){

                        discoveredWebLists.add(w);
                        queue.add(w);

                        System.out.println("sites found url: " + w);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String readURL(String v) throws IOException {
        String rawHtml = "";

        URL url = new URL(v);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

        String inputLine = "";

        while ((inputLine=bufferedReader.readLine())!= null){
            rawHtml+=inputLine;
        }
        bufferedReader.close();

        return rawHtml;

    }

}
