package io.github.uazw.dddtraining.register;

import org.springframework.beans.factory.annotation.Autowired;

public class RegisterService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final UserFactory userFactory;
    private LinkService linkService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterService(UserRepository userRepository, EmailService emailService,
                           LinkService linkService, PasswordEncoder passwordEncoder,
                           UserFactory userFactory) {

        this.userRepository = userRepository;
        this.emailService = emailService;
        this.linkService = linkService;
        this.passwordEncoder = passwordEncoder;
        this.userFactory = userFactory;
    }

    //retrieve information
    //call domain function
    //save
    public void verifyPolicyOwnerAndEmail(String email, String policyNumber) {
        User user = userFactory.create(email, policyNumber);
        user.addPolicy(policyNumber);
        userRepository.save(user);
        emailService.sendEmail(email, linkService.createLink(email));
    }

    public void initializePassword(String uuid, String password) {
        Link link = linkService.byId(uuid);
        User user = userRepository.byEmail(link.getEmail());
        user.updatePassword(passwordEncoder.encode(password));
        user.active();
        userRepository.save(user);

    }
}