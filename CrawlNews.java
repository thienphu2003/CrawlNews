import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {
    private static final String URL = "https://dantri.com.vn/the-gioi.htm";
    private static final String REGEX = "<h3 class=\"title-news\"><a href=\"(.*?)\".*?>(.*?)</a></h3>";

    public static ArrayList<News> getNews() throws IOException {
        ArrayList<News> newsList = new ArrayList<>();

        URLConnection connection = new URL(URL).openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            newsList.add(new News(matcher.group(1), matcher.group(2)));
        }

        return newsList;
    }
}

class News {
    private String link;
    private String title;

    public News(String link, String title) {
        this.link = link;
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}