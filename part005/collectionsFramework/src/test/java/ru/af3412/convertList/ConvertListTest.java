package ru.af3412.convertList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        int[][] array = {{0}};

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
        int[][] array = {{0, 1}, {2, 3}};
        List<Integer> checked = Arrays.asList(0, 1, 2, 3);

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
        int[][] array = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        List<Integer> checked = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);

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
        List<Integer> arrayList = Arrays.asList(0);
        int[][] checked = {{0}};

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
        List<Integer> arrayList = Arrays.asList(0, 1);
        int[][] checked = {{0, 1}};

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
        List<Integer> arrayList = Arrays.asList(0, 1, 2, 3);
        int[][] checked = {{0, 1}, {2, 3}};

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
        List<Integer> arrayList = Arrays.asList(0, 1, 2, 3, 4);
        int[][] checked = {{0, 1}, {2, 3}, {4, 0}};

        int[][] result = convertList.toArray(arrayList, 3);

        assertThat(result, is(checked));
    }

    /**
     * When transfer list with two array return all valuesin array list.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenTransferListWithTwoArrayReturnAllValuesinArrayList() throws Exception {

        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> checked = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> result = convertList.convert(list);

        assertThat(result, is(checked));

    }

    /**
     * When transfer list with one array return values from this array.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenTransferListWithOneArrayReturnValuesFromThisArray() throws Exception {

        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList();
        list.add(new int[]{1, 2});
        List<Integer> checked = Arrays.asList(1, 2);

        List<Integer> result = convertList.convert(list);

        assertThat(result, is(checked));

    }

}