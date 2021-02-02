package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Traverse {

    private ArrayList<Integer>[] adjacencyList;
    private LinkedList<Integer> queue;
    private ArrayList<Integer> dfsOrder;
    private ArrayList<Integer> bfsOrder;

    public Traverse(ArrayList<Integer>[] adjacencyList) {
        this.adjacencyList = adjacencyList;
        queue = new LinkedList<>();
        dfsOrder = new ArrayList<>();
        bfsOrder = new ArrayList<>();
    }

    /**
     * Depth first search on an adjacency list
     *
     */
    public void dfs(int startNode) {
        dfsRecursive(new boolean[adjacencyList.length], startNode);
    }

    public void dfsRecursive(boolean[] visited, int vertex) {
        if (!visited[vertex]) {
            System.out.print(vertex + " ");
            dfsOrder.add(vertex);
            visited[vertex] = true;
            for(int neighbour : adjacencyList[vertex]) {
                dfsRecursive(visited, neighbour);
            }
        }
    }

    /**
     * Breadth first search on adjacency list
     *
     */
    public void bfs(int startNode) {
        //bfsRecursive(new boolean[adjacencyList.length], startNode);
        bfsNonRecursive(new boolean[adjacencyList.length], startNode);
    }

    public void bfsNonRecursive(boolean[] visited, int startNode) {
        visited[startNode] = true;
        queue.add(startNode);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            bfsOrder.add(node);
            for (int neighbour : adjacencyList[node]) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }

    public void bfsRecursive(boolean[] visited, int vertex) {
        visited[vertex] = true;
        for(int v : adjacencyList[vertex]) {
            if (!visited[v]) {
                queue.addLast(v);
                visited[v] = true;
            }
        }
        bfsOrder.add(vertex);
        if(!queue.isEmpty()) {
            bfsRecursive(visited, queue.pop());
        }
    }

    public ArrayList<Integer> getDfsOrder() {
        return dfsOrder;
    }

    public ArrayList<Integer> getBfsOrder() {
        return bfsOrder;
    }
}
