/**
 * Created by AF on 21.10.2017.
 *
 * @param <E> the type parameter
 */
public class SimpleList<E> {

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
    public SimpleList(int size) {
        this.objects = new Object[size];
    }

    /**
     * Add.
     *
     * @param value the value
     */
    public void add(E value) {
        this.objects[index++] = value;
    }

    /**
     * Get e.
     *
     * @param position the position
     * @return the e
     */
    public E get(int position) {
        return (E) this.objects[position];
    }

    /**
     * Update.
     *
     * @param position the position
     * @param value    the value
     */
    public void update(int position, E value) {
        this.objects[position] = value;
    }

    /**
     * Delete.
     *
     * @param position the position
     */
    public void delete(int position) {
        this.objects[position] = null;
    }


}
