package io.github.uazw.dddtraining.register;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import static java.util.Optional.empty;

@Repository
public class UserRepository {

    public void save(User user) {
    }

    public User byEmail(String email) {
        return null;
    }

    public Optional<User> byEmailAndPassword(String email, String password) {
        return empty();
    }
}
