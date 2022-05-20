package com.hospital.medical_resource;

import co.com.sofka.domain.generic.Entity;
import com.hospital.medical_resource.values.Brand;
import com.hospital.medical_resource.values.PhonendoscopeId;

import java.util.Objects;

public class Phonendoscope extends Entity<PhonendoscopeId> {

    private Brand brand;

    public Phonendoscope(PhonendoscopeId entityId, Brand brand) {
        super(entityId);
        this.brand = brand;
    }

    // Getters
    public Brand brand() {
        return brand;
    }

    // Behaviors
    public void updateBrand(Brand brand) {
        this.brand = Objects.requireNonNull(brand);
    }
}
