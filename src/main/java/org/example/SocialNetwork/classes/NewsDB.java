package org.example.SocialNetwork.classes;

import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.time.LocalDate;

@Service
public class NewsDB {
    List<News> newsList = new LinkedList<>();
    LocalDate currentTime = LocalDate.now();

    // Adding News with explicit indication of this date
    public void addNews(String title, String content, String author) {
        newsList.add(new News(currentTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), title, content, author));
    }
    // Adding News without explicit indication of this date
    public void addNews(String date, String title, String content, String author) {
        newsList.add(new News(date, title, content, author));
    }

    public List[] getNewsList(){
        LinkedList<String> allNews = new LinkedList<>();
        LinkedList<String> lastNews = new LinkedList<>();

        for(int i = 0; i < newsList.size(); i++){
            allNews.addFirst(newsList.get(i).toString());
            // Getting 3 least news from newsList
            if(i > newsList.size()-4) lastNews.addFirst(newsList.get(i).toString());
        }
        return new List[]{allNews, lastNews};
    }
    // init data
    {
        // with date
        addNews("12.02.2023","Hello world", "World has been hellowed", "Jo biden))");
        addNews("17.12.2023","Hello world", "World has been hellowed again", "Jo biden))");
        addNews("28.12.2024","Hello world", "World has been hellowed again too", "Jo biden))");
        // without date
        addNews("Hello world", "World has been hellowed again too", "Jo biden))");
    }
}