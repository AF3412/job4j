package wait;

public class CountBarrierMain {
    public static void main(String[] args) {
        int total = 3;
        CountBarrier countBarrier = new CountBarrier(total);
        Thread first = new Thread(
                () -> {
                    countBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " started");
                },
                "First"
        );
        Thread second = new Thread(
                () -> {
                    countBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " started");
                },
                "Second"
        );
        Thread third = new Thread(
                () -> {
                    for (int i = 0; i < total; i++) {
                        countBarrier.count();
                    }
                    System.out.println(Thread.currentThread().getName() + " started");
                },
                "Third"
        );
        first.start();
        second.start();
        third.start();
    }
}
