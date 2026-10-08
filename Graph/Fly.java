package Graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Fly {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scFile = new Scanner(new File("Graph/input.txt"));
        Scanner scUser = new Scanner(System.in);

        System.out.println("Enter from and to like: A B");

        String start = scUser.next();
        String end   = scUser.next();

        // The external arraylist holds references to our rows
        //   and the internal arraylist holds the actual data.
        // Each row (the internal arraylist's data) starts
        //   with a source and follows with the rest of possible 
        //   destinations. 
        ArrayList<ArrayList<String>> data = new ArrayList<>();

        // Read the input from the file
        while (scFile.hasNextLine()) {
            String[] line = scFile.nextLine().split(" -> ");

            String src = line[0];
            String dst = line[1];

            insertIntoData(data, src, dst);
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