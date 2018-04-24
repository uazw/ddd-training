package io.github.uazw.dddtraining.quote.house;

import io.github.uazw.dddtraining.quote.Premium;

import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;
import static io.github.uazw.dddtraining.quote.house.BuildingType.APARTMENT;
import static io.github.uazw.dddtraining.quote.house.BuildingType.FREE_STANDING;
import static io.github.uazw.dddtraining.quote.house.BuildingType.TOWN_HOUSE;
import static io.github.uazw.dddtraining.quote.house.Material.ALUMINIUM;
import static io.github.uazw.dddtraining.quote.house.Material.BRICK_VENEER;
import static io.github.uazw.dddtraining.quote.house.Material.CONCRETE;

public class HousePriceService {

    private Map<Material, Double> materials = of(ALUMINIUM, 1.1D, CONCRETE, 1.2D, BRICK_VENEER, 1.3D);
    private Map<BuildingType, Double> buildTypes = of(FREE_STANDING, 1.1D, TOWN_HOUSE, 1.2D, APARTMENT, 1.3D);

    public Premium calculate(Material material, BuildingType buildingType, int numberOfBedRooms) {

        Premium premium = new Premium(100);
        premium = baseOnMaterial(material, premium);
        premium = baseOnBuildType(buildingType, premium);
        premium = baseOnNumberOfBedRooms(numberOfBedRooms, premium);

        return premium;
    }

    private Premium baseOnNumberOfBedRooms(int numberOfBedRooms, Premium premium) {
        double rate = 1.0D;
        if (numberOfBedRooms == 1) {
            rate = 1.1D;
        } else if (numberOfBedRooms == 2) {
            rate = 1.2D;
        } else {
            rate = 1.3D;
        }

        return premium.multiple(rate);
    }

    private Premium baseOnBuildType(BuildingType buildingType, Premium premium) {
        return premium.multiple(buildTypes.get(buildingType));
    }

    private Premium baseOnMaterial(Material material, Premium premium) {
        return premium.multiple(materials.get(material));
    }

}
