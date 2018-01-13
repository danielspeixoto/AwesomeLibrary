package com.library.operation;

import com.library.creator.PresenterCreator;
import com.library.presenter.Presenter;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;

public class RentOperation implements PresenterOperation {

    private final int userId;
    private final int bookId;
    private final Presenter presenter;
    private BookRepository bookRepository = BookRepository.getInstance();

    public RentOperation(PresenterCreator creator, int userId, int bookId) {
        this.userId = userId;
        this.bookId = bookId;
        this.presenter = creator.getPresenter(userId);
    }

    @Override
    public String execute() {
        return presenter.rentBook(bookRepository, userId, bookId);
    }
}
