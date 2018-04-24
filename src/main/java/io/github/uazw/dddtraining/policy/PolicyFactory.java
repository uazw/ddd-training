package io.github.uazw.dddtraining.policy;

import io.github.uazw.dddtraining.quote.QuoteId;
import io.github.uazw.dddtraining.quote.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyFactory {

    private PolicyIdGenerator policyIdGenerator;
    private QuoteRepository quoteRepository;

    @Autowired
    public PolicyFactory(PolicyIdGenerator policyIdGenerator, QuoteRepository quoteRepository) {
        this.policyIdGenerator = policyIdGenerator;
        this.quoteRepository = quoteRepository;
    }

    public Policy create(QuoteId quoteId, PolicyHolderDetails policyHolderDetails) {
        if (quoteRepository.isExisted(quoteId)) {
            return new Policy(policyIdGenerator.generate(), quoteId, policyHolderDetails);
        }
        throw new FailToCreatePolicyException("cannot find the quote");
    }
}
