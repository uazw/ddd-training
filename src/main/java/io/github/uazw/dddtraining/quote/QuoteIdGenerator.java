package io.github.uazw.dddtraining.quote;

import java.util.UUID;

public class QuoteIdGenerator {

    public QuoteId generateForCar() {
        return new QuoteId("CAR" + UUID.randomUUID().toString());
    }

    public QuoteId generateForHouse() {
        return new QuoteId("HOUSE" + UUID.randomUUID().toString());
    }
}
