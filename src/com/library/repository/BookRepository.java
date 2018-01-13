package com.library.repository;

import com.library.result.BookDoesNotExist;
import com.library.result.BookNotAvailable;
import com.library.result.BookRentSuccess;
import com.library.result.Result;
import com.library.data.Data;
import com.library.message.Broker;
import com.library.message.Topic;
import com.library.message.topic.BookRent;
import com.library.model.Book;
import com.library.model.BookStatus;
import com.library.model.User;

import java.util.ArrayList;
import java.util.List;

public class BookRepository extends Repository<Book> {

    private static BookRepository instance;
    private List<BookStatus> bookStatuses;
    private UserRepository userRepository;
    private Broker broker;

    private BookRepository() {
        super(Data.getBooks());
        userRepository = UserRepository.getInstance();
        bookStatuses = Data.getBookStatuses();
        broker = Broker.getInstance();
    }

    public static BookRepository getInstance() {
        if(instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    public String rentBook(int bookId, int userId) {
        BookStatus status = findBookStatusByBookId(bookId);
        if(status == null) {
            return new BookDoesNotExist(String.valueOf(bookId)).getMessage();
        }
        Book book = findById(bookId);
        if(!status.isAvailable()) {
            return new BookNotAvailable(
                   book.getName()
            ).getMessage();
        }
        broker.publish(Topic.BOOK_RENT, new BookRent(bookId));
        User user = userRepository.findById(userId);
        return new BookRentSuccess(
                book.getName(),
                user.getName()
        ).getMessage();
    }

    private BookStatus findBookStatusByBookId(int id) {
        for (BookStatus status: bookStatuses) {
            if(status.getBookId() == id) {
                return status;
            }
        }
        return null;
    }
}
