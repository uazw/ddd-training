package io.github.uazw.dddtraining.user.register;

import io.github.uazw.dddtraining.policy.PolicyId;

import java.util.List;

public class User {

    private boolean isActive;
    private String email;
    private List<PolicyId> policies;
    private String password;
    private UserId id;

    public User(UserId id, String email) {
        this.id = id;
        this.isActive = false;
        this.email = email;
    }

    public void addPolicy(PolicyId policyNumber) {
        this.policies.add(policyNumber);
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void active() {
        this.isActive = true;
    }

    public UserId getId() {
        return id;
    }
}
