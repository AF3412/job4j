package ru.af3412.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by AF on 06.11.2017.
 */
public class RoleTest {

    /**
     * When create role set id get return id.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenCreateRoleSetIdGetReturnId() throws Exception {
        Role role = new Role();
        role.setId("1");
        String result = role.getId();
        assertThat(result, is("1"));
    }

}