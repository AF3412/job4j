package ru.af3412.finder;


import java.io.File;

/**
 * Searches for the full file name
 */
public class FindByFullName {

    private StringBuilder sb = new StringBuilder();
    private String findFile;

    public FindByFullName(String findFile) {
        this.findFile = findFile;
    }

    /**
     * @param path     is start path for search file
     * @return a string with the search results
     */
    protected String find(String path) {

        System.out.println("Search...");
        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) {
            sb.append("File not found");
        } else {
            for (File file : list) {
                if (file.isDirectory()) {
                    find(file.getAbsolutePath());
                } else {
                    if (file.getName().equals(this.findFile)) {
                        sb.append(file.getAbsoluteFile()).append("\n");
                    }
                }
            }
        }

        return sb.toString();

    }

}
