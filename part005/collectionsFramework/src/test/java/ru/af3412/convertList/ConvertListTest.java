package ru.af3412.convertList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Филатов on 02.04.2017.
 */
public class ConvertListTest {

    /**
     * When transfer array one value then return collection with one value.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenTransferArrayOneValueThenReturnCollectionWithOneValue() throws Exception {

        ConvertList convertList = new ConvertList();
        int[][] array = new int[1][1];
        array[0][0] = 0;

        ArrayList<Integer> checked = new ArrayList<>();
        checked.add(0);
        List<Integer> result = convertList.toList(array);

        assertThat(result, is(checked));

    }

    /**
     * When transfer array 0123 then return collection 0123.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenTransferArray0123ThenReturnCollection0123() throws Exception {

        ConvertList convertList = new ConvertList();
        int[][] array = new int[2][2];
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                array[i][j] = count;
                count++;
            }
        }

        ArrayList<Integer> checked = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            checked.add(i);
        }
        List<Integer> result = convertList.toList(array);

        assertThat(result, is(checked));

    }

    /**
     * When transfer array 012345678 then return collection 012345678.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenTransferArray012345678ThenReturnCollection012345678() throws Exception {

        ConvertList convertList = new ConvertList();
        int[][] array = new int[3][3];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = count;
                count++;
            }
        }

        ArrayList<Integer> checked = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            checked.add(i);
        }
        List<Integer> result = convertList.toList(array);

        assertThat(result, is(checked));

    }

    /**
     * When transfer collection with one value then return array 0.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenTransferCollectionWithOneValueThenReturnArray0() throws Exception {

        ConvertList convertList = new ConvertList();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);

        int[][] checked = new int[1][1];
        checked[0][0] = 0;

        int[][] result = convertList.toArray(arrayList, 1);

        assertThat(result, is(checked));
    }

    /**
     * When transfer collection with two value and one row then return array 01.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenTransferCollectionWithTwoValueAndOneRowThenReturnArray01() throws Exception {

        ConvertList convertList = new ConvertList();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);

        int[][] checked = new int[1][1];
        checked[0][0] = 0;

        int[][] result = convertList.toArray(arrayList, 1);

        assertThat(result, is(checked));
    }

    /**
     * When transfer collection with four value and two row then return array 0123.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenTransferCollectionWithFourValueAndTwoRowThenReturnArray0123() throws Exception {

        ConvertList convertList = new ConvertList();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        int[][] checked = new int[2][2];
        checked[0][0] = 0;
        checked[0][1] = 1;
        checked[1][0] = 2;
        checked[1][1] = 3;

        int[][] result = convertList.toArray(arrayList, 2);

        assertThat(result, is(checked));
    }

    /**
     * When transfer collection with five value and three row then return array 012340.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenTransferCollectionWithFiveValueAndThreeRowThenReturnArray012340() throws Exception {

        ConvertList convertList = new ConvertList();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        int[][] checked = new int[3][3];
        checked[0][0] = 0;
        checked[0][1] = 1;
        checked[0][2] = 2;
        checked[1][0] = 3;
        checked[1][1] = 4;
        checked[1][2] = 0;
        checked[2][0] = 0;
        checked[2][1] = 0;
        checked[2][2] = 0;

        int[][] result = convertList.toArray(arrayList, 3);

        assertThat(result, is(checked));
    }

}