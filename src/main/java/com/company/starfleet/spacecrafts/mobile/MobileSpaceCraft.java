package com.company.starfleet.spacecrafts.mobile;

import com.company.starfleet.spacecrafts.SpaceCraft;
import com.company.starfleet.spacecrafts.SpaceCraftType;

import java.util.Set;
import java.util.UUID;

public abstract class MobileSpaceCraft extends SpaceCraft {

    private int maximumSpeed;

    public MobileSpaceCraft(String name, SpaceCraftType type, int year, int maximumSpeed) {
        super(name, type, year);
        this.maximumSpeed = calculateExtraSpeed(year, maximumSpeed);
    }

    public int calculateExtraSpeed(int year, int maximumSpeed){
        if (year < 2150){
            return maximumSpeed -= 30;
        } else if (year > 2200) {
            return maximumSpeed += 15;
        } else {
            return maximumSpeed;
        }
    }

    public abstract void tryToDockSpaceCraft(Set<SpaceCraft> spaceCrafts, UUID spaceStationId, String spaceStationName);

}
