package com.company.starfleet.spacecrafts.mobile;

import com.company.starfleet.spacecrafts.SpaceCraft;
import com.company.starfleet.spacecrafts.SpaceCraftType;
import com.company.starfleet.spacecrafts.SpaceStation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.UUID;

public class DiscoveryShip extends MobileSpaceCraft {

    private static final int MAXIMUM_SPEED = 450;

    public DiscoveryShip(String name, SpaceCraftType type, int year) {
        super(name, type, year, MAXIMUM_SPEED);
    }

    @Override
    public void tryToDockSpaceCraft(Set<SpaceCraft> spaceCrafts, UUID spaceStationId, String spaceStationName) {
        spaceCrafts.stream()
                .filter(spaceCraft -> spaceCraft instanceof SpaceStation)
                .findFirst()
                .ifPresentOrElse(spaceCraft -> ((SpaceStation) spaceCraft).addDockedSpaceCraft(this), null);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Hello " + spaceStationName + " !:) " + spaceStationId + " I am " + getName() + " " + getId() + ". Docking time: " + dtf.format(now));
    }

}
