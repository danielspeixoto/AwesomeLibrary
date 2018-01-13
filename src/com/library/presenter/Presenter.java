package com.library.presenter;

import com.library.repository.BookRepository;

public class Presenter {

    public String rentBook(BookRepository repository, int userId, int bookId) {
        return repository.rentBook(bookId, userId);
    }
}
