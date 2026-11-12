package Hash;

import java.util.*;

class Person implements Comparable<Person> {
    int strength;
    int wisdom;
    int charisma;

    public Person(int s, int w, int c) {
        strength = s;
        wisdom = w;
        charisma = c;
    }

    public String toString() {
        return strength + " " + wisdom + " " + charisma;
    }

    @Override
    public int compareTo(Person p) {
        return - (strength + wisdom + charisma)
                             +
               (p.strength + p.wisdom + p.charisma);
    }

    @Override
    public boolean equals(Object obj) {
        Person p = (Person)obj;
        return p.strength == strength &&
               p.wisdom   == wisdom   &&
               p.charisma == charisma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = hash * 5 + strength;
        hash = hash * 5 + wisdom;
        hash = hash * 5 + charisma;
        return hash;
    }
    
}

public class People {
    public static void main(String[] args) {
        //     profile, name
        Map<Person, String> people = new TreeMap<>();
        Set<Person> setOfPeople = new TreeSet<>();

        Person p1 = new Person(6, 7, 8);
        Person p2 = new Person(-1, -3456, -254);
        Person p3 = new Person(345, 7456, 825);
        
        setOfPeople.add(p1);
        setOfPeople.add(p2);

        System.out.println(setOfPeople.contains(p2)); // close to O(1)

        people.put(p2, "GOAT");
        people.put(p1, "LittleBob");
        people.put(p3, "Alice");

        for (Person person : people.keySet()) {
            System.out.println(person);
        }

        for (Map.Entry<Person, String> pair : people.entrySet()) {
            pair.getKey();
            pair.getValue();
        }
    }
}
