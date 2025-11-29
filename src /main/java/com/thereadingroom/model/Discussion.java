package com.thereadingroom.model;

public class Discussion {

    private int id;
    private int bookId;
    private String title;

    public Discussion(int id, int bookId, String title) {
        this.id = id;
        this.bookId = bookId;
        this.title = title;
    }

    public Discussion(int bookId, String title) {
        this(-1, bookId, title);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
