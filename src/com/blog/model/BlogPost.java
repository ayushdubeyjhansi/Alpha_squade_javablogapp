package com.blog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogPost {
    public String title;
    public String content;
    public User author;
    public int likes;
    public List<String> comments; // Collections
    public Date timestamp;

    public BlogPost(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.likes = 0;
        this.comments = new ArrayList<>();
        this.timestamp = new Date();
    }
}