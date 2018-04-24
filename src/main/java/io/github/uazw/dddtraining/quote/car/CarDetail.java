package io.github.uazw.dddtraining.quote.car;

public class CarDetail {
    private CarType carType;
    private ParkLocation parkLocation;
    private long annualMiles;
    private int yearOfMake;

    public CarType getCarType() {
        return carType;
    }

    public ParkLocation getParkLocation() {
        return parkLocation;
    }

    public long getAnnualMiles() {
        return annualMiles;
    }

    public int getYearOfMake() {
        return yearOfMake;
    }
}
