package ru.af3412.grabber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class SqlRuParse implements Parse {

    private static final Logger LOG = LogManager.getLogger(Parse.class.getName());
    private static final String USER_AGENT = "Mozilla";
    private static final int TIMEOUT = 10000;

    /**
     * Get list posts from link site with job list
     * @param link is site url
     * @return list with vacancy with name and job link; or empty list if vacancy not find
     */
    @Override
    public List<Post> list(String link) {
        List<Post> result;
        try {
            Document document = getHtmlPage(link);
            result = new ArrayList<>();
            Elements htmlRows = document.select(".forumTable > tbody > tr");
            for (Element htmlRow : htmlRows) {
                Elements cells = htmlRow.select("td");
                if (cells.size() == 6 && isJavaVacancy(cells.get(1).text())) {
                    var name = cells.get(1).text();
                    var postLink = cells.get(1).select("a").first().attr("href");
                    Post post = new Post(name, postLink);
                    result.add(post);
                }
            }
        } catch (IOException e) {
            LOG.error("Connection problem. {}", e.getMessage(), e);
            result = Collections.emptyList();
        }
        return result;
    }

    /**
     * Get detail vacancy post
     * @param link is site url with vacancy description
     * @return post with detail job description
     */
    @Override
    public Post detail(String link) {
        Post result;
        try {
            Document document = getHtmlPage(link);
            var name = document.select(".messageHeader").first().text();
            var text = document.select(".msgTable > tbody > tr > td.msgbody").get(1).text();
            result = new Post(name, text, link);
        } catch (IOException e) {
            LOG.error("Connection problem. {}", e.getMessage(), e);
            result = null;
        }
        return result;
    }

    /**
     * Get html page from link
     * @param link is site url
     * @return return raw(jsoup) html document
     * @throws IOException if site not found or time out;
     */
    public Document getHtmlPage(String link) throws IOException {
        return Jsoup.connect(link)
                .timeout(TIMEOUT)
                .userAgent(USER_AGENT)
                .get();
    }

    /**
     * Check that text is vacancy description for java-developer
     * @param text is String vacancy name
     * @return true if vacancy for java(not javascript) developer
     */
    private boolean isJavaVacancy(String text) {
        return Pattern.compile(Pattern.quote("JAVA"), Pattern.CASE_INSENSITIVE).matcher(text).find();
    }

}
