package io.github.uazw.dddtraining.quote.car;

import io.github.uazw.dddtraining.quote.Quote;
import io.github.uazw.dddtraining.quote.QuoteIdGenerator;
import io.github.uazw.dddtraining.quote.house.BuildingType;
import io.github.uazw.dddtraining.quote.house.HousePriceService;
import io.github.uazw.dddtraining.quote.house.HouseQuote;
import io.github.uazw.dddtraining.quote.house.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class QuoteFactory {

    private QuoteIdGenerator quoteIdGenerator;
    private CarPriceService carPriceService;
    private HousePriceService housePriceService;

    @Autowired
    public QuoteFactory(QuoteIdGenerator quoteIdGenerator,
                        CarPriceService carPriceService,
                        HousePriceService housePriceService) {

        this.quoteIdGenerator = quoteIdGenerator;
        this.carPriceService = carPriceService;
        this.housePriceService = housePriceService;
    }

    public CarQuote create(CarDetail carDetail, LocalDate startDate,
                           DriverInformation driverInformation) {

        return new CarQuote(quoteIdGenerator.generateForCar(), startDate,
                carDetail, driverInformation,
                carPriceService.calculate(carDetail));
    }

    public Quote create(LocalDate startDate, Material material,
                        BuildingType buildingType, int numberOfBedRooms, String address) {

        return new HouseQuote(quoteIdGenerator.generateForHouse(),
                startDate, buildingType, numberOfBedRooms, address,
                housePriceService.calculate(material, buildingType, numberOfBedRooms));
    }
}
