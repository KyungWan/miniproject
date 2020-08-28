package com.example.Lecture.service;

import com.example.Lecture.entity.ClickedNews;
import com.example.Lecture.entity.HomeNews;
import com.example.Lecture.entity.News;
import com.example.Lecture.repository.ClickedNewsRepository;
import com.example.Lecture.repository.HomeNewsRepository;
import com.example.Lecture.repository.NewsRepository;
import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Log
public class NewsCrawlService {
    @Autowired
    NewsRepository newsRepository;

    @Autowired
    HomeNewsRepository homeNewsRepository;

    @Autowired
    ClickedNewsRepository clickedNewsRepository;

    private Document document;

    public Document connectUrl(String url) {
        log.info("connectUrl(): " + url);

        try {
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozila/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20100101 " +
                            "Firefox/10.0 AppleWebKit/537.36 (KHTML, like Gecko) " +
                            "Chrome/51.0.2704.103 Safari/537.36")
                    .execute();

            document = homepage.parse();
        } catch (Exception e) {
            System.out.println("Error in mainCrawler");
        }

        return document;
    }

    public List<News> newsFindAll() {
        log.info("newsFindAll()");

        return newsRepository.findAll();
    }

    public List<HomeNews> homeNewsFindAll() {
        log.info("homeNewsFindAll()");

        return homeNewsRepository.findAll();
    }

    public void crawlingHome() {
        log.info("crawlingHome()");

        homeNewsRepository.deleteAll();
        document = connectUrl("http://finance.daum.net/");

        Elements total = document.select("strong.tit_thumb>a.link_txt");
        Elements image = document.select("div.thumb>a>img.fullWidth");

        HomeNews homeNews = null;

        for (int i = 0; i < total.size(); i++) {
            homeNews = new HomeNews();
            homeNews.setHomeNewsNo(String.valueOf(i + 1));
            homeNews.setTitle(total.get(i).text());
            homeNews.setAddress(total.get(i).attr("href"));
            homeNews.setImage(image.get(i).attr("src"));
            homeNewsRepository.save(homeNews);
        }
    }

    public void mainCrawler(String category) {
        log.info("mainCrawler(): " + category);

        document = connectUrl("http://finance.daum.net/" + category);

        newsRepository.deleteAll();

        daumNews(document.select("div.topNews>div.imgB.f_clear>div.txtB>a.tit"), category);
        daumNews(document.select("div.newsB>div.box_contents>div>ul.list>li>a"), category);
        daumNews(document.select("div.halfB>ul.fl>li>a"), category);
        daumNews(document.select("li>span>a.tit"), category);
        daumNews(document.select("div.topNews.tableB>div.txtB>a.tit"), category);
        daumNews(document.select("div.box_contents>ul.listW.first>li.imgB>span>a.tit"), category);
//        daumNews(document.select(""), category);
//        daumNews(document.select(""), category);
//        daumNews(document.select(""), category);
//        daumNews(document.select(""), category);
    }

    public void daumNews(Elements elements, String category) {
        log.info("daumNews(): elements - " + elements + ", category - " + category);

        News news = null;

        for (int i = 0; i < elements.size(); i++) {
            news = new News();

            news.setNewsNo(String.valueOf(newsRepository.findAll().size() + 1));
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory(category);
            news.setTitle(elements.get(i).text());

            newsRepository.save(news);
        }
    }

    public ClickedNews crawlingOne(String newsNo) {
        log.info("crawlingOne(): " + newsNo);

        News news = newsRepository.findByNewsNo(newsNo);

        ClickedNews clickedNews = new ClickedNews();

        clickedNews.setTitle(news.getTitle());
        clickedNews.setCategory(news.getCategory());
        clickedNews.setAddress(news.getAddress());
        clickedNews.setClickedNewsNo(String.valueOf(clickedNewsRepository.findAll().size() + 1));

        document = connectUrl(clickedNews.getAddress());

        clickedNews.setDate(document.select("span.num_date").text());
        clickedNews.setContents(document.select("div.article_view>section>:not(figure)").text());

        clickedNewsRepository.save(clickedNews);

        return clickedNews;
    }
}
