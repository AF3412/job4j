package ru.af3412.grabber;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class SqlRuParseTest {

    @Test
    public void whenGetListPostFromLinkThenReturnListThatPosts() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(requireNonNull(classLoader.getResource("job_offers_sql_ru.html")).getFile());
        Document stubDoc = Jsoup.parse(file, "Windows-1251");
        SqlRuParse parserMock = spy(SqlRuParse.class);
        doReturn(stubDoc).when(parserMock).getHtmlPage(any());
        List<Post> list = parserMock.list("https://www.sql.ru/forum/job-offers/1");
        assertThat(list.size(), is(7));
    }

    @Test
    public void whenGetDetailPostFromLinkThatReturnThisPostText() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(requireNonNull(classLoader.getResource("detail_sql_ru.html")).getFile());
        Document stubDoc = Jsoup.parse(file, "Windows-1251");
        SqlRuParse parseMock = spy(SqlRuParse.class);
        doReturn(stubDoc).when(parseMock).getHtmlPage(any());
        Post post = parseMock.detail("https://www.sql.ru/forum/1324128/java-razrabotchik");
        assertTrue(post.getText().contains("В СИБУР"));
    }
}