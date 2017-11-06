package ru.af3412.generic;

/**
 * Created by AF on 21.10.2017.
 *
 * @param <E> the type parameter
 */
public class SimpleArray<E> {

    /**
     * The Objects.
     */
    private Object[] objects;
    /**
     * The Index.
     */
    private int index = 0;

    /**
     * Instantiates a new Simple list.
     *
     * @param size the size
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Gets size.
     *
     * @return the object size
     */
    public int getSize() {
        return objects.length;
    }

    /**
     * Add.
     *
     * @param value the value
     */
    public void add(E value) {
        indexCheck(index);
        this.objects[index++] = value;
    }

    /**
     * Get e.
     *
     * @param position the position
     * @return the e
     */
    public E get(int position) {
        indexCheck(position);
        return (E) this.objects[position];
    }

    /**
     * Update.
     *
     * @param position the position
     * @param value    the value
     */
    public void update(int position, E value) {
        indexCheck(position);
        this.objects[position] = value;
    }

    /**
     * Delete.
     *
     * @param position the position
     */
    public void delete(int position) {
        indexCheck(position);
        this.objects[position] = null;
    }

    /**
     * Checked size of array.
     *
     * @param position checked size of array length.
     */
    private void indexCheck(int position) {
        if (position > this.objects.length || position < 0) {
            throw new IndexOutOfBoundsException("Out of array length ");
        }
    }


}
