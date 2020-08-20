package wait;

public class ParallelSearch {

    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(1);
        final Thread consumer = new Thread(
                () -> {
                    while (true) {
                        if (Thread.currentThread().isInterrupted()) {
                            break;
                        }
                        try {
                            Thread.sleep(1000);
                            System.out.println(queue.poll());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        consumer.start();

        new Thread(
                () -> {
                    for (int index = 0; index != 3; index++) {
                        queue.offer(index);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }

        ).start();

        while (true) {
            if (consumer.getState() == Thread.State.WAITING) {
                consumer.interrupt();
                break;
            }
        }
    }

}
