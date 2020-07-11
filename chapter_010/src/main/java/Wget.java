public class Wget {
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                    try {
                        for (int i = 0; i < 100; i++) {
                            System.out.print("\rLoading : " + i  + "%");
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
        );
        thread.start();
        System.out.println("Start load process");
    }
}
