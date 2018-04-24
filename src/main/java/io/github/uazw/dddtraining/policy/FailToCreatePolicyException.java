package io.github.uazw.dddtraining.policy;

public class FailToCreatePolicyException extends RuntimeException {

    public FailToCreatePolicyException(String errorMessage) {
        super(errorMessage);
    }
}
