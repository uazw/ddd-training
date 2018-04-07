package io.github.uazw.dddtraining.register;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("register")
public class RegisterController {

    private RegisterApplicationService registerApplicationService;

    @Autowired
    public RegisterController(RegisterApplicationService registerApplicationService) {
        this.registerApplicationService = registerApplicationService;
    }

    @PostMapping("/")
    public void verifyPolicyOwner(@RequestParam VerifyPolicyOwnerRequest verifyPolicyOwnerRequest) {
        registerApplicationService.sendConfirmEmail(verifyPolicyOwnerRequest.getEmail(),
                verifyPolicyOwnerRequest.getPolicyNumber());

    }

    @PostMapping("/{uuid}")
    public void setEmail(@PathVariable String uuid, @RequestParam SetPasswordRequest setPasswordRequest) {
        registerApplicationService.setPassword(uuid, setPasswordRequest.getPassword());
    }
}
