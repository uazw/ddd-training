package io.github.uazw.dddtraining.policy;

public class PolicyId {
    private String id;

    PolicyId(String id) {
        this.id = id;
    }

    public static PolicyId valueOf(String policyNumber) {
        return new PolicyId(policyNumber);
    }

    @Override
    public String toString() {
        return id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
