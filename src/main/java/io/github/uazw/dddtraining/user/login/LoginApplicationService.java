package io.github.uazw.dddtraining.user.login;

import io.github.uazw.dddtraining.user.register.PasswordEncoder;
import io.github.uazw.dddtraining.user.register.User;
import io.github.uazw.dddtraining.user.register.UserRepository;

import java.util.Optional;

public class LoginApplicationService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public LoginApplicationService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public void login(String email, String password) {
        Optional<User> user = userRepository.byEmailAndPassword(email, encoder.encode(password));
        user.orElseThrow(InformationNotMatchingException::new);
    }
}
