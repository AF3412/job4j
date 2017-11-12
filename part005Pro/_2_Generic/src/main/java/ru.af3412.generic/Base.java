package ru.af3412.generic;

/**
 * Created by AF on 22.10.2017.
 */
public abstract class Base {

    /**
     * "id" is identificator.
     */
    private String id;

    /**
     * Sets id.
     *
     * @param id the id
     */
     void setId(String id) {
         this.id = id;
     }

    /**
     * Gets id.
     *
     * @return the id
     */
    String getId() {
        return this.id;
    }

}
