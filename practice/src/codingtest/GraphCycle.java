package codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Description :
 */
public class GraphCycle {

    private int numberOfGraph;
    private LinkedList<Integer>[] linkedArray;

    public GraphCycle(int numberOfGraph) {
        this.numberOfGraph = numberOfGraph;
        linkedArray = new LinkedList[numberOfGraph];

        for (int i = 0; i < numberOfGraph; i++) {
            linkedArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(int i, int tail) {
        linkedArray[i].add(tail);
    }

    public boolean isCycle() {
        boolean[] visited = new boolean[numberOfGraph];
        boolean[] recursiveArray = new boolean[numberOfGraph];

        for (int i = 0; i < numberOfGraph; i++) {
            if (doRecursive(i, visited, recursiveArray)) {
                return true;
            }
        }

        return false;
    }

    private boolean doRecursive(int index, boolean[] visited, boolean[] recursiveArray) {
        visited[index] = true;
        recursiveArray[index] = true;

        for (int i = 0; i < linkedArray[index].size(); i++) {
            int tail = linkedArray[index].get(i);
            if (!visited[tail] && doRecursive(tail, visited, recursiveArray)) {
                return true;
            } else if (recursiveArray[tail]) {
                return true;
            }
        }

        recursiveArray[index] = false;
        return false;
    }

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int number = Integer.parseInt(input);

        GraphCycle graphCycle = new GraphCycle(number);

        for (int i = 0; i < number; i++) {
            String temp = br.readLine();
            if (temp == null) {
                break;
            }
            String[] arr = temp.split(" ");
            if (arr.length == 2) {
                graphCycle.addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
            }
        }

        System.out.println(graphCycle.isCycle());
    }
}
