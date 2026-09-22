package LinkedListClass;


class Pet {
    Pet(int i) {

    }
}
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> llInteger = new LinkedList<>();
        LinkedList<String> llString = new LinkedList<>();

        Object[] lists = new Object[2];
        lists[0] = llInteger;
        lists[0] = llString;

        llString.add("7");
        llString.add("9");
        
        llInteger.add(-100);
        llInteger.add(9);
        llInteger.add(10);
        llInteger.add(8);
        
        try {
            System.out.println(llInteger.get(0) + llInteger.get(1));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
