import java.util.*;

class Pet implements Comparable<Pet> {
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return name + " " + age;
    }

    /**    (non-Javadoc)
     * Returns a positive number if your current (this)
     * pet object is bigger than the one you are comparing 
     * against (the "pet" argument)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Pet pet) {
        if (this.age > pet.age) {
            return 1;
        }
        else if (this.age < pet.age) {
            return -1;
        }
        else {
            return -1 * this.name.compareTo(pet.name);
        }
    }
}

public class SortingExample {
    public static void main(String[] args) {
        PriorityQueue<Pet> pets = new PriorityQueue<>();

        // log2(n) if n is a million items, then add()
        // will take about 20 steps
        pets.add(new Pet("Bobby", 5));
        pets.add(new Pet("Alice", 5));
        pets.add(new Pet("Eve", 6));
        pets.add(new Pet("Terence", 2));
        pets.add(new Pet("Jane", 3));

        while (!pets.isEmpty()) {
            System.out.println(pets.poll());
        }
    }
}