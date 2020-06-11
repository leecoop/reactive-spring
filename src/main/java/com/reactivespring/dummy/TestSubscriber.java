package com.reactivespring.dummy;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSubscriber implements Subscriber<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestSubscriber.class);

    private int n;

    public TestSubscriber(int n) {
        this.n = n;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        LOGGER.info("onSubscribe()");
        subscription.request(n);
    }

    @Override
    public void onNext(String element) {
        LOGGER.info("onNext(" + element + ")");

    }

    @Override
    public void onError(Throwable t) {
        LOGGER.info("onError()");
        t.printStackTrace();

    }

    @Override
    public void onComplete() {
        LOGGER.info("onComplete()");

    }
}
