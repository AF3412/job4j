package ru.af3412.finder;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/**
 * The type Find by mask.
 *
 * @author Filatov Alexander
 * @since 20.10.2016
 */
public class FindByMask {

    private StringBuilder sb = new StringBuilder();

    /**
     * The Matcher.
     */
    PathMatcher matcher;

    /**
     * Instantiates a new Find by mask.
     *
     * @param findFile the find file
     */
    public FindByMask(String findFile) {

        this.matcher = FileSystems.getDefault().getPathMatcher("glob:" + findFile);
        System.out.print(findFile);

    }

    /**
     * Find string.
     *
     * @param path the path
     * @return the string
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
                    if (matcher.matches(Paths.get(file.getName()))) {
                        sb.append(file.getAbsoluteFile()).append("\n");
                    }
                }
            }
        }

        return sb.toString();

    }

}
