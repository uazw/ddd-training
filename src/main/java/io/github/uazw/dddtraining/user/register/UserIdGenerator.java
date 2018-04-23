package io.github.uazw.dddtraining.user.register;

import java.util.UUID;

public class UserIdGenerator {

    public UserId generate() {
        String uuid = UUID.randomUUID().toString();
        return new UserId(uuid);
    }
}
