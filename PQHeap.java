public class PQHeap implements PriorityQueue{
	private Integer[] data;
	private int numElts;

	public void add(Integer toAdd){
		if((numElts+1) == data.length) resize();
		data[numElts+1]= toAdd;
		numElts++;
		siftUp(numElts);
	}

	public Integer remove(){
		if(numElts == 0) return null;
		Integer toReturn = data[1];
		data[1]=data[numElts];
		numElts--;
		siftDown();
		return toReturn;
	}

	public void siftDown(){
		int i = 1;
		int big;
		int holder;
		// while there is at least one child
		while(numElts>=(2*i)){
			//checks to see if there are two children
			if(numElts>=(2*i+1)){
				// checks to see if the parent is larger than children
				if(data[i]>=data[2*i] && data[i]>=data[2*i+1]){
					break;
				}
				//finds the larger child and marks its pos
				if(data[2*i]>data[2*i+1]){big = 2*i;}
				else{big = 2*i+1;}
				// does the switcheroo
				holder = data[i];
				data[i] = data[big];
				data[big] = holder;
				//changes the index to the sifted down number
				i = big;
			}
			// the corner case of one child
			else{
				if(data[i]<data[i*2]){
					holder = data[i];
					data[i] = data[i*2];
					data[i*2] = holder;
					break;
				}
				else{break;}
			}


		}
	}





	public void resize(){
		Integer[] temp = new Integer[data.length * 2];
		for(int i = 1; i <= numElts; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}
	public void siftUp(int pos){
		int temp;
		// if the element is not at the top
		if(pos>1) {
			// if the element is greater than the one above it
			if(data[pos]>data[pos/2]) {
				temp = data[pos/2];
				data[pos/2] = data[pos];
				data[pos] = temp;
				// call again on the new position
				siftUp(pos/2);
			}
		}
	}
	public int size(){
		return numElts;

	}
	public boolean isEmpty(){
		if(numElts == 0){return true;}
		else{return false;}

	}
	public PQHeap(){
		data = new Integer[2];
		numElts = 0;
	}
	public String toString() {
		String toReturn = "";
		for(int i = 1; i<numElts;i++) {
			toReturn += data[i] +" ";
		}
		return toReturn;
	}

}