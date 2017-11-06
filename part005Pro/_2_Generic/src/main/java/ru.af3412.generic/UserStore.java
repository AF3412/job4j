package ru.af3412.generic;

/**
 * Created by AF on 22.10.2017.
 */
public class UserStore extends AbstractStore implements Store<User> {

    /**
     * Is SimpleArray storage for User.
     */
    private SimpleArray<User> store = new SimpleArray<>(10);

    @Override
    public boolean add(User user) {
        return super.add(this.store, user);
    }

    @Override
    public User update(String id, User model) {
        return (User) super.update(this.store, id, model);
    }

    @Override
    public boolean delete(String id) {
        return super.delete(this.store, id);
    }

    /**
     * Gets user.
     *
     * @param id the id
     * @return the user
     */
    public User getUser(String id) {
        return (User) super.getValue(this.store, id);
    }

}
