package io.github.uazw.dddtraining.user.register;

import io.github.uazw.dddtraining.policy.PolicyId;
import io.github.uazw.dddtraining.user.login.InformationNotMatchingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFactory {

    private final VerifyPolicyOwnerService verifyPolicyOwnerService;
    private UserIdGenerator userIdGenerator;

    @Autowired
    public UserFactory(VerifyPolicyOwnerService verifyPolicyOwnerService, UserIdGenerator userIdGenerator) {
        this.verifyPolicyOwnerService = verifyPolicyOwnerService;
        this.userIdGenerator = userIdGenerator;
    }

    public User create(String email, PolicyId policyNumber) {
        boolean isMatching = verifyPolicyOwnerService.isMatching(email, policyNumber);
        if (isMatching) {
            return new User(userIdGenerator.generate(), email);
        } else {
            throw new InformationNotMatchingException();
        }

    }
}
