package io.github.uazw.dddtraining.user.register;

public class VerifyPolicyOwnerRequest {
    private String email;
    private String policyNumber;

    public String getEmail() {
        return email;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }
}
