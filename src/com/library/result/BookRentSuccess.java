package com.library.result;

public class BookRentSuccess extends Result {

    public BookRentSuccess(String book, String user) {
        super("O aluguel do livro " + book + " foi realizado para " + user);
    }
}
