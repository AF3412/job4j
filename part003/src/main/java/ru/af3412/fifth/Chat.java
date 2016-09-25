package ru.af3412.fifth;

import java.io.*;
import java.util.Random;

/**
 * @author Filatov Alexander
 * @since 23.09.2016
 */
public class Chat {

    private final Random rnd = new Random(System.currentTimeMillis());

    /**
     * Загружаю файл в строку, возвращаю случайную строку. Новая строка та, что разделена "Enter"
     * @param file Файл, который переводится в строку
     * @return случайная строка из файла
     * @throws IOException
     */
    public String getStringFromFile(File file) throws IOException {
        BufferedReader myfile = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line;
        String[] arrayLine;

        try {
            while ((line = myfile.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                myfile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        line = sb.toString();
        arrayLine = line.split("\n");
        return arrayLine[rnd.nextInt(arrayLine.length)];

    }

    /**
     * Читает консоль, выводит случайную строку.
     * @param file
     * @throws IOException
     */
    public void start(File file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File fileOut = new File("data\\fileOut");
        PrintWriter pw = new PrintWriter("data\\output.txt");
        String string;
        boolean stop = false;
        System.out.println("Программа консольный чат. Команды: 'стоп', 'продолжить' и 'выход'");
        for (; ; ) {
            string = (String) br.readLine();
            if (string.equals("выход")) {
                break;
            }
            if (string.equals("стоп")) {
                stop = true;
            }
            if (string.equals("продолжить")) {
                stop = false;
            }
            if (!stop) {
                System.out.println(this.getStringFromFile(file));
            }
            pw.println(System.out);


        }


    }


}