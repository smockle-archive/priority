public class MaxHeap {
 
	private Integer[] maxHeap = null;
	private int heapSize = 0;
	private int currentIndex = 0;
 
	public MaxHeap(int heapSize){
		this.heapSize = heapSize;
		maxHeap = new Integer[heapSize];
	}
 
	public int size(){
		return currentIndex -1;
	}
 
	public int peek(){
		return maxHeap[0];
	}
 
	public boolean insert(int key){
		if(currentIndex == heapSize){
			pop();
			insert(key);
		}else{
			maxHeap[currentIndex] = key;
			heapifyUp(currentIndex++);
		}
		return true;
	}
 
	public Integer pop(){
		if(maxHeap[0] == null){
			System.out.println("HEAP EMPTY!");
			return null;
		}
 
		int max = maxHeap[0];
		currentIndex--;
		maxHeap[0] = maxHeap[currentIndex];
		maxHeap[currentIndex] = null;
		heapifyDown(0);
		System.out.println("POPPED : " + max);
		return max;
	}
 
	private void heapifyUp(int current) {
		int parent = (current - 1) / 2;
		if(current < 0)
			return;
		if(maxHeap[current] > maxHeap[parent]){
			 int temp = maxHeap[parent];
			 maxHeap[parent] = maxHeap[current];
			 maxHeap[current] = temp;
			 current = parent;
			 heapifyUp(current);
		}
	}
 
	private void heapifyDown(int current) {
		int left = 2 * current + 1;
		int right = left + 1;
 
		if(current > currentIndex / 2) // exit condition
			return;
 
		int biggerChild = 0;
 
		if(maxHeap[left] == null && maxHeap[right] != null){
			biggerChild = right;
		}else if(maxHeap[right] == null && maxHeap[left] != null){
			biggerChild = left;
		}else if(maxHeap[left] == null && maxHeap[right] == null){
			return;
		}else{
			biggerChild = maxHeap[left] > maxHeap[right] ? left : right;
		}
 
		if(biggerChild == left && maxHeap[left] > maxHeap[current]){
			int temp = maxHeap[left];
			maxHeap[left] = maxHeap[current];
			maxHeap[current] = temp;
			heapifyDown(left);
		}else if(biggerChild == right && maxHeap[right] > maxHeap[current]){
			int temp = maxHeap[right];
			maxHeap[right] = maxHeap[current];
			maxHeap[current] = temp;
			heapifyDown(right);
		}else{
			return;
		}
	}
 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("#HEAP [MAX HEAP=");
		builder.append(Arrays.toString(maxHeap));
		builder.append("]");
		return builder.toString();
	}
}
