package io.github.uazw.dddtraining.policy;

import io.github.uazw.dddtraining.quote.QuoteId;

public class CreatePolicyCommand {

    private QuoteId quoteId;
    private PolicyHolderDetails policyHolderDetails;

    public CreatePolicyCommand(QuoteId quoteId, PolicyHolderDetails policyHolderDetails) {
        this.quoteId = quoteId;
        this.policyHolderDetails = policyHolderDetails;
    }

    public QuoteId getQuoteId() {
        return this.quoteId;
    }

    public PolicyHolderDetails getPolicyHolderDetails() {
        return this.policyHolderDetails;
    }
}
