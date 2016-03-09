
import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**This class creates a representation of Maze as a Graph by reading from a text file.
 * @author Muhammad*/
public class MazeGraph {

    final int node; //For declaring constant value of a node.
    int arc;
    List<Integer>[] adjacencyList;
    final static Set<Integer> setOfNodes = new HashSet<Integer>();

    /**This constructors takes an integer parameter for reading node indexes in
     * a list of adjacent nodes.
     * @param node - integer parameter for passing the nodes value from the file
     * and create a list of adjacent nodes.*/
    MazeGraph(int node) {
        this.node = node;
        this.arc = 0;//initialise to empty arcs
        adjacencyList = (List<Integer>[]) new List[node];
        for (int index = 0; index < node; index++) {
            adjacencyList[index] = new LinkedList<Integer>();
        }
    }

    /**The main constructor that takes a String parameter for reading maze file.
     * @param mazeFile*/
    public MazeGraph(String mazeFile) {
        this(getNodeSize(mazeFile));
        Scanner scan;
        try {
            //Scan maze file.
            scan = new Scanner(new File(mazeFile));
            /*loop when it has next integer then read two nodes from the file and add arc for it.*/
            while (scan.hasNextInt()) {
                int node1 = scan.nextInt();
                int node2 = scan.nextInt();
                addArc(node1, node2);
            }
        } catch (FileNotFoundException ex) {
            out.println(ex.getMessage());
        }
    }

    /**This method returns a size of the set of nodes by taking a String
     * parameter which the name of the maze file.
     * @param mazeFile - String parameter for reading maze file for scanning the
     * size of the nodes.
     * @return - returns an integer value for the size of the set of nodes.*/
    public static int getNodeSize(String mazeFile) {
        Scanner scanNodeSize;
        try {
            scanNodeSize = new Scanner(new File(mazeFile));
            while (scanNodeSize.hasNextInt()) {
                int node1 = scanNodeSize.nextInt();
                int node2 = scanNodeSize.nextInt();
                setOfNodes.add(node1);
                setOfNodes.add(node2);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return setOfNodes.size();
    }

    /** This method adds an arc by adding two different nodes in array of list
     * called adjacency list.
     * @param node1 - first node.
     * @param node2 - next node.*/
    private void addArc(int node1, int node2) {
        arc++; //Increase arc by one whenever this addArc method is called.
        adjacencyList[node1].add(node2);
        adjacencyList[node2].add(node1);
    }

    //Print the nodes and its arcs by looping through the adjacency list.
    public void print() {
        out.println(node + " Nodes, " + arc + " Arcs \n");
        for (int fromNode = 0; fromNode < node; fromNode++) {
            out.print(fromNode + " connected to ");
            for (int arcNode : adjacencyList[fromNode]) {
                out.print(arcNode + " ");
            }
            out.println();
        }
    }

    /**This method returns a list of nodes to allow objects to be the target for
     * "for-each" statement in order to iterate through the nodes.
     * @param nodes - an Integer parameter for getting the number of nodes in a
     * list.
     * @return - returns a list of nodes.*/
    public Iterable<Integer> getAdjacencyList(int nodes) {
        return adjacencyList[nodes];
    }
}
