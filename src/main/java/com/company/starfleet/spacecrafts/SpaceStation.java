package com.company.starfleet.spacecrafts;

import com.company.starfleet.spacecrafts.mobile.MobileSpaceCraft;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SpaceStation extends SpaceCraft {

    private static final int LIMIT = 2;
    private Set<SpaceCraft> dockedSpaceCrafts;

    public SpaceStation(String name, SpaceCraftType type, int year) {
        super(name, type, year);
        this.dockedSpaceCrafts = new HashSet<>();
    }

    public Set<SpaceCraft> getSpaceCraftsOfGivenType(Set<SpaceCraft> spaceCraftsCopy, SpaceCraftType spaceCraftType){
        return spaceCraftsCopy.stream()
                .filter(spaceCraft -> spaceCraft.getType().equals(spaceCraftType))
                .collect(Collectors.toSet());
    }

    public Set<SpaceCraft> getSpaceCraftsOfGivenTypeByStarFleet(Set<SpaceCraft> spaceCrafts, SpaceCraftType spaceCraftType){
        return spaceCrafts.stream()
                .filter(spaceCraft -> spaceCraft.getType().equals(spaceCraftType))
                .collect(Collectors.toSet());
    }

    public void addDockedSpaceCraft(MobileSpaceCraft mobileSpaceCraft) {
        if (dockedSpaceCrafts.size() < LIMIT) {
            dockedSpaceCrafts.add(mobileSpaceCraft);
        }
    }
}
