
import static java.lang.System.out;
import java.util.*;

/**
 * This the Depth-First Search Class that handles the depth-first search
 * algorithm.
 *
 * @author Muhammad Catubig
 */
public class DepthFirstSearch {

    private final boolean[] visited;
    private final int sourceNode;
    private final int[] pathTo;

    /**
     * This is Depth First Search constructor that takes an input of MazeGraph
     * object parameter, integer source node and goal.
     *
     * @param mazeGraph is a generated graph from MazeGraph Class
     * @param sourceNode is the starting input node to reach the goal node
     * @param goal is an input goal node for the starting node to reach for
     */
    public DepthFirstSearch(MazeGraph mazeGraph, int sourceNode, int goal) {
        this.sourceNode = sourceNode;
        visited = new boolean[mazeGraph.node];
        pathTo = new int[mazeGraph.node];
        performRecursiveDFS(mazeGraph, sourceNode, goal);
    }

    //Perform recursive depth-first search
    private void performRecursiveDFS(MazeGraph mazeGraph, int node, int goal) {
        visited[node] = true;
        if (node == goal) {
            printPath(goal);
        } else {
            for (int arc : mazeGraph.getAdjacencyList(node)) {
                if (!visited[arc]) {
                    pathTo[arc] = node;
                    performRecursiveDFS(mazeGraph, arc, goal);
                } else {
                    printPath(goal);
                }
            }
        }
        visited[node] = false;
    }

    //Put path to goal in the stack
    private Stack<Integer> pathTo(int toGoalNode) {
        if (!visited[toGoalNode]) {
            return null;
        }
        Stack<Integer> pathStack = new Stack<Integer>();
        for (int pathToGoalNode = toGoalNode; pathToGoalNode != sourceNode; pathToGoalNode = pathTo[pathToGoalNode]) {
            pathStack.push(pathToGoalNode);
        }
        pathStack.push(sourceNode);
        reverseTheStackOrder(pathStack);
        return pathStack;
    }

    //It reverses the stack that takes a stack parameter and used after the path is filled.
    private void reverseTheStackOrder(Stack<Integer> stackToBeReverse) {
        if (stackToBeReverse.isEmpty()) {
            return;
        }
        int bottom = popBottomStack(stackToBeReverse);
        reverseTheStackOrder(stackToBeReverse);
        stackToBeReverse.push(bottom);
    }

    //Pop the bottom of the stack
    private int popBottomStack(Stack<Integer> stackToBeReverse) {
        int popTopStack = stackToBeReverse.pop();
        if (stackToBeReverse.isEmpty()) {
            return popTopStack;
        } else {
            int bottomStack = popBottomStack(stackToBeReverse);
            stackToBeReverse.push(popTopStack);
            return bottomStack;
        }
    }

    //Print the path to goal
    private void printPath(int toGoal) {

        if (visited[toGoal]) {
            out.println("Path to Goal: ");
            for (int from : pathTo(toGoal)) {
                if (from == toGoal) {
                    out.print(from);
                } else {
                    out.print(from + " - ");
                }
            }
            out.println();
        }
    }

}
