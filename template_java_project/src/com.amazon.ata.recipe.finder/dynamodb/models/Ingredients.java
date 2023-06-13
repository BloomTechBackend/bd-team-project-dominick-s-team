package com.amazon.ata.recipe.finder.dynamodb.models;

import java.util.Objects;

public class Ingredients {
    public int measurement;
    public String name;

    public int getMeasurement() {
        return measurement;
    }

    public void setMeasurement(int measurement) {
        this.measurement = measurement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredients that)) return false;
        return getMeasurement() == that.getMeasurement() && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMeasurement(), getName());
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "measurement=" + measurement +
                ", name='" + name + '\'' +
                '}';
    }
}
