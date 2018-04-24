package io.github.uazw.dddtraining.quote.house;

import java.time.LocalDate;

public class CreateHouseQuoteCommand {
    private LocalDate startDate;
    private Material material;
    private BuildingType buildingType;
    private String address;
    private int numberOfBedRooms;

    public CreateHouseQuoteCommand(LocalDate startDate, Material material,
                                   BuildingType buildingType, String address,
                                   int numberOfBedRooms) {
        this.startDate = startDate;
        this.material = material;
        this.buildingType = buildingType;
        this.address = address;
        this.numberOfBedRooms = numberOfBedRooms;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Material getMaterial() {
        return material;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public String getAddress() {
        return address;
    }

    public int getNumberOfBedRooms() {
        return numberOfBedRooms;
    }
}
