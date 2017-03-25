package ru.af3412.tdd;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Филатов on 23.03.2017.
 */
public class SimpleGeneratorTest {

    /**
     * When set one key return one value.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenSendSNameReturnValueFromMap() throws Exception {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}.";
        Map<String, String> data = new HashMap<>();
        data.put("name", "Alex");
        String checked = "Hello, Alex.";

        String result = template.generate(text, data);

        assertThat(result, is(checked));
    }

    /**
     * When send two s name return value from map.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenSendTwoSNameReturnValueFromMap() throws Exception {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}. I'm ${name2}.";
        Map<String, String> data = new HashMap<>();
        data.put("name", "Alex");
        data.put("name2", "Joe");
        String checked = "Hello, Alex. I'm Joe.";

        String result = template.generate(text, data);

        assertThat(result, is(checked));
    }

    /**
     * When send two s name and name two between name one return value from map.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenSendTwoSNameAndNameTwoBetweenNameOneReturnValueFromMap() throws Exception {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}. I'm ${name2}. How are you, ${name}?";
        Map<String, String> data = new HashMap<>();
        data.put("name", "Alex");
        data.put("name2", "Joe");
        String checked = "Hello, Alex. I'm Joe. How are you, Alex?";

        String result = template.generate(text, data);

        assertThat(result, is(checked));
    }


    /**
     * When send three identical values all changes.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenSendThreeIdenticalValuesAllChanges() throws Exception {
        Template template = new SimpleGenerator();
        String text = "AAA, ${sos}, ${sos}, ${sos}! Help me!";
        Map<String, String> data = new HashMap<>();
        data.put("sos", "SOS");
        String checked = "AAA, SOS, SOS, SOS! Help me!";

        String result = template.generate(text, data);

        assertThat(result, is(checked));
    }


    /**
     * When send s name without values from map return exception.
     *
     * @throws Exception the exception
     */
    @Test(expected = TemplateException.class)
    public void whenSendSNameWithoutValuesFromMapReturnException() throws Exception {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}.";
        Map<String, String> data = new HashMap<>();
        data.put("subject", "Alex");

        template.generate(text, data);
    }


    /**
     * When send s name and in the map contains too much values return exception.
     *
     * @throws Exception the exception
     */
    @Test(expected = TemplateException.class)
    public void whenSendSNameAndInTheMapContainsTooMuchValuesReturnException() throws Exception {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}.";
        Map<String, String> data = new HashMap<>();
        data.put("subject", "Alex");
        data.put("name", "Joe");

        template.generate(text, data);
    }


}