package ru.af3412.softcache;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.is;

public class SoftFileCacheTest {

    @Test
    public void whenStartProcessWithSizeThreeReturnSumElementSix() throws IOException {
        SoftFileCache softFileCache = new SoftFileCache();
        String a = softFileCache.get("names.txt");
        Assert.assertThat(a, is("John"));
    }

}