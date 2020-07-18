package threads;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class FileDownload {
    public static void main(String[] args) {
        String url = args[0];
        String fileName = url.substring(url.lastIndexOf('/') + 1);
        int limit = Integer.parseInt(args[1]) * 1024;
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            long timer = System.currentTimeMillis();
            int loadSize = 0;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                loadSize += bytesRead;
                if (loadSize > limit) {
                    long timePassed = System.currentTimeMillis() - timer;
                    if (timePassed < 1000) {
                        Thread.sleep(1000 - timePassed);
                    }
                    timer = System.currentTimeMillis();
                    loadSize = 0;
                }

            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
