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
        int column;
        if (list.size() % rows != 0) {
            column = list.size() / rows + 1;
        } else {
            column = list.size() / rows;
        }

        int[][] array = new int[rows][column];
        Iterator<Integer> iterator = list.iterator();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (iterator.hasNext()) {
                    array[i][j] = iterator.next();
                } else {
                    array[i][j] = 0;
                }
            }
        }

        return array;

    }

    /**
     * Convert list.
     *
     * @param list the list
     * @return the list
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        Iterator<int[]> iterator = list.iterator();
        for (int[] i : list) {
            if (iterator.hasNext()) {
                for (int j : iterator.next()) {
                    result.add(j);
                }
            }
        }

        return result;
    }

}
