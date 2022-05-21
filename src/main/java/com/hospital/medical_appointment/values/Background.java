package com.hospital.medical_appointment.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Background implements ValueObject<String> {
    private final String value;

    public Background(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("The background can not be empty");
        }

        if (this.value.length() <= 5){
            throw new IllegalArgumentException("The background must have more than 5 characters");
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
        Background that = (Background) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
