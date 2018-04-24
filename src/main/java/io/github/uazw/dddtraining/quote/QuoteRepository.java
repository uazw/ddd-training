package io.github.uazw.dddtraining.quote;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class QuoteRepository {

    private final Map<QuoteId, Quote> quotes = new HashMap<>();

    public void save(Quote quote) {
        this.quotes.put(quote.getId(), quote);
    }


    public boolean isExisted(QuoteId quoteId) {
        return false;
    }
}
