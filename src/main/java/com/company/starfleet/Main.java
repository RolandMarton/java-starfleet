package com.company.starfleet;

import com.company.starfleet.spacecrafts.SpaceCraft;
import com.company.starfleet.spacecrafts.SpaceCraftType;
import com.company.starfleet.spacecrafts.SpaceStation;
import com.company.starfleet.spacecrafts.mobile.CargoShip;
import com.company.starfleet.spacecrafts.mobile.DiscoveryShip;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Starfleet starfleet = new Starfleet();

        CargoShip cargoShip = new CargoShip("CargoMaria", SpaceCraftType.CARGOSHIP, 2250);
        CargoShip cargoShip2 = new CargoShip("CargoMarianna", SpaceCraftType.CARGOSHIP, 2175);
        CargoShip cargoShip3 = new CargoShip("CargoMarco", SpaceCraftType.CARGOSHIP, 2100);
        CargoShip cargoShip4 = new CargoShip("CargoMalfoy", SpaceCraftType.CARGOSHIP, 2150);

        DiscoveryShip discoveryShip = new DiscoveryShip("DiscoveryChanel", SpaceCraftType.DISCOVERYSHIP, 2175);
        DiscoveryShip discoveryShip2 = new DiscoveryShip("DiscoveryCocoChanel", SpaceCraftType.DISCOVERYSHIP, 2300);

        SpaceStation spaceStation = new SpaceStation("SpaceFort", SpaceCraftType.SPACESTATION ,2000);
        SpaceStation spaceStation2 = new SpaceStation("SpaceLord", SpaceCraftType.SPACESTATION ,1949);
        SpaceStation spaceStation3 = new SpaceStation("SpaceVille", SpaceCraftType.SPACESTATION ,2059);

        starfleet.addSpaceCraft(cargoShip);
        starfleet.addSpaceCraft(cargoShip2);
        starfleet.addSpaceCraft(cargoShip3);
        starfleet.addSpaceCraft(cargoShip4);
        starfleet.addSpaceCraft(discoveryShip);
        starfleet.addSpaceCraft(discoveryShip2);
        starfleet.addSpaceCraft(spaceStation);
        starfleet.addSpaceCraft(spaceStation2);
        starfleet.addSpaceCraft(spaceStation3);

        System.out.println("Successful docking! :");
        starfleet.findSpotForSpaceCraft(cargoShip, spaceStation.getId(), spaceStation.getName());
        starfleet.findSpotForSpaceCraft(cargoShip2, spaceStation2.getId(), spaceStation2.getName());
        starfleet.findSpotForSpaceCraft(cargoShip3, spaceStation3.getId(), spaceStation3.getName());
        starfleet.findSpotForSpaceCraft(discoveryShip, spaceStation.getId(), spaceStation.getName());
        starfleet.findSpotForSpaceCraft(discoveryShip2, spaceStation.getId(), spaceStation.getName());

        // SpaceStation do it with static collectionCloner
        System.out.println("\nReport from the SpaceStations. These are the available SpaceCrafts: ");
        Set<SpaceCraft> availableCargoShips = spaceStation.getSpaceCraftsOfGivenType(starfleet.copySpaceCrafts(), SpaceCraftType.CARGOSHIP);
        Set<SpaceCraft> availableDiscoveryShips = spaceStation.getSpaceCraftsOfGivenType(starfleet.copySpaceCrafts(), SpaceCraftType.DISCOVERYSHIP);
        Set<SpaceCraft> availableSpaceStations = spaceStation.getSpaceCraftsOfGivenType(starfleet.copySpaceCrafts(), SpaceCraftType.SPACESTATION);
        System.out.println("Available CargoShips: " + availableCargoShips);
        System.out.println("Available DiscoveryShips: " + availableDiscoveryShips);
        System.out.println("Available SpaceStations: " + availableSpaceStations);

        // Starfleet controls the flow of data. It gives access for the SpaceStation to be able to get the spacecrafts
        Set<SpaceCraft> availableCargoShips2 = starfleet.requestPermissionToGetSpaceCrafts(spaceStation, SpaceCraftType.CARGOSHIP);
        System.out.println(availableCargoShips2);

        // Cargoship asks for permission to determineCargo
        System.out.println("\n" +cargoShip4.getName() + "is asking for permission to determine Cargo!");
        starfleet.requestPermissionToDetermineCargo(cargoShip4);
    }
}
