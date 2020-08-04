package atom;

import java.io.*;

public class ParseFile {
    private File file;

    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized String getContent() throws IOException {
        StringBuilder output = new StringBuilder();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {
            int data = bufferedInputStream.read();
            while (data != -1) {
                data = bufferedInputStream.read();
                output.append((char) data);
            }
        }
        return output.toString();
    }

    public synchronized String getContentWithoutUnicode() throws IOException {
        StringBuilder output = new StringBuilder();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {
            int data = bufferedInputStream.read();
            while (data != -1) {
                if (data < 0x80) {
                    data = bufferedInputStream.read();
                    output.append((char) data);
                }

            }
        }
        return output.toString();
    }

    public synchronized void saveContent(String content) throws IOException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < content.length(); i++) {
                bufferedOutputStream.write(content.charAt(i));
            }
        }
    }
}
