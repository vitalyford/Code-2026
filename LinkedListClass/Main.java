package LinkedListClass;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.add(7);
        ll.add(-100);
        ll.add(9);
        ll.add(3);
        ll.add(10);
        ll.add(8);

        try {
            System.out.println(ll.get(0));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
