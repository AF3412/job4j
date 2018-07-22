package ru.af3412.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by AF on 06.11.2017.
 */
public class UserTest {

    /**
     * When create user set id get return id.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenCreateUserSetIdGetReturnId() throws Exception {
        User user = new User();
        user.setId("1");
        String result = user.getId();
        assertThat(result, is("1"));
    }


}