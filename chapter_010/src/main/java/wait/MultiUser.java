package wait;

public class MultiUser {
    public static void main(String[] args) {
        Barrier barrier = new Barrier();
        Thread slave = new Thread(
                () -> {
                    barrier.check();
                    System.out.println(Thread.currentThread().getName() + " started");
                },
                "Slave"
        );
        Thread master = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");
                    barrier.on();
                },
                "Master"
        );
        slave.start();
        master.start();

    }
}
