package com.hospital.medical_resource.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Reclining implements ValueObject<Boolean> {
    private final Boolean value;

    public Reclining(Boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reclining reclining = (Reclining) o;
        return Objects.equals(value, reclining.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
