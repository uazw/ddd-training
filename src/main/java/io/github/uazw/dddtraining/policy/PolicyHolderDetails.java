package io.github.uazw.dddtraining.policy;

import java.time.LocalDate;

public class PolicyHolderDetails {
    private String name;
    private String email;
    private String ID;
    private LocalDate birthday;

    public PolicyHolderDetails(String name, String email, String ID, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.ID = ID;
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }
}
