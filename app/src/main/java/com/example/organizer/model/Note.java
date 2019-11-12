package com.example.organizer.model;

import java.util.ArrayList;
import java.util.List;

public class Note {
    private static int count = 0;
    private int id = 0;

    private String date;
    private String category;
    private String content;

    public static List<Note> notes = new ArrayList<>();

    public Note() {}

    public Note(String date, String category, String content) {
        id = count++;

        this.date = date;
        this.category = category;
        this.content = content;
    }

    public void addNote() {
        notes.add(this);
    }

    @Override
    public String toString() {
        return "Id = " + id + " date: " + date + " category: " + category + " content: " + content;
    }

    public int getiD() {
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
