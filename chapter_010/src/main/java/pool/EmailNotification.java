package pool;

import java.text.MessageFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {

    private final ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public void emailTo(User user) {
        pool.submit(
                () -> send(getSubject(user), getBody(user), user.getEmail())
        );
    }

    public void send(String suject, String body, String email) {

    }

    public void close() {
        pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    private String getSubject(User user) {
        return MessageFormat.format("Notification {0} to email {1}", user.getUserName(), user.getEmail());
    }

    private String getBody(User user) {
        return MessageFormat.format("Add a new event to {0}", user.getUserName());
    }

}
