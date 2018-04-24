package io.github.uazw.dddtraining.quote;

import java.util.Objects;

public class QuoteId {
    private String id;

    public QuoteId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuoteId quoteId = (QuoteId) o;
        return Objects.equals(id, quoteId.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
