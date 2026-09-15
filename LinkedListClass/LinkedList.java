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

    /**
     * The method takes an index as an int and returns the respective value.
     * Returns null if the index is out of bounds.
     * @param index the passed index of the item you want to retrieve
     * @return the actual value by that index
     */
    public Object get(int index) { // index == 2
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.value;
    }

    /**
     * This method adds to the BEGINNING of the LinkedList
     * @param item is an object that is added to the beginning
     */
    public void addStart(Object item) {
        head = new Node(item, head);
    }
}