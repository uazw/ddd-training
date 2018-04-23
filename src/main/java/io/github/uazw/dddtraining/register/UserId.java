package io.github.uazw.dddtraining.register;

import java.util.Objects;

public class UserId {

    private String value;

    public UserId(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId = (UserId) o;
        return Objects.equals(value, userId.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }
}
