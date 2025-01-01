package org.example.SocialNetwork.classes;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class NewsDB {
    List<News> newsList = new LinkedList<>();

    public void createNews(String date, String title, String content, String author) {
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
        createNews("12.02.2023","Hello world", "World has been hellowed", "Jo biden))");
        createNews("17.12.2023","Hello world", "World has been hellowed again", "Jo biden))");
        createNews("28.12.2024","Hello world", "World has been hellowed again too", "Jo biden))");
        createNews("01.01.2025","Hello world", "World has been hellowed again too", "Jo biden))");
    }
}