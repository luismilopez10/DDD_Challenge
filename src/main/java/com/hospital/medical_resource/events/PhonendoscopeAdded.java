package com.hospital.medical_resource.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_resource.values.Brand;
import com.hospital.medical_resource.values.PhonendoscopeId;

public class PhonendoscopeAdded extends DomainEvent {
    private PhonendoscopeId phonendoscopeId;
    private Brand brand;

    public PhonendoscopeAdded(PhonendoscopeId entityId, Brand brand) {
        super("hospital.medicalAppointment.phonendoscopeAdded");
        this.phonendoscopeId = entityId;
        this.brand = brand;
    }

    public PhonendoscopeId getPhonendoscopeId() {
        return phonendoscopeId;
    }

    public Brand getBrand() {
        return brand;
    }
}
