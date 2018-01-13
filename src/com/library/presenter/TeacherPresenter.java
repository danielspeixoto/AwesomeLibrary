package com.library.presenter;

import com.library.repository.BookRepository;

public class TeacherPresenter extends Presenter {

    @Override
    public String rentBook(BookRepository repository, int userId, int bookId) {
        return super.rentBook(repository, userId, bookId);
    }
}
