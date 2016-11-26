package ru.af3412.fifth;

import java.io.*;
import java.util.Random;

/**
 * The type Chat.
 *
 * @author Filatov Alexander
 * @since 23.09.2016
 */
public class Chat {

    private final Random rnd = new Random(System.currentTimeMillis());

    /**
     * Загружаю файл в строку, возвращаю случайную строку. Новая строка та, что разделена "Enter"
     *
     * @param file Файл, который переводится в строку
     * @return случайная строка из файла
     * @throws IOException the io exception
     */
    public String[] getArrayStringFromFile(File file) throws IOException {
        BufferedReader myfile = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line;

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
        return (line.split("\n"));

    }

    /**
     * Gets random string.
     *
     * @param string the string
     * @return the random string
     */
    public String getRandomString(String[] string) {
        return string[rnd.nextInt(string.length)];
    }

    /**
     * Метод logic Читает консоль, выводит случайную строку, записывает лог в файл output.txt.
     * <p>
     * При инициализации обращается к методу getArrayStringFromFile и возвращает из файла массив строк;
     * метод getRandomString возвращает случайную строку из массива строк;
     * PrintWriter pw пишет все, что выводится в консоль;
     * StringBuilder sb сохраняет данные для вывода на консоль и передачи в PrintWriter pw;
     * String stringIn является строкой, которую вводит пользователь.
     * Используется для работы с управляющими командами 'стоп', 'продолжить' и 'выход';
     * String randomString получает случайную строку из файла.
     * boolean stop является индикатором выводить случайную строку или нет.
     *
     * @param fileIn  задает файл, откуда брать ответы
     * @param fileOut задает файл, куда писать лог
     * @throws IOException the io exception
     */
    public void start(File fileIn, File fileOut) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrayRandomString = getArrayStringFromFile(fileIn);
        PrintWriter pw = new PrintWriter(fileOut);
        StringBuilder sb = new StringBuilder();
        String stringIn;
        String randomString;
        boolean stop = false;
        System.out.println("Программа консольный чат. Команды: 'стоп', 'продолжить' и 'выход'");
        do {
            stringIn = br.readLine();
            sb.append(stringIn).append("\n");

            if (stringIn.equals("стоп")) {
                stop = true;
            }
            if (stringIn.equals("продолжить")) {
                stop = false;
            }
            if (!stop) {
                randomString = getRandomString(arrayRandomString);
                System.out.println(randomString);
                sb.append(randomString);
            }

            pw.println(sb.toString());
            sb.delete(0, sb.length());

        } while (!stringIn.equals("выход"));
        pw.flush();
        pw.close();

    }


}