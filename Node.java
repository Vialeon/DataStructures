import java.util.LinkedList;

public class Node {

	int index;
	//keeps track of the index of the edges
	LinkedList<Node> edges = new LinkedList<Node>();
	public int edge =0;

	// to help you keep track of things as you're solving the maze
	boolean visited = false;
	boolean inSolution = false;

	// these are just here to help with the toString method
	static final String PATH = "X";
	static final String VISIT = ".";
	static final String NOT_VISIT = " ";

	public String toString() {
		if(visited) {
			if(inSolution) return PATH;
			else return VISIT;
		}
		else return NOT_VISIT;
	}

	public Node(int i) {
		index = i;
	}
	public Node hasUnvisitedEdge() {
		for(int i = 0; i<edges.size();i++) {
			if(!edges.get(i).visited) {
				return edges.get(i);
			}
			edge++;
		}
		return null;
	}

}