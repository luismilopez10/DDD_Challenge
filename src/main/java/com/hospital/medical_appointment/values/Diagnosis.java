package com.hospital.medical_appointment.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Diagnosis implements ValueObject<String> {
    private final String value;

    public Diagnosis(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("The diagnosis can not be empty");
        }

        if (this.value.length() <= 5){
            throw new IllegalArgumentException("The diagnosis must have more than 5 characters");
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
        Diagnosis diagnosis = (Diagnosis) o;
        return Objects.equals(value, diagnosis.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
