package ru.af3412.convertList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Филатов on 31.03.2017.
 */
public class ConvertList {

    /**
     * Converted array[][] (Integer) to ArrayList<Integer>.
     *
     * @param array the array
     * @return the list
     */
    public List<Integer> toList(int[][] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                arrayList.add(j);
            }
        }

        return arrayList;
    }

    /**
     * Converted ArrayList<Integer> To array int [ ] [ ].
     *
     * @param list the list
     * @param rows the rows
     * @return the int [ ] [ ]
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] array = new int[rows][rows];
        Iterator<Integer> iterator = list.iterator();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (iterator.hasNext()) {
                    array[i][j] = iterator.next();
                } else {
                    array[i][j] = 0;
                }
            }
        }

        return array;

    }

}
