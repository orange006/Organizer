package com.example.organizer.model;

import java.util.ArrayList;
import java.util.List;

public class Note {
    private String id;
    private String date;
    private String category;
    private String content;

    public static List<Note> notes = new ArrayList<>();

    public Note() {}

    public Note(String id, String content, String category, String date) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.content = content;
    }

    public String getId() {
        return id;
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

}