package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TraverseTest {

    int numberOfVertices;
    Represent represent;
    ArrayList<Integer>[] adjacencyList;
    ArrayList<Integer>[] adjacencyList2;

    @BeforeEach
    void setup() {
        adjacencyList = new ArrayList[5];
        adjacencyList[0] = new ArrayList<Integer>( Arrays.asList(1, 2));
        adjacencyList[1] = new ArrayList<Integer>( Arrays.asList(0, 2));
        adjacencyList[2] = new ArrayList<Integer>( Arrays.asList(0));
        adjacencyList[3] = new ArrayList<Integer>( Arrays.asList(4));
        adjacencyList[4] = new ArrayList<Integer>( Arrays.asList(3));

        adjacencyList2 = new ArrayList[7];
        adjacencyList2[0] = new ArrayList<Integer>( Arrays.asList(1, 2));
        adjacencyList2[1] = new ArrayList<Integer>( Arrays.asList(3, 4));
        adjacencyList2[2] = new ArrayList<Integer>( Arrays.asList(5,6));
        adjacencyList2[3] = new ArrayList<Integer>( Arrays.asList());
        adjacencyList2[4] = new ArrayList<Integer>( Arrays.asList());
        adjacencyList2[5] = new ArrayList<Integer>( Arrays.asList());
        adjacencyList2[6] = new ArrayList<Integer>( Arrays.asList());

    }

    @Test
    void dfsTraverseThreeVertices() {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);

        Traverse traverse = new Traverse(adjacencyList);
        traverse.dfs(0);

        assertEquals(expected, traverse.getDfsOrder());
    }
    @Test
    void dfsTraverseTwoVertices() {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(3);

        Traverse traverse = new Traverse(adjacencyList);
        traverse.dfs(4);

        assertEquals(expected, traverse.getDfsOrder());
    }

    @Test
    void dfsTraverseCorrectOrder() {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(3);
        expected.add(4);
        expected.add(2);
        expected.add(5);
        expected.add(6);

        Traverse traverse = new Traverse(adjacencyList2);
        traverse.dfs(0);

        assertEquals(expected, traverse.getDfsOrder());
    }

    @Test
    void bfsTraverseThreeVertices() {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);

        Traverse traverse = new Traverse(adjacencyList);
        traverse.bfs(0);

        assertEquals(expected, traverse.getBfsOrder());
    }
    @Test
    void bfsTraverseTwoVertices() {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(3);

        Traverse traverse = new Traverse(adjacencyList);
        traverse.bfs(4);

        assertEquals(expected, traverse.getBfsOrder());
    }

    @Test
    void bfsTraverseCorrectOrder() {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);

        Traverse traverse = new Traverse(adjacencyList2);
        traverse.bfs(0);

        assertEquals(expected, traverse.getBfsOrder());
    }
}