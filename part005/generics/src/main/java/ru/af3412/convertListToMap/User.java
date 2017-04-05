package ru.af3412.convertListToMap;

/**
 * Created by Филатов on 05.04.2017.
 */
public class User {

    /**
     * User Id.
     */
    private Integer id;

    /**
     * User name.
     */
    private String name;

    /**
     * User city.
     */
    private String city;

    /**
     * Instantiates a new User.
     *
     * @param id   the id
     * @param name the name
     * @param city the city
     */
    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }
}
