package com.library.result;

public class BookDoesNotExist extends Result {

    public BookDoesNotExist(String id) {
        super("O livro de id " + id + " nao existe");
    }
}
