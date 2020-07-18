package threads;

public class ConsoleProgress implements Runnable {

    @Override
    public void run() {
        String twistVal = "-";
        while (!Thread.currentThread().isInterrupted()) {
            System.out.print("\r" + twistVal);
            twistVal = twist(twistVal);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        Thread.sleep(10000);
        progress.interrupt();
    }

    private String twist(String value) {
        switch (value) {
            case "-":
                return "\\";
            case "\\":
                return "|";
            case "|":
                return "/";
            default:
                return "-";
        }
    }

}
