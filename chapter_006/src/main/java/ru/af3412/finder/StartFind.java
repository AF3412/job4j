package ru.af3412.finder;

/**
 * The type Start find.
 *
 * @author Filatov Alexander
 * @since 14.10.2016
 */
public class StartFind {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {


        System.out.println(args[0]);
        Find find = new Find(args);
        find.find();
    }

}
