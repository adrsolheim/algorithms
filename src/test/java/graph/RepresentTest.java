package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class RepresentTest {

    int numberOfVertices;
    Represent represent;
    ArrayList<ArrayList<Integer>> input;

    @BeforeEach
    void setup() {
        represent = new Represent();
        input = new ArrayList<>();
        numberOfVertices = 3;

        input.add(new ArrayList<Integer>( Arrays.asList(2, 1, 2)));
        input.add(new ArrayList<Integer>( Arrays.asList(2, 0, 2)));
        input.add(new ArrayList<Integer>( Arrays.asList(1, 0)));
    }

    @Test
    void adjacencyMatrix() {
        numberOfVertices = 3;
        int[][] expected = {
                {0, 1, 1},
                {1, 0, 1},
                {1, 0, 0}
        };

        assertArrayEquals(expected, represent.adjacencyMatrix(numberOfVertices, input));
    }

    @Test
    void adjacencyList() {
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<Integer>( Arrays.asList(1, 2)));
        expected.add(new ArrayList<Integer>( Arrays.asList(0, 2)));
        expected.add(new ArrayList<Integer>( Arrays.asList(0)));

        assertEquals(expected, represent.adjacencyList(numberOfVertices, input));
    }

    @Test
    void edgeList() {
        ArrayList<int[]> expected = new ArrayList<>();
        expected.add(new int[] {0,1});
        expected.add(new int[] {0,2});
        expected.add(new int[] {1,0});
        expected.add(new int[] {1,2});
        expected.add(new int[] {2,0});

        for (int i = 0; i < numberOfVertices; i++) {
            assertArrayEquals(expected.get(i), represent.edgeList(numberOfVertices, input).get(i));
        }
    }
}