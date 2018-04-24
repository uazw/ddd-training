package io.github.uazw.dddtraining.quote.house;

import io.github.uazw.dddtraining.quote.Premium;
import io.github.uazw.dddtraining.quote.Quote;
import io.github.uazw.dddtraining.quote.QuoteId;

import java.time.LocalDate;

public class HouseQuote extends Quote {

    private final BuildingType buildingType;
    private final int numberOfBedRooms;
    private final String address;

    public HouseQuote(QuoteId quoteId, LocalDate startDate,
                      BuildingType buildingType,
                      int numberOfBedRooms, String address,
                      Premium premium) {

        super(quoteId, startDate, premium);
        this.buildingType = buildingType;
        this.numberOfBedRooms = numberOfBedRooms;
        this.address = address;
    }
}
