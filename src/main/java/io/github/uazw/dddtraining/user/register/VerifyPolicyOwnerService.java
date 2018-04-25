package io.github.uazw.dddtraining.user.register;

import io.github.uazw.dddtraining.policy.Policy;
import io.github.uazw.dddtraining.policy.PolicyId;
import io.github.uazw.dddtraining.policy.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyPolicyOwnerService {

    private PolicyRepository policyRepository;

    @Autowired
    public VerifyPolicyOwnerService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public boolean isMatching(String email, PolicyId policyNumber) {
        Policy policy = policyRepository.findByPolicyNumber(policyNumber);
        return policy.isTheSameEmailAddress(email);
    }
}
