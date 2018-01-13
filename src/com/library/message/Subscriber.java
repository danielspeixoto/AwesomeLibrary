package com.library.message;

import java.util.List;

public interface Subscriber {

    void execute(Topic topic, Object object);
    List<Topic> getTopics();
}
