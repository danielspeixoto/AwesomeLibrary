package com.library.model;

import java.util.ArrayList;
import java.util.List;

public class User implements Id {

    private final int id;
    private final String name;
    private final Role role;
    private List<Book> history = new ArrayList<>();
    private List<Book> notifications = new ArrayList<>();

    public User(int code, String name, Role role) {
        this.id = code;
        this.name = name;
        this.role = role;
    }

    public User(int id, String name, Role role, List<Book> history, List<Book> notifications) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.history = history;
        this.notifications = notifications;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public List<Book> getHistory() {
        return history;
    }

    public List<Book> getNotifications() {
        return notifications;
    }

    public void notify(Book book) {
        notifications.notify();
    }

    public void addBookToHistory(Book book) {
        history.add(book);
    }

    public enum Role {
        TEACHER,
        STUDENT,
        EMPLOYEE
    }
}
