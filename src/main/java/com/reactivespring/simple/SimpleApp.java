package com.reactivespring.simple;

public class SimpleApp {

    public static void main(String[] args) {
        SimplePublisher publisher = new SimplePublisher();

        SimpleSubscriber subscriber = new SimpleSubscriber(3);

        publisher.subscribe(subscriber);
    }
}
