import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<News> newsList = new ArrayList<>();
        try
        {
            newsList=CrawlNews.getNews();
            System.out.println(newsList);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
