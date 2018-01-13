package com.library.repository;

import com.library.data.Data;
import com.library.message.Broker;
import com.library.message.Subscriber;
import com.library.message.Topic;
import com.library.message.topic.BookRent;
import com.library.model.User;

import java.util.Arrays;
import java.util.List;

public class UserRepository
        extends Repository<User>
        implements Subscriber {

    private static UserRepository instance;
    private Broker broker;

    private UserRepository() {
        super(Data.getUsers());
        broker = Broker.getInstance();
        broker.subscribe(this);
    }

    public static UserRepository getInstance() {
        if(instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void onBookRent(int bookId) {
        System.out.println("being notified of book rent");
    }

    @Override
    public void execute(Topic topic, Object object) {
        switch (topic) {
            case BOOK_RENT:
                onBookRent(((BookRent) object).getBookId());
                break;
        }
    }

    @Override
    public List<Topic> getTopics() {
        return Arrays.asList(
                Topic.BOOK_RENT
        );
    }
}
