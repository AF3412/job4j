package ru.af3412.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

/**
 * Created by AF on 12.11.2017.
 */
public class RoleStoreTest {

    /**
     * Role store for all test.
     */
    private RoleStore<Role> roleStore;

    /**
     * Create data.
     */
    @Before
    public void createData() {
        roleStore = new RoleStore<>();
    }

    /**
     * When add new role return true.
     *
     */
    @Test
    public void whenAddNewRoleReturnTrue() {
        Role role = new Role();
        role.setId("1");
        boolean result = roleStore.add(role);

        assertThat(result, is(true));

    }

    /**
     * When add new role this role returned in get method.
     *
     */
    @Test
    public void whenAddNewRoleThisRoleReturnedInGetMethod() {
        Role role = new Role();
        role.setId("1");
        roleStore.add(role);

        Role result = (Role) roleStore.getValue("1");

        assertThat(result, is(role));

    }

    /**
     * When update value in storage then value is changed.
     *
     */
    @Test
    public void whenUpdateValueInStorageThenValueIsChanged() {
        Role role = new Role();
        Role anotherRole = new Role();
        role.setId("0");
        anotherRole.setId("1");
        roleStore.add(role);

        roleStore.update("0", anotherRole);
        Role result = (Role) roleStore.getValue("1");

        assertThat(result, is(anotherRole));
    }

    /**
     * When delete value this value not find in storage.
     *
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenDeleteValueThisValueNotFindInStorage() {

        Role role = new Role();
        role.setId("0");
        roleStore.add(role);

        roleStore.delete("0");

        Role result = (Role) roleStore.getValue("0");

        assertNull(result);
    }


}