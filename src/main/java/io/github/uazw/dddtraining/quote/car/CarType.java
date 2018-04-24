package io.github.uazw.dddtraining.quote.car;

public enum CarType {

    BMW_C600("bmw", "C600"),
    BMW_C650("bmw", "C650"),
    Ducat_1199("ducat", "1199"),
    Ducat_1299("ducat", "1299"),
    Ducat_848("ducat", "848"),
    Honda_AG_XR("honda", "ag-xr"),
    Honda_CB1100("honda", "cb1100"),
    Honda_CB125E("honda", "cb125e");


    private final String brand;
    private final String model;

    CarType(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
}
