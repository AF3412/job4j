package ru.af3412.generic;

/**
 * Created by AF on 22.10.2017.
 *
 * @param <T> the type parameter
 */
public interface Store<T extends Base> {

    /**
     * Add boolean.
     *
     * @param model the model
     * @return the boolean
     */
    boolean add(T model);

    /**
     * Update t.
     *
     * @param id    the id
     * @param model the model
     * @return the t
     */
    T update(String id, T model);

    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean delete(String id);

}
