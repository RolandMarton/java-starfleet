package com.company.starfleet;

import com.company.starfleet.spacecrafts.SpaceCraft;
import com.company.starfleet.spacecrafts.SpaceCraftType;
import com.company.starfleet.spacecrafts.SpaceStation;
import com.company.starfleet.spacecrafts.mobile.CargoShip;
import com.company.starfleet.spacecrafts.mobile.MobileSpaceCraft;

import java.util.*;

public class Starfleet {
    private final Set<SpaceCraft> spaceCrafts;

    public Starfleet() {
        this.spaceCrafts = new HashSet<>();
    }

    public void addSpaceCraft(SpaceCraft spaceCraft){
        spaceCrafts.add(spaceCraft);
    }

    public void findSpotForSpaceCraft(MobileSpaceCraft mobileSpaceCraft, UUID spaceStationId, String spaceStationName){
        mobileSpaceCraft.tryToDockSpaceCraft(spaceCrafts, spaceStationId, spaceStationName);
    }

    public Set<SpaceCraft> requestPermissionToGetSpaceCrafts(SpaceStation spaceStation, SpaceCraftType spaceCraftType){
        return spaceStation.getSpaceCraftsOfGivenTypeByStarFleet(spaceCrafts, spaceCraftType);
    }

    public void requestPermissionToDetermineCargo(CargoShip cargoShip){
        cargoShip.determineCargo();
    }

    public Set<SpaceCraft> copySpaceCrafts() {
        return Set.copyOf(spaceCrafts);

//        return new HashSet<>(spaceCrafts);

//        Set<SpaceCraft> copy = new HashSet<>(spaceCrafts);
//        return copy;
//
//        Set<SpaceCraft> copy = new HashSet<>();
//        copy.addAll(spaceCrafts);
//        return copy;
    }

}
