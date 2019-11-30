package com.example.organizer.model;

import java.util.ArrayList;
import java.util.List;

public class Note {
    private String date;
    private String category;
    private String content;

    public static List<Note> notes = new ArrayList<>();

    public Note() {}

    public Note(String content, String category, String date) {
        this.date = date;
        this.category = category;
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
