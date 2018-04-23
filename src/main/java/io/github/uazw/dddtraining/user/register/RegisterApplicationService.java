package io.github.uazw.dddtraining.user.register;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterApplicationService {

    private RegisterService registerService;

    @Autowired
    public RegisterApplicationService(RegisterService registerService) {
        this.registerService = registerService;
    }

    public void verifyPolicyOwnerAndEmail(String email, String policyNumber) {
        registerService.verifyPolicyOwnerAndEmail(email, policyNumber);
    }

    public void initializePassword(String uuid, String password) {
        registerService.initializePassword(uuid, password);
    }
}
