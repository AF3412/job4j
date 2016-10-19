package ru.af3412.finder;


import java.io.File;

/**
 * Searches for the full file name
 */
public class FindByFullName {

    private StringBuilder sb = new StringBuilder();

    /**
     * @param path     is start path for search file
     * @param findFile is the file that must be found
     * @return a string with the search results
     */
    protected String find(String path, String findFile) {

        System.out.println("Search...");
        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) {
            sb.append("File not found");
        } else {
            for (File file : list) {
                if (file.isDirectory()) {
                    find(file.getAbsolutePath(), findFile);
                } else {
                    if (file.getName().equals(findFile)) {
                        sb.append(file.getAbsoluteFile()).append("\n");
                    }
                }
            }
        }

        return sb.toString();

    }

}
