package com.reactivespring.dummy;

public class SandBox {

    public static void main(String[] args) {
        TestPublisher publisher = new TestPublisher();

        TestSubscriber subscriber = new TestSubscriber(3);

        publisher.subscribe(subscriber);
    }
}
