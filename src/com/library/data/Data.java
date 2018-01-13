package com.library.data;

import com.library.model.Book;
import com.library.model.BookStatus;
import com.library.model.Teacher;
import com.library.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    private static List<Book> books;
    private static List<User> users;
    private static List<BookStatus> bookStatuses;

    static {
        books = Arrays.asList(
                new Book(100, "Engenharia de Software", "Addison Wesley", "Ian Sommervile", 6, 2000)
        );
        bookStatuses = Arrays.asList(
                new BookStatus(1, 100, true)
        );
        users = Arrays.asList(
                new Teacher(100, "Carlos Lucena")
        );
    }

    public static List<Book> getBooks() {
        return books;
    }

    public static List<BookStatus> getBookStatuses() {
        return bookStatuses;
    }

    public static List<User> getUsers() {
        return users;
    }
}
