package io.github.uazw.dddtraining.user.register;

import org.springframework.stereotype.Service;

@Service
public class VerifyPolicyOwnerService {

    public boolean isMatching(String email, String policyNumber) {
        return true;
    }
}
