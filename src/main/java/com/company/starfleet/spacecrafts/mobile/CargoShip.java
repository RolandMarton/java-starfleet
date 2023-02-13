package com.company.starfleet.spacecrafts.mobile;

import com.company.starfleet.spacecrafts.SpaceCraft;
import com.company.starfleet.spacecrafts.SpaceCraftType;
import com.company.starfleet.spacecrafts.SpaceStation;
import com.company.starfleet.spacecrafts.mobile.cargo.CargoType;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

public class CargoShip extends MobileSpaceCraft {

    private static final int MAXIMUM_SPEED = 150;
    private HashMap <CargoType, Integer> cargo;

    public CargoShip(String name, SpaceCraftType type, int year) {
        super(name, type, year, MAXIMUM_SPEED);
        this.cargo = new HashMap<>();
        determineCargo();
    }

    @Override
    public void tryToDockSpaceCraft(Set<SpaceCraft> spaceCrafts, UUID spaceStationID, String spaceStationName) {
        spaceCrafts.stream()
                .filter(spaceCraft -> spaceCraft instanceof SpaceStation)
                .findFirst()
                .ifPresentOrElse(spaceCraft -> ((SpaceStation) spaceCraft).addDockedSpaceCraft(this), null);
        System.out.println("Hello " + spaceStationName + " !:) " + spaceStationID + " I am " + getName() + " " + getId() + " and I brought " + cargo + " to you!");
        determineCargo();
    }

    public HashMap<CargoType, Integer> determineCargo(){
        for (CargoType cargoType : CargoType.values()){
            cargo.put(cargoType, generateRandomNumber());
        }
        return cargo;
    }

    private int generateRandomNumber(){
        int max = 5;
        int min = 0;
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

}
