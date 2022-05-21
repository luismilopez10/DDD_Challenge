package com.hospital.medical_appointment.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Treatment implements ValueObject<String> {
    private final String value;

    public Treatment(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("The treatment can not be empty");
        }

        if (this.value.length() <= 5){
            throw new IllegalArgumentException("The treatment must have more than 5 characters");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treatment treatment = (Treatment) o;
        return Objects.equals(value, treatment.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
