
public class Heap {

		private Node[] Heap; // Pointer to the heap array 
		private int size; // Maximum size of the heap 
		private int n; // Number of elements now in the heap 
		
		// Constructor - Done
		public Heap(Node[] q, int x, int y)
		{
			Heap = q;
			size = x;
			n = y;			
		}		
		
		public void enqueue(int Object_ID, int priority)
		{
			Node n = new Node();
			n.nodeID = Object_ID;
			n.nodePriority = priority;
			
			n.enqueueNidiot!!!!;
		}
		
		public int dequeue()
		{
			
		}
		
		// Done
		public void changeWeight(int Object_ID, int new_priority)
		{
			boolean didFind = false;
			for(Node x : Heap)
			{
				if(x.nodeID == Object_ID)
				{
					didFind = true;
					x.nodePriority = new_priority;
				}
			}
			
			if(!didFind)
			{
				//doneGoofed
			}
		}
		
		// Put an element in its correct place ~ max-heapify(int) 
		private void siftdown(int x) 
		{
			
		}

		// Return current size of the heap - Done
		public int heapsize() 
		{
			return Heap.length;
		}
		
		// TRUE if pos is a leaf position - Done
		public boolean isLeaf(int x)  
		{
			boolean leaf = false;
			
			if(leftChild(x) == -1 && rightChild(x) == -1 )
			{
				leaf = true;
			}
			
			return leaf;
		}
		
		// Return position for left child - Done
		public int leftChild(int x)
		{
			int retval = -1;
			
			try
			{
				Node left = Heap[2*x];
				retval = 2*x;
			}
			finally{}
				
			return retval;		
		}
		
		// Return position for right child - Done
		public int rightChild(int x)
		{
			int retval = -1;
			
			try
			{
				Node right = Heap[2*x + 1];
				retval = 2*x + 1;
			}
			finally{}
				
			return retval;	
		}
		
		// Return position for parent 
		public int parent(int x)
		{

			int retval = -1;
			
			try
			{
				Node parent = Heap[x/2];
				retval = x/2;
			}
			finally{}
				
			return retval;
		}
		
		// Insert value into heap
		public void insert(Node q)
		{
			
		}
		
		// Remove maximum value
		public Node removemax()
		{
			
		}
		
		// Remove value at specified position
		public Node remove(int x)
		{
			
		}
		
		// Heapify contents of heap
		public void buildheap()
		{
			
		}
		
		// This is my special node representation class,  It's just a fancy way to represent the values
		public class Node
		{
			public int nodeID;
			public int nodePriority;
		}
}

