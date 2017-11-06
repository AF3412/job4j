package ru.af3412.generic;

/**
 * Created by AF on 02.11.2017.
 *
 * @param <E> the type parameter
 */
public abstract class AbstractStore<E extends Base> {

    /**
     * Add boolean.
     *
     * @param array the array
     * @param model the model
     * @return the boolean
     */
    boolean add(SimpleArray array, E model) {
        boolean result = false;
        try {
            array.add(model);
            result = true;
        } catch (IndexOutOfBoundsException e) {
            System.out.printf("Out of index %s%n", e);
        }
        return result;
    }

    /**
     * Update e.
     *
     * @param array the array
     * @param id    the id
     * @param model the model
     * @return the e
     */
    E update(SimpleArray<E> array, String id, E model) {
        E result = model;
        try {
            int position = this.findIdPosition(array, id);
            result = array.get(position);
            array.update(position, model);
        } catch (IndexOutOfBoundsException e) {
            System.out.printf("Out of index %s%n", e);
        }
        return result;
    }

    /**
     * Delete boolean.
     *
     * @param array the array
     * @param id    the id
     * @return the boolean
     */
    boolean delete(SimpleArray array, String id) {
        boolean result = false;
        try {
            int position = this.findIdPosition(array, id);
            array.delete(position);
            result = true;
        } catch (IndexOutOfBoundsException e) {
            System.out.printf("Out of index %s%n", e);
        }
        return result;
    }

    /**
     * Gets value.
     *
     * @param array the array
     * @param id    the id
     * @return the value
     */
    E getValue(SimpleArray<E> array, String id) {
        return array.get(findIdPosition(array, id));
    }

    /**
     * Find value by id.
     *
     * @param array is SimpleArray
     * @param id is String value of id
     * @return find position or "-1" if value not find
     */
    private int findIdPosition(SimpleArray<E> array, String id) {
        int result = -1;
        try {
            for (int i = 0; i < array.getSize(); i++) {
                if (array.get(i).getId().equals(id)) {
                    result = i;
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.out.printf("Value not find %n%s%n", e);
        }
        return result;
    }

}
