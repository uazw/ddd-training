package io.github.uazw.dddtraining.quote;

import io.github.uazw.dddtraining.quote.car.CreateCarQuoteCommand;
import io.github.uazw.dddtraining.quote.house.CreateHouseQuoteCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class QuoteController {

    private QuoteApplicationService quoteApplicationService;

    public QuoteController(QuoteApplicationService quoteApplicationService) {
        this.quoteApplicationService = quoteApplicationService;
    }

    @PostMapping("car-quote")
    public Map<String, String> createCarQuote(CreateCarQuoteCommand createCarQuoteCommand) {
        return quoteApplicationService.createQuote(createCarQuoteCommand);
    }

    @PostMapping("house-quote")
    public Map<String, String> createHouseQuote(CreateHouseQuoteCommand createHonseQuoteCommand) {
        return quoteApplicationService.createQuote(createHonseQuoteCommand);
    }
}
