package io.github.uazw.dddtraining.quote.car;

import java.time.LocalDate;

public class CreateCarQuoteCommand {
    private LocalDate startDate;
    private CarDetail carDetail;
    private DriverInformation driverInformation;

    public LocalDate getStartDate() {
        return startDate;
    }

    public CarDetail getCarDetail() {
        return carDetail;
    }

    public DriverInformation getDriverInformation() {
        return driverInformation;
    }
}
