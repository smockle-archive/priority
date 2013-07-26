import java.util.Scanner;

// Interface for a Priority Queue.
// Clay Miller (cdm0025) and Tyler Atwell (sta0003)
// COMP 3270
// 2013-07-26 Version 1.0

// To build: rm -f Node.class && javac -g Node.java && rm -f Priority.class && javac -g Priority.java
// To run: java Priority

public class Priority {
  public static void main(String[] args) {
    // Init scanner.
    Scanner scan = new Scanner(System.in);
    
    // Get max size and make Node array.
    int size = 0;
    while (size <= 0) {
      System.out.print("How big is the queue? ");
      size = scan.nextInt();
    }
    Node[] nodes = new Node[size];
    
    // Get current size.
    int n = size + 1;
    while (n > size) {
      System.out.print("How many elements initially? ");
      n = scan.nextInt();
    }
    
    // Make a priority queue.
    Heap pq = new Heap(nodes, size, n);
    
    // Get each initial element.
    for (int i = 0; i < n; i++) {
      // Make a Node.
      Node node = new Node();
      
      // Get element ID (position).
//      System.out.print("What is the ID (position) of element #" + (i + 1) + "? ");
//      n.nodeID = scan.nextInt();
//      System.out.print("\n");
      node.nodeID = i;
      
      // Get element priority (value).
      System.out.print("What is the priority (value) of element #" + (i + 1) + "? ");
      node.nodePriority = scan.nextInt();
      
      // Add Node to queue.
      pq.insert(node);
    }
    
    // Heapify queue.
    pq.buildheap();

    // Usage.
    System.out.println("Please specify a command:");
    System.out.println("\"enqueue\" or \"e\" adds a new element.");
    System.out.println("\"dequeue\" or \"d\" removes the highest priority element.");
    System.out.println("\"changeWeight\" or \"c\" changes the priority of an element.");
    
    // Get user commands (enqueue, dequeue, changeweight).
    String c = "";
    while (c != "exit" && c != "quit" & c != "q") {
      // Prompt.
      System.out.print("> ");
      c = scan.nextLine();
      
      // Switch.
      switch (c) {
        case "enqueue":
        case "e":
          // Get element ID (position).
          System.out.print("What is the new element ID (position)? ");
          int id = scan.nextInt();
      
          // Get element priority (value).
          System.out.print("What is the new element priority (value)? ");
          int priority = scan.nextInt();
      
          // Add Node to queue.
          pq.enqueue(id, priority);
          break;
        
        case "dequeue":
        case "d":
          pq.dequeue();
          break;
        
        case "changeWeight":
        case "c":
          // Get element ID (position).
          System.out.print("What is the current element ID (position)? ");
          id = scan.nextInt();
      
          // Get element priority (value).
          System.out.print("What is the new element priority (value)? ");
          priority = scan.nextInt();
      
          // Add Node to queue.
          pq.changeWeight(id, priority);
          break;
        
        case "exit":
        case "quit":
        case "q":
          break;
        
        default:
          break;
      }
    }
    
    // Close scanner.
    scan.close();
  }
}