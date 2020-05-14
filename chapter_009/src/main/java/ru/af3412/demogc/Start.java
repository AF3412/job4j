package ru.af3412.demogc;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        //Thread.sleep(20_000);
        for (int i = 0; i < 1600000; i++) {
            new User();
        }
    }
}

class User {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
        super.finalize();
    }
}

