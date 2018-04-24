package io.github.uazw.dddtraining.policy;

public class PolicyId {
    private String id;

    public PolicyId(String id) {
        this.id = id;
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
