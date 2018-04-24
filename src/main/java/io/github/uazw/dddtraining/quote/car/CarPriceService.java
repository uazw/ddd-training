package io.github.uazw.dddtraining.quote.car;

import io.github.uazw.dddtraining.quote.Premium;
import io.github.uazw.dddtraining.quote.car.CarDetail;
import io.github.uazw.dddtraining.quote.car.CarType;
import io.github.uazw.dddtraining.quote.car.ParkLocation;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;
import static io.github.uazw.dddtraining.quote.car.CarType.BMW_C600;
import static io.github.uazw.dddtraining.quote.car.CarType.BMW_C650;
import static io.github.uazw.dddtraining.quote.car.CarType.Ducat_1199;
import static io.github.uazw.dddtraining.quote.car.CarType.Ducat_1299;
import static io.github.uazw.dddtraining.quote.car.CarType.Ducat_848;
import static io.github.uazw.dddtraining.quote.car.CarType.Honda_AG_XR;
import static io.github.uazw.dddtraining.quote.car.CarType.Honda_CB1100;
import static io.github.uazw.dddtraining.quote.car.CarType.Honda_CB125E;
import static io.github.uazw.dddtraining.quote.car.ParkLocation.CARPORT;
import static io.github.uazw.dddtraining.quote.car.ParkLocation.DRIVE_WAY;
import static io.github.uazw.dddtraining.quote.car.ParkLocation.STREET;

public class CarPriceService {
    private static long BASE_AMOUNT = 100;

    private Map<ParkLocation, Double> ratesBaseOnParks = of(CARPORT, 1.1, DRIVE_WAY, 1.2, STREET, 1.6);


    public Premium calculate(CarDetail carDetail) {
        Premium premium = new Premium(BASE_AMOUNT);
        premium = baseOnYearOfMake(carDetail.getYearOfMake(), premium);
        premium = baseOnBrand(carDetail.getCarType(), premium);
        premium = baseOnParkLocation(carDetail.getParkLocation(), premium);
        premium = baseOnAnnualMiles(carDetail.getAnnualMiles(), premium);
        return premium;
    }

    private Premium baseOnYearOfMake(int yearOfMake, Premium premium) {
        double rate = 1.0D;
        if (yearOfMake > 2015) {
            rate = 1.0D;
        } else if (yearOfMake < 2009) {
            rate = 1.4D;
        } else {
            rate = 1.2D;
        }
        return premium.multiple(rate);
    }

    private Premium baseOnAnnualMiles(long annualMiles, Premium premium) {
        double rate = 1.0D;
        if (annualMiles > 1500) {
            rate = 1.4D;
        } else if (annualMiles < 750) {
            rate = 1.0D;
        } else {
            rate = 1.2D;
        }
        return premium.multiple(rate);
    }

    private Premium baseOnParkLocation(ParkLocation parkLocation, Premium premium) {
        return premium.multiple(ratesBaseOnParks.get(parkLocation));
    }

    private Premium baseOnBrand(CarType carType, Premium premium) {
        return premium.multiple(getRateBaseOnCarType(carType));
    }

    private double getRateBaseOnCarType(CarType carType) {
        HashMap<CarType, Double> rates = new HashMap<>();
        rates.put(BMW_C600, 1.4D);
        rates.put(BMW_C650, 1.6D);
        rates.put(Ducat_848, 1.6D);
        rates.put(Ducat_1199, 1.4D);
        rates.put(Ducat_1299, 1.6D);
        rates.put(Honda_AG_XR, 1.2D);
        rates.put(Honda_CB1100, 1.2D);
        rates.put(Honda_CB125E, 1.4D);

        return rates.get(carType);
    }

}
