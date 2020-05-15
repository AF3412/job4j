package ru.af3412.softcache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mockito.internal.stubbing.answers.ThrowsException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoftFileCache {
    private static final Logger LOG = LogManager.getLogger(SoftFileCache.class.getName());
    private final Map<SoftReference<String>, SoftReference<File>> cache;

    public SoftFileCache() {
        this(10);
    }

    public SoftFileCache(int value) {
        cache = new HashMap<>(value);
    }

    public String get(String key) throws IOException {
        SoftReference<File> softFile = cache.get(new SoftReference<>(key));
        if (softFile == null) {
            softFile = new SoftReference<>(new File(key));
            cache.put(new SoftReference<>(key), softFile);
        }
        File file = softFile.get();
        if (file == null) {
            throw new FileNotFoundException();
        }
        try (Stream<String> stream = Files.lines(Paths.get(file.getPath()))) {
            return stream.collect(Collectors.joining());
        }
    }
}
