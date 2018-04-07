package io.github.uazw.dddtraining.register;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterApplicationService {

    private VerifyPolicyOwnerService verifyPolicyOwnerService;
    private UserRepository userRepository;
    private EmailService emailService;
    private LinkService linkService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterApplicationService(VerifyPolicyOwnerService verifyPolicyOwnerService, UserRepository userRepository,
                                      EmailService emailService, LinkService linkService, PasswordEncoder passwordEncoder) {


        this.verifyPolicyOwnerService = verifyPolicyOwnerService;
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.linkService = linkService;
        this.passwordEncoder = passwordEncoder;
    }

    public void sendConfirmEmail(String email, String policyNumber) {
        boolean isMatching = verifyPolicyOwnerService.isMatching(email, policyNumber);
        if (isMatching) {
            createUser(email, policyNumber);
            emailService.sendEmail(email, linkService.createLink(email));
        } else {
            throw new EmailAndOwnerNotMatchingException();
        }
    }

    private void createUser(String email, String policyNumber) {
        User user = new User(email);
        user.addPolicy(policyNumber);
        userRepository.save(user);
    }

    public void setPassword(String uuid, String password) {
        Link link = linkService.byId(uuid);
        User user = userRepository.byEmail(link.getEmail());
        user.updatePassword(passwordEncoder.encode(password));
        user.active();
    }
}
