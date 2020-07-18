package threads;

public class ThreadState {
    public static void main(String[] args) {
        Thread first = new Thread(
                () -> {}
        );
        Thread second = new Thread(
                () -> {}
        );
        System.out.println("first: " + first.getName() + " second: " + second.getName());
        System.out.println("Threads first is: " + first.getState() + " Threads second is: " + second.getState());
        first.start();
        second.start();
        while (first.getState() != Thread.State.TERMINATED) {
            System.out.println("Threads first is " + first.getState());
        }
        while (second.getState() != Thread.State.TERMINATED) {
            System.out.println("Threads second is " + second.getState());
        }

        System.out.println("All threads is TERMINATED");
        System.out.println("Threads first is: " + first.getState() + " Threads second is: " + second.getState());
        System.out.println("Thread main is: " + Thread.currentThread().getState());
    }
}
