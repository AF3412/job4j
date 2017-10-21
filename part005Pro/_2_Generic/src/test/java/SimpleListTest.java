import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

/**
 * Created by AF on 21.10.2017.
 */
public class SimpleListTest {

    /**
     * When create container should return string.
     */
    @Test
    public void whenCreateContainerShouldReturnString() {

        SimpleList<String> list = new SimpleList<>(4);
        list.add("test");

        String result = list.get(0);

        assertThat(result, is("test"));
    }

    /**
     * When create container should return integer.
     */
    @Test
    public void whenCreateContainerShouldReturnInteger() {

        SimpleList<Integer> simpleList = new SimpleList<>(4);

        simpleList.add(1);
        int result = simpleList.get(0);

        assertThat(result, is(1));
    }

    /**
     * When update element return new value.
     */
    @Test
    public void whenUpdateElementReturnNewValue() {
        SimpleList<Integer> simpleList = new SimpleList<>(4);

        simpleList.add(1);
        simpleList.update(0, 2);
        int result = simpleList.get(0);

        assertThat(result, is(2));
    }

    /**
     * When delete element return null.
     */
    @Test
    public void whenDeleteElementReturnNull() {
        SimpleList<Integer> simpleList = new SimpleList<>(4);

        simpleList.add(1);
        simpleList.delete(0);

        assertNull(simpleList.get(0));
    }

}
