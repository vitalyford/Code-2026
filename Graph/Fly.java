package Graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class Fly {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scFile = new Scanner(new File("Graph/input.txt"));
        Scanner scUser = new Scanner(System.in);

        // The external arraylist holds references to our rows
        // and the internal arraylist holds the actual data.
        // Each row (the internal arraylist's data) starts
        // with a source and follows with the rest of possible
        // destinations.
        ArrayList<ArrayList<String>> data = new ArrayList<>();

        // Read the input from the file
        while (scFile.hasNextLine()) {
            String[] line = scFile
                    .nextLine()
                    .split(" -> ");

            String src = line[0];
            String dst = line[1];

            insertIntoData(data, src, dst);
        }

        while (true) {
            System.out.println("Enter from and to like: A B");

            String start = scUser.next();
            String end = scUser.next();

            findPath(data, start, end); // S to X
            System.out.println();
        }
    }

    private static boolean checkIfStartAndEndExist(ArrayList<ArrayList<String>> data, String start, String end) {
        // Ensure that start and end actually exist in our data
        boolean foundStartingCity = false, foundEndingCity = false;
        for (ArrayList<String> row : data) {
            if (!foundStartingCity && row.get(0).equals(start)) {
                // We verified that there is a city we can fly from
                foundStartingCity = true;
            }
            for (int i = 1; i < row.size(); i++) {
                if (row.get(i).equals(end)) {
                    foundEndingCity = true;
                    break;
                }
            }

            if (foundStartingCity && foundEndingCity) {
                break;
            }
        }
        return foundStartingCity && foundEndingCity;
    }

    // KISS, DRY, SOLID, YAGNI
    public static void findPath(ArrayList<ArrayList<String>> data, String start, String end) {
        if (!checkIfStartAndEndExist(data, start, end)) {
            System.out.println("Either the start or end does not exist");
            return;
        }

        Stack<String> stack = new Stack<>();
        stack.push(start);

        ArrayList<String> visited = new ArrayList<>();

        while (!stack.isEmpty()) {
            // 1. Identify where I am
            // 2. Where can I go
            // 3. Is where we are going the End?
            // 4. Make sure I have not been to the city I picked
            // 5. In case we are stuck/cannot go to another city,
            // I am going to pop where I am to follow my
            // previous breadcrumb (until I am no longer stuck)
            String curr = stack.peek();

            if (curr.equals(end)) {
                break;
            }

            visited.add(curr);

            boolean foundNextCity = false;
            for (ArrayList<String> row : data) {
                if (row.get(0).equals(curr)) {
                    // Where can I go next?
                    for (int i = 1; i < row.size(); i++) {
                        String nextCity = row.get(i);
                        if (!visited.contains(nextCity)) {
                            stack.push(nextCity);
                            foundNextCity = true;
                            break;
                        }
                    }
                }
            }

            if (!foundNextCity) {
                stack.pop();
            }
        } // end while loop

        if (!stack.isEmpty()) {
            // Print the path!
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " <- ");
            }
        } else {
            System.out.println("No path found");
        }
    }

    public static void insertIntoData(ArrayList<ArrayList<String>> data, String src, String dst) {
        for (ArrayList<String> row : data) {
            // If the first element in the row
            // is a known city we can fly from, then
            // you just add dst to that arraylist
            if (row.get(0).equals(src)) {
                row.add(dst);
                return; // we no longer need to continue, done with insertion
            }
        }

        ArrayList<String> newRow = new ArrayList<>();

        newRow.add(src);
        newRow.add(dst);

        data.add(newRow);
    }
}