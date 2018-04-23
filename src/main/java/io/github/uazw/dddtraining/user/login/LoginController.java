package io.github.uazw.dddtraining.user.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    private LoginApplicationService loginApplicationService;

    @Autowired
    public LoginController(LoginApplicationService loginApplicationService) {
        this.loginApplicationService = loginApplicationService;
    }

    @PostMapping
    public void login(@RequestParam LoginRequest loginRequest) {
        loginApplicationService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
