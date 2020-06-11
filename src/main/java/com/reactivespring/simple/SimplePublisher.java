package com.reactivespring.simple;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class SimplePublisher implements Publisher<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimplePublisher.class);

    private static final List<String> data = Arrays.asList("A", "B", "C", "D", "E");

    @Override
    public void subscribe(Subscriber<? super String> subscriber) {
        LOGGER.info("subscribe()");

        subscriber.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                LOGGER.info("request()");

                try {
                    for (int i = 0; i < n; i++) {
                        Thread.sleep(1000);
                        subscriber.onNext(data.get(i));
                    }

                    subscriber.onComplete();
                } catch (Exception e) {

                    subscriber.onError(e);

                }
            }

            @Override
            public void cancel() {

            }
        });

    }
}
