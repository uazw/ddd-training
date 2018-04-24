package io.github.uazw.dddtraining.policy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("policy")
public class PolicyController {

    private PolicyApplicationService policyApplicationService;

    @Autowired
    public PolicyController(PolicyApplicationService policyApplicationService) {
        this.policyApplicationService = policyApplicationService;
    }

    @PostMapping
    public void createPolicy(@RequestBody CreatePolicyCommand createPolicyCommand) {
        policyApplicationService.createPolicy(createPolicyCommand);
    }
}
