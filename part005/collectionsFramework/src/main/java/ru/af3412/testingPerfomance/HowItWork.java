package ru.af3412.testingPerfomance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by Филатов on 02.04.2017.
 */
public class HowItWork {

    public static void main(String[] args) {

        {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                arrayList.add(i);
            }
            for (int i : arrayList) {
                System.out.print(i + " ");
            }
            System.out.println();

            arrayList.remove(0);

            for (int i : arrayList) {
                System.out.print(i + " ");
            }

            System.out.println();

            Iterator<Integer> iterator = arrayList.iterator();
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }

            for (int i : arrayList) {
                System.out.print(i + " ");
            }
            System.out.println("\n" + arrayList.size());
            if (iterator.hasNext()) {
                iterator.next();
            }
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }

            for (int i : arrayList) {
                System.out.print(i + " ");
            }
            System.out.println("\n" + arrayList.size());
        }

        System.out.println();

        {
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < 5; i++) {
                linkedList.add(i);
            }
            for (int i : linkedList) {
                System.out.print(i + " ");
            }
            System.out.println();

            linkedList.remove(0);

            for (int i : linkedList) {
                System.out.print(i + " ");
            }

            System.out.println();

            Iterator<Integer> iterator = linkedList.iterator();
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }

            for (int i : linkedList) {
                System.out.print(i + " ");
            }
            System.out.println("\n" + linkedList.size());
        }

        System.out.println();

        {
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < 5; i++) {
                treeSet.add(i);
            }
            for (int i : treeSet) {
                System.out.print(i + " ");
            }
            System.out.println();

            treeSet.remove(0);

            for (int i : treeSet) {
                System.out.print(i + " ");
            }

            System.out.println();

            Iterator<Integer> iterator = treeSet.iterator();
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }

            for (int i : treeSet) {
                System.out.print(i + " ");
            }
            System.out.println("\n" + treeSet.size());
        }


    }

}
