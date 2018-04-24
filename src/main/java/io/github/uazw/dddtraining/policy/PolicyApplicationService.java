package io.github.uazw.dddtraining.policy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyApplicationService {

    private PolicyFactory policyFactory;
    private PolicyRepository policyRepository;

    @Autowired
    public PolicyApplicationService(PolicyFactory policyFactory, PolicyRepository policyRepository) {
        this.policyFactory = policyFactory;
        this.policyRepository = policyRepository;
    }

    public void createPolicy(CreatePolicyCommand createPolicyCommand) {

        Policy policy = policyFactory.create(createPolicyCommand.getQuoteId(),
                createPolicyCommand.getPolicyHolderDetails());

        policyRepository.save(policy);
    }
}
