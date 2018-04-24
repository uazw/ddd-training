package io.github.uazw.dddtraining.quote;

import java.time.LocalDate;

public class Quote {

    private final QuoteId id;
    private final LocalDate startDate;
    private Premium premium;

    public Quote(QuoteId id, LocalDate startDate, Premium premium) {
        this.startDate = startDate;
        this.premium = premium;
        this.id = id;
    }

    public Premium getPremium() {
        return premium;
    }

    public QuoteId getId() {
        return id;
    }
}
