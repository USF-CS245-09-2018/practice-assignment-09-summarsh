
public class BinaryHeap {

	protected int[] arr;
	protected int size;

	public BinaryHeap() {
		arr = new int[10];
		size = 0;
	}

	//add instance to priority queue
	public void add(int value) {
		if(arr.length <= size) {
			grow_array();
		}
		arr[size] = value;
		++size;
		int index = size-1;
		int parent = (index-1)/2;
		while(index>0 && arr[index] < arr[parent]) {
			swap(arr, index, parent);
			index = parent;
			parent = (index-1)/2;
		}
	}	

	//removes highest priority number aka the lowest number
	public int remove() {
		int priority = arr[0];
		arr[0] = arr[size-1];
		--size;
		shift_down(0);
		return priority;
	}

	public void shift_down(int parent) {
		//make sure it's still within the tree
		int child=parent*2+1;
		if(size <= child) {
			return;
		}
		if(arr[child+1] < arr[child]) {
			++child;
		}
		if(arr[parent] > arr[child]) {
			swap(arr, child, parent);
			shift_down(child);
		}
	}

	public void swap(int [] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b]=temp;
	}

	public void grow_array() {
		int[] newArr = new int[arr.length*2];
		for(int i=0; i<arr.length; i++){
			newArr[i] = arr[i];
		}
		arr = newArr;
	}
}