package ru.af3412.generic;

/**
 * Created by AF on 22.10.2017.
 */
public class User extends Base {

    /**
     * "id" is identificator.
     */
    private String id;

    @Override
    void setId(String id) {
        this.id = id;
    }

    @Override
    String getId() {
        return this.id;
    }

}
