package ru.af3412.tdd;

import org.junit.Test;

/**
 * @author Filatov Alexander
 * @since 09.03.2017
 */
public class SimpleGeneratorTest {

   /* @Test
    public void generate() throws Exception {

        Template template = new SimpleGenerator();

        String text = "Hello, ${name}.";

    }*/

   @Test
    public void testRegex() {
       SimpleGenerator sg = new SimpleGenerator();
       sg.testRegex("${name}");
   }

}