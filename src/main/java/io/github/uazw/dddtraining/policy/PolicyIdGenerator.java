package io.github.uazw.dddtraining.policy;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PolicyIdGenerator {

    public PolicyId generate() {
        return new PolicyId(UUID.randomUUID().toString());
    }

}
