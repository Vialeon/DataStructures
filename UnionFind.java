
public class UnionFind {

	public LLAddOnly makeSet(Cell c) {
		LLAddOnly set = new LLAddOnly();
		set.add(c);
		return set;
	}

	public LLAddOnly find(Cell c) {
		LLAddOnly toReturn = c.head;
		return toReturn;
	}
	// adds two LLAddOnly's together
	public void union(Cell one, Cell two) {
		// if first cell list is larger add second to first
		if(one.head.size>=two.head.size) {
			Cell twoFirst = two.head.first;
			// adds the second cell's list to the first cells list
			unionize(one,twoFirst);
		}
		// if second cell list is larger than first. add first to second
		else {
			Cell oneFirst = one.head.first;
			// adds the second cell's list to the first cells list
			unionize(two,oneFirst);
		}

	}
	// bigger cell is cell one
	private void unionize(Cell one, Cell two) {
		if(two.next!=null) {
			unionize(one, two.next);
		}
		one.head.add(two);
	}


}

