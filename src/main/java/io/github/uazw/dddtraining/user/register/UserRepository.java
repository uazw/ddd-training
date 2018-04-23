package io.github.uazw.dddtraining.user.register;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

import static java.util.Optional.empty;

@Repository
public class UserRepository {

    private final HashMap<UserId, User> users;

    public UserRepository() {
        users = new HashMap<>();
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public User byEmail(String email) {
        return null;
    }

    public Optional<User> byEmailAndPassword(String email, String password) {
        return empty();
    }
}
