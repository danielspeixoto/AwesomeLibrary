package com.library.result;

public class BookNotAvailable extends Result {

    public BookNotAvailable(String book) {
        super("O livro " + book + " nao esta disponivel");
    }
}
