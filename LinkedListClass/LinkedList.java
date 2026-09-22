package LinkedListClass;

// GENERICS
class Node<Charizard> {
    Charizard value;
    Node<Charizard> next;

    // Overloading

    public Node(Charizard value) {
        this.value = value;
        next = null;
    }

    public Node(Charizard value, Node<Charizard> next) {
        this.value = value;
        this.next  = next;
    }
}

public class LinkedList<Pokemon> {
    private Node<Pokemon> head;
    private Node<Pokemon> tail;

    private int size;

    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    /**
     * The method takes an index as an int and returns the respective value.
     * Returns null if the index is out of bounds.
     * @param index the passed index of the item you want to retrieve
     * @return the actual value by that index
     * @throws Exception that tells us the bound of index is out
     */
    public Pokemon get(int index) throws Exception { 
        if (index >= size) {
            throw new Exception("Haha index is out of bounds! Don't break me please");
        }
        if (index < 0) {
            index += size;
        }
        Node<Pokemon> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.value;
    }

    /**
     * This method adds to the BEGINNING of the LinkedList
     * @param item is an object that is added to the beginning
     */
    public void addStart(Pokemon item) {
        head = new Node<Pokemon>(item, head);
        size++;
    }

    /**
     * This method adds the item to the end of the LinkedList.
     * The tail will point to it internally.
     * @param item any Object
     */
    public void add(Pokemon item) {
        // head = tail = (tail == null) ? new Node(item) : new Node(item);
        if (tail == null) {
            head = tail = new Node<Pokemon>(item);
        }
        else {
            tail = tail.next = new Node<Pokemon>(item);
        }
    }
}