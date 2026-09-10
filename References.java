import java.util.*;

class Pet {
    String name;
    int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    public String toString() {
        return name + " " + age;
    }
}

public class References {
    public static void main(String[] args) {
        Pet cat = new Pet("Alice", 10);
        Pet dog = new Pet("Bob", 19);

        Pet elephant = cat;
        cat = dog;

        cat.name = "Janice";

        System.out.println(cat);
        System.out.println(dog);
        System.out.println(elephant);
    }
}