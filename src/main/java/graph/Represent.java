package graph;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Represent {

    private BufferedReader br;
    private String line;
    private StringTokenizer st;
    private String token;

    public Represent () {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Puts input from standard in into a nested arraylist
     * All methods take a nested arraylist as input as its easier to create tests
     */
    public void initialize() {
        int v = getInt();
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        for(int i = 0; i < v; i ++) {
            input.add(new ArrayList<Integer>());
            for (int j = 0; j < getInt(); j++) {
                input.get(i).add(getInt());
            }
        }
    }

    /**
     *
     * Multidimensional array where each vertex is represented as a row
     * Each neighbouring vertex is represented as a column in its respective row
     *
     * Vertices 1,2,3 that can all reach each other
     * [
     *  [0,1,1],
     *  [1,0,1],
     *  [1,1,0]
     * ]
     */
    public int[][] adjacencyMatrix(int v, ArrayList<ArrayList<Integer>> input) {
        int[][] matrix = new int[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < input.get(i).get(0); j++) {
                matrix[i][input.get(i).get(j+1)] = 1;
            }
        }
        return matrix;
    }

    /**
     *  The outer ArrayList represents the vertices
     *  The inner ArrayList represents each vertices' neighbouring vertices
     */
    public ArrayList<ArrayList<Integer>> adjacencyList(int v, ArrayList<ArrayList<Integer>> input) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adjacencyList.add(new ArrayList<Integer>());
            for (int j = 0; j < input.get(i).get(0); j++) {
                adjacencyList.get(i).add(input.get(i).get(j+1));
            }
        }
        return adjacencyList;
    }

    /**
     *
     * ArrayList with a bunch of edges represented as [vertex, neighbour]
     */
    public ArrayList<int[]> edgeList(int v, ArrayList<ArrayList<Integer>> input) {
        ArrayList<int[]> edgeList = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < input.get(i).get(0); j++) {
                edgeList.add(new int[]{i, input.get(i).get(j+1)});
            }
        }
        return edgeList;
    }



    public String getWord() {
        return nextToken();
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}

