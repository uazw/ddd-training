package io.github.uazw.dddtraining.policy;

import java.util.HashMap;
import java.util.Map;

public class PolicyRepository {

    private Map<PolicyId, Policy> policies = new HashMap<>();

    public void save(Policy policy) {
        policies.put(policy.getId(), policy);
    }

    public Policy findByPolicyNumber(PolicyId policyId) {
        return policies.get(policyId);
    }
}
