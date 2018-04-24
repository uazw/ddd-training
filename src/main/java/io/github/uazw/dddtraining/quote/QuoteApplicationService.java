package io.github.uazw.dddtraining.quote;

import io.github.uazw.dddtraining.quote.car.CarPriceService;
import io.github.uazw.dddtraining.quote.car.CreateCarQuoteCommand;
import io.github.uazw.dddtraining.quote.car.QuoteFactory;
import io.github.uazw.dddtraining.quote.house.CreateHouseQuoteCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;

@Service
public class QuoteApplicationService {

    private QuoteRepository quoteRepository;
    private QuoteFactory quoteFactory;

    @Autowired
    public QuoteApplicationService(QuoteRepository quoteRepository,
                                   QuoteFactory quoteFactory,
                                   CarPriceService carPriceService) {

        this.quoteRepository = quoteRepository;
        this.quoteFactory = quoteFactory;
    }

    public Map<String, String> createQuote(CreateCarQuoteCommand createCarQuoteCommand) {

        Quote carQuote = quoteFactory.create(createCarQuoteCommand.getCarDetail(),
                createCarQuoteCommand.getStartDate(),
                createCarQuoteCommand.getDriverInformation());

        quoteRepository.save(carQuote);

        return of("quoteId", String.valueOf(carQuote.getId()),
                "premium", String.valueOf(carQuote.getPremium()));
    }

    public Map<String, String> createQuote(CreateHouseQuoteCommand createHonseQuoteCommand) {

        Quote houseQuote = quoteFactory.create(createHonseQuoteCommand.getStartDate(),
                createHonseQuoteCommand.getMaterial(),
                createHonseQuoteCommand.getBuildingType(),
                createHonseQuoteCommand.getNumberOfBedRooms(),
                createHonseQuoteCommand.getAddress());


        quoteRepository.save(houseQuote);

        return of("quoteId", String.valueOf(houseQuote.getId()),
                "premium", String.valueOf(houseQuote.getPremium()));
    }
}
