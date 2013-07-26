import java.util.Scanner;

// Interface for a Priority Queue.
// Clay Miller (cdm0025) and Tyler Atwell (sta0003)
// COMP 3270
// 2013-07-26 Version 1.0

// Requires at least Java Version 7.25

// To build: rm -f Node.class && javac -g Node.java && rm -f Priority.class && javac -g Priority.java
// To run: java Priority

public class Priority {
  public static boolean isInteger(String string) {
    try {
        Integer.parseInt(string);
        return true;
    }
    catch(Exception e) {
        return false;
    }
  }
  
  public static void main(String[] args) {
    // Init scanner.
    Scanner scan = new Scanner(System.in);
    
    // Get max size and make Node array.
    int size = 0;
    while (size <= 0) {
      System.out.print("How big is the queue? ");
      String temp = scan.nextLine();
      if (Priority.isInteger(temp)) size = Integer.parseInt(temp);
    }
    Node[] nodes = new Node[size];
    
    // Get current size.
    int n = size + 1;
    while (n > size) {
      System.out.print("How many elements initially? ");
      String temp = scan.nextLine();
      if (Priority.isInteger(temp)) n = Integer.parseInt(temp);
    }
    
    // Make a priority queue.
    Heap pq = new Heap(nodes, size, 0);
    
    // Get each initial element.
    for (int i = 0; i < n; i++) {
      // Make a Node.
      Node node = new Node();
      
      // Get element ID (position).
      node.id = -1;
      while (node.id < 0 || node.id > size - 1) {
        System.out.print("What is the ID (position) of element #" + (i + 1) + "? ");
        String temp = scan.nextLine();
        if (Priority.isInteger(temp)) node.id = Integer.parseInt(temp);
        
        // Check existing ids. Ensure uniqueness.
        Node[] ns = pq.getHeap();
        for (int j = 0; j < pq.heapsize(); j++) {
          if (ns[j].id == node.id) node.id = -1;
        }
      }
      
      // Get element priority (value).
      boolean b = true;
      while (b) {
        System.out.print("What is the priority (value) of element #" + (i + 1) + "? ");
        String temp = scan.nextLine();
        if (Priority.isInteger(temp)) { node.priority = Integer.parseInt(temp); b = false; }
      }
      
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
    System.out.println("\"show\" or \"s\" displays all elements.");
    System.out.println("\"exit\" or \"quit\" or \"q\" closes the program.");
    
    // Get user commands (enqueue, dequeue, changeweight).
    String c = "";
    while (!c.equals("exit") && !c.equals("quit") && !c.equals("q")) {
      // Prompt.
      System.out.print("> ");
      c = scan.nextLine();
      
      // Switch.
      switch (c) {
        case "enqueue":
        case "e":
          if (pq.getHeap().length == pq.heapsize()) { break; }
        
          // Get element ID (position).
          int id = -1;
          while (id < 0 || id > size - 1) {
            System.out.print("What is the new element ID (position)? ");
            String temp = scan.nextLine();
            if (Priority.isInteger(temp)) id = Integer.parseInt(temp);
            
            // Check existing ids. Ensure uniqueness.
            Node[] ns = pq.getHeap();
            for (int j = 0; j < pq.heapsize(); j++) {
              if (ns[j].id == id) id = -1;
            }
          }
          
          // Get element priority (value).
          boolean b = true;
          int priority = 0;
          while (b) {
            System.out.print("What is the new element priority (value)? ");
            String temp = scan.nextLine();
            if (Priority.isInteger(temp)) { priority = Integer.parseInt(temp); b = false; }
          }
      
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
          id = -1;
          while (id < 0 || id > size - 1) {
            System.out.print("What is the current element ID (position)? ");
            String temp = scan.nextLine();
            if (Priority.isInteger(temp)) id = Integer.parseInt(temp);
            
            // Check existing ids. Ensure element exists.
            Node[] ns = pq.getHeap();
            b = true;
            for (int j = 0; j < pq.heapsize(); j++) {
              if (ns[j].id == id) b = false;
            }
            if (b) id = -1;
          }
          
          // Get element priority (value).
          b = true;
          priority = 0;
          while (b) {
            System.out.print("What is the new element priority (value)? ");
            String temp = scan.nextLine();
            if (Priority.isInteger(temp)) { priority = Integer.parseInt(temp); b = false; }
          }
      
          // Add Node to queue.
          pq.changeWeight(id, priority);
          break;
        
        case "show":
        case "s":
          System.out.println(pq.toString());
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
