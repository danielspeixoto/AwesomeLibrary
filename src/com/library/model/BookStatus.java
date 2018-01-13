package com.library.model;

public class BookStatus implements Id {

    private final int id;
    private final int bookId;
    private boolean isAvailable;

    public BookStatus(int id, int bookId, boolean isAvailable) {
        this.id = id;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

