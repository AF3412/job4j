package ru.af3412.finder;

/**
 * @author Filatov Alexander
 * @since 14.10.2016
 */
public class StartFind {

    public static void main(String[] args) {


        System.out.println(args[0]);
        Find find = new Find(args);
        find.find();
    }

}
