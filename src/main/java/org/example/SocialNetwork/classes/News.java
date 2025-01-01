package org.example.SocialNetwork.classes;

import java.util.Stack;

public class News {
    private final String date;
    private String title;
    private String content;
    private final String author;

    Stack<News> newsStack = new Stack<News>();

    public News(String date, String title, String content, String author) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.author = author;
    }
    @Override
    public String toString() {
        return "date=" + date + ", title=" + title + ", content=" + content + ", author=" + author;
    }
}
