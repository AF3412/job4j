package ru.af3412.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDI {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.af3412.di");
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
        System.out.println("--------------");

        Store store = context.getBean(Store.class);
        store.add("Alex Alex");
        Store another = context.getBean(Store.class);
        System.out.println("Print all strings from bean 'store'");
        another.getAll().forEach(System.out::println);
    }

}
