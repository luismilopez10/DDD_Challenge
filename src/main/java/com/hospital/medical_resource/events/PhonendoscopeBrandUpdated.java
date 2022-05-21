package com.hospital.medical_resource.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_resource.values.Brand;
import com.hospital.medical_resource.values.StretcherId;

public class PhonendoscopeBrandUpdated extends DomainEvent {
    private StretcherId entityId;
    private Brand brand;

    public PhonendoscopeBrandUpdated(StretcherId entityId, Brand brand) {
        super("hospital.medicalAppointment.phonendoscopeBrandUpdated");
        this.entityId = entityId;
        this.brand = brand;
    }

    public StretcherId getEntityId() {
        return entityId;
    }

    public Brand getBrand() {
        return brand;
    }
}
