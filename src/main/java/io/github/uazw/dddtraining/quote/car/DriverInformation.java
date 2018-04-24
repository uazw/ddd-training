package io.github.uazw.dddtraining.quote.car;

import java.time.LocalDate;

public class DriverInformation {
    private LocalDate birthday;
    private Gender gender;

    public DriverInformation(LocalDate birthday, Gender gender) {
        this.birthday = birthday;
        this.gender = gender;
    }
}
