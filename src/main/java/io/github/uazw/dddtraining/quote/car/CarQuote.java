package io.github.uazw.dddtraining.quote.car;

import io.github.uazw.dddtraining.quote.Premium;
import io.github.uazw.dddtraining.quote.Quote;
import io.github.uazw.dddtraining.quote.QuoteId;

import java.time.LocalDate;

public class CarQuote extends Quote {

    private final CarDetail carDetail;
    private final DriverInformation driverInformation;

    public CarQuote(QuoteId id, LocalDate startDate,
                    CarDetail carDetail, DriverInformation driverInformation, Premium premium) {

        super(id, startDate, premium);
        this.carDetail = carDetail;
        this.driverInformation = driverInformation;
    }

    public CarDetail getCarDetail() {
        return carDetail;
    }


}
