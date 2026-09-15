package LinkedListClass;

class Node {
    Object value;
    Node next;

    // Overloading

    public Node(Object value) {
        this.value = value;
        next = null;
    }

    public Node(Object value, Node next) {
        this.value = value;
        this.next  = next;
    }
}

public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    // public ... get(int index) {
        
    // }

    /**
     * This method adds to the BEGINNING of the LinkedList
     * @param item is an object that is added to the beginning
     */
    public void addStart(Object item) {
        head = new Node(item, head);
    }
}