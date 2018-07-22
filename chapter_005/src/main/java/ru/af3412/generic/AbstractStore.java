package ru.af3412.generic;

/**
 * Created by AF on 02.11.2017.
 *
 * @param <E> the type parameter
 */
public abstract class AbstractStore<E extends Base> implements Store<E> {


    /**
     * The Store.
     */
    private SimpleArray<E> store = new SimpleArray<>(10);

    /**
     * Gets store.
     *
     * @return the store
     */
    public SimpleArray<E> getStore() {
        return store;
    }

    /**
     * Add boolean.
     *
     * @param model the model
     * @return the boolean
     */
    @Override
    public boolean add(E model) {
        boolean result = false;
        try {
            store.add(model);
            result = true;
        } catch (IndexOutOfBoundsException e) {
            System.out.printf("Out of index %s%n", e);
        }
        return result;
    }

    /**
     * Update e.
     *
     * @param id    the id
     * @param model the model
     * @return the e
     */
    @Override
    public E update(String id, E model) {
        E result = model;
        try {
            int position = this.findIdPosition(id);
            result = store.get(position);
            store.update(position, model);
        } catch (IndexOutOfBoundsException e) {
            System.out.printf("Out of index %s%n", e);
        }
        return result;
    }

    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        try {
            int position = this.findIdPosition(id);
            store.delete(position);
            result = true;
        } catch (IndexOutOfBoundsException e) {
            System.out.printf("Out of index %s%n", e);
        }
        return result;
    }

    /**
     * Gets value.
     *
     * @param id the id
     * @return the value
     */
    E getValue(String id) {
        return store.get(findIdPosition(id));
    }

    /**
     * Find value by id.
     *
     * @param id is String value of id
     * @return find position or "-1" if value not find
     */
    private int findIdPosition(String id) {
        int result = -1;
        try {
            for (int i = 0; i < store.getSize(); i++) {
                if (store.get(i).getId().equals(id)) {
                    result = i;
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.out.printf("Value not find. %s%n", e);
        }
        return result;
    }

}
