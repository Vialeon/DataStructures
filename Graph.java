

public class Graph {

	int numNodes;
	Node[] nodes;
	

	public void addEdge(int i, int j) {
		if(i<nodes.length && j<nodes.length) {
		nodes[i].edges.add(nodes[j]);
		nodes[j].edges.add(nodes[i]);
		}
		else {
		}
	}

	public Graph(int num) {
		numNodes = num;
		nodes = new Node[numNodes];
		for(int i = 0; i < numNodes; i++) {
			nodes[i] = new Node(i);
		}

		// you might also want to do other things here
	}
	public boolean edgeExists(Node i, Node j) {
		return i.edges.contains(j);
	}

}