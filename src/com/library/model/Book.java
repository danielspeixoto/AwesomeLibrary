package com.library.model;

public class Book implements Id {

    private final int id;
    private String name;
    private String publisher;
    private String author;
    private int edition;
    private int publicationYear;

    public Book(int id, String name, String publisher, String author, int edition, int publicationYear) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.author = author;
        this.edition = edition;
        this.publicationYear = publicationYear;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    public int getEdition() {
        return edition;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
