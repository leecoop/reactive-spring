package com.reactivespring.fluxandmonoplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class FluxAndMonoCombineTest {

    @Test
    public void combineUsingMerge() { // The order is not guaranteed with merge
        Flux<String> flux1 = Flux.just("A", "B", "C");
        Flux<String> flux2 = Flux.just("D", "E", "F");

        Flux<String> mergedFlux = Flux.merge(flux1, flux2);

        StepVerifier.create(mergedFlux.log())
                .expectNext("A", "B", "C", "D", "E", "F")
                .verifyComplete();
    }


    @Test
    public void combineUsingMerge_withDelay() { // The order is not guaranteed with merge
        Flux<String> flux1 = Flux.just("A", "B", "C").delayElements(Duration.ofSeconds(1));
        Flux<String> flux2 = Flux.just("D", "E", "F").delayElements(Duration.ofSeconds(1));

        Flux<String> mergedFlux = Flux.merge(flux1, flux2);

        StepVerifier.create(mergedFlux.log())
//                .expectNext("A", "B", "C", "D", "E", "F") // merge break the order
                .expectNextCount(6)
                .verifyComplete();
    }


    @Test
    public void combineUsingConcat() { // The order is guaranteed with concat
        Flux<String> flux1 = Flux.just("A", "B", "C");
        Flux<String> flux2 = Flux.just("D", "E", "F");

        Flux<String> mergedFlux = Flux.concat(flux1, flux2);

        StepVerifier.create(mergedFlux.log())
                .expectNext("A", "B", "C", "D", "E", "F")
                .verifyComplete();
    }


    @Test
    public void combineUsingConcat_withDelay() { // The order is guaranteed with concat
        Flux<String> flux1 = Flux.just("A", "B", "C").delayElements(Duration.ofSeconds(1));
        Flux<String> flux2 = Flux.just("D", "E", "F").delayElements(Duration.ofSeconds(1));

        Flux<String> mergedFlux = Flux.concat(flux1, flux2);

        StepVerifier.create(mergedFlux.log())
                .expectNext("A", "B", "C", "D", "E", "F") // merge break the order
//                .expectNextCount(6)
                .verifyComplete();
    }


    @Test
    public void combineUsingZip() {
        Flux<String> flux1 = Flux.just("A", "B", "C");
        Flux<String> flux2 = Flux.just("D", "E", "F");

        Flux<String> mergedFlux = Flux.zip(flux1, flux2, (t1, t2) -> // A,D : B,E : C:F
                t1.concat(t2) // AD, BE, CF
        );

        StepVerifier.create(mergedFlux.log())
                .expectNext("AD", "BE", "CF")
                .verifyComplete();
    }

}
