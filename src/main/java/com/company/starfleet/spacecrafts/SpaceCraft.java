package com.company.starfleet.spacecrafts;

import java.util.UUID;

public abstract class SpaceCraft {
    private UUID id;
    private String name;
    private SpaceCraftType type;
    protected int year;

    public SpaceCraft(String name, SpaceCraftType type, int year) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        this.year = year;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SpaceCraftType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "SpaceCraft{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", year=" + year +
                '}';
    }
}
