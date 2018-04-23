package io.github.uazw.dddtraining.user.register;

import org.springframework.stereotype.Service;

@Service
public class PasswordEncoder {

    public String encode(String origin) {
        return origin;
    }
}
