package io.github.uazw.dddtraining.policy;

import io.github.uazw.dddtraining.quote.QuoteId;

public class Policy {

    private final PolicyId id;
    private final QuoteId quoteId;
    private final PolicyHolderDetails policyHolderDetails;

    public Policy(PolicyId id, QuoteId quoteId, PolicyHolderDetails policyHolderDetails) {
        this.id = id;
        this.quoteId = quoteId;
        this.policyHolderDetails = policyHolderDetails;
    }

    public PolicyId getId() {
        return id;
    }

    public boolean isTheSameEmailAddress(String otherAddress) {
        return policyHolderDetails.getEmail().equals(otherAddress);
    }
}
