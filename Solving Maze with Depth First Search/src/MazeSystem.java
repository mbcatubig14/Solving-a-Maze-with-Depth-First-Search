
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;

/**
 * This class is the main launcher of the program.
 *
 * @author Muhammad Catubig
 */
public class MazeSystem {

    Scanner scan;
    DepthFirstSearch depthFirstSearch;

    //The constructor that allows user to enter the maze file, starting node, goal node
    public MazeSystem() {
        out.print("Enter maze file: "); 
        scan = new Scanner(in);
        String file = scan.nextLine();
        out.print("Enter start node: ");
        int startNode = scan.nextInt();
        out.print("Enter goal node: ");
        int goalNode = scan.nextInt();
        MazeGraph G = new MazeGraph(file);
        out.print("Maze representation\n");
        G.print();
        out.println("Starting at 0\nGoal at 1");
        long startNanoTime = System.nanoTime();
        depthFirstSearch = new DepthFirstSearch(G, startNode, goalNode);
        long estimatedTime = System.nanoTime() - startNanoTime;
        out.println("\nEstimated nanotime: " + estimatedTime + " nanoseconds");
    }

    // The main method that handles the main launcher of the program.
    public static void main(String[] args) {
        MazeSystem mazeSystem = new MazeSystem();
    }
}
