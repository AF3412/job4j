package ru.af3412.testingPerfomance;

import java.util.*;

/**
 * Created by Филатов on 30.03.2017.
 */
class TimeListCheck {

    /**
     * Add long.
     *
     * @param collection the collection
     * @param line       the line
     * @param amount     the amount
     * @return the long
     */
    public long add(Collection<String> collection, String line, int amount) {
        long startTimer = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.add(line);
        }
        long stopTimer = System.nanoTime();
        return stopTimer - startTimer;
    }

    /**
     * Delete long.
     *
     * @param collection the collection
     * @param amount     the amount
     * @return the long
     */
    public long delete(Collection<String> collection, int amount) {
        Iterator<String> iter = collection.iterator();
        long startTimer = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            if (iter.hasNext()) {
                iter.next();
                iter.remove();
            }
        }
        long stopTimer = System.nanoTime();
        return stopTimer - startTimer;
    }

}

/**
 * The type Start list check.
 */
public class StartListCheck {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        TimeListCheck timeListCheck = new TimeListCheck();
        final String testString = "testString";

        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        TreeSet<String> treeSet = new TreeSet<>();

        System.out.println(timeListCheck.add(arrayList, testString, 1_000_000));
        System.out.println(timeListCheck.add(linkedList, testString, 1_000_000));
        System.out.println(timeListCheck.add(treeSet, testString, 1_000_000));
        System.out.println();
        System.out.println(timeListCheck.delete(arrayList, 1000));
        System.out.println(timeListCheck.delete(linkedList, 1000));
        System.out.println(timeListCheck.delete(treeSet, 1000));

    }
}
