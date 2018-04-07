package io.github.uazw.dddtraining.register;

import java.util.List;

public class User {
    private long id;
    private boolean isActive;
    private String email;
    private List<String> policies;
    private String password;

    public User(String email) {
        this.isActive = false;
        this.email = email;
    }

    public void addPolicy(String policyNumber) {
        this.policies.add(policyNumber);
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void active() {
        this.isActive = true;
    }
}
