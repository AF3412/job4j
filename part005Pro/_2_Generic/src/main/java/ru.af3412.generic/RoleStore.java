package ru.af3412.generic;

/**
 * Created by AF on 22.10.2017.
 */
public class RoleStore extends AbstractStore implements Store<Role> {

    /**
     * Is SimpleArray storage for Role.
     */
    private SimpleArray<Role> store = new SimpleArray<>(10);

    @Override
    public boolean add(Role model) {
        return super.add(store, model);
    }

    @Override
    public Role update(String id, Role model) {
        return (Role) super.update(this.store, id, model);
    }

    @Override
    public boolean delete(String id) {
        return super.delete(this.store, id);
    }

}
