package Hash;

import java.util.*;

class Person {
    int strength;
    int wisdom;
    int charisma;

    public Person(int s, int w, int c) {
        strength = s;
        wisdom = w;
        charisma = c;
    }
}

public class People {
    public static void main(String[] args) {
        //      name,  profile
        HashMap<String, Person> people = new HashMap<>();

        Person p1 = new Person(6, 7, 8);
        Person p2 = new Person(-1, -3456, -254);
        Person p3 = new Person(345, 7456, 825);

        people.put("Alice", p3);
        people.put("GOAT", p2);
        people.put("LittleBob", p1);

        for (Map.Entry<String, Person> pair : people.entrySet()) {
            pair.getKey();
            pair.getValue();
        }
    }
}
