package de.etc.lambda;

import java.util.Comparator;

public class ComparatorAfterAlter implements Comparator {
    public int compare(Object obj1, Object obj2) {
        // Make sure that the objects are Car objects
        Developer a = (Developer) obj1;
        Developer b = (Developer) obj2;

        // Compare the objects
        return Integer.compare(a.getAlter(), b.getAlter()); // The first car has a smaller year

        // The first car has a larger year
        // Both cars have the same year
    }
}