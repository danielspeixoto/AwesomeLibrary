package com.library.message;

import java.util.*;

public class Broker {

    private static Broker instance;
    private HashMap<Topic, ArrayList<Subscriber>> topics;

    private Broker() {
        topics = new HashMap<>();
    }

    public static Broker getInstance() {
        if(instance == null) {
            instance = new Broker();
        }
        return instance;
    }

    // A subscriber will get notified every time
    // someone publishes on this topic
    public void subscribe(Subscriber subscriber) {
        subscriber.getTopics().forEach(topic -> {
            // Initialize topic with a empty array;
            if(!topics.containsKey(topic)) {
                topics.put(topic, new ArrayList<>());
            }
            topics.get(topic).add(subscriber);
        });
    }

    public void publish(Topic topic, Object data) {
        topics.get(topic).forEach(subscriber -> {
            subscriber.execute(topic, data);
        });
    }
}
