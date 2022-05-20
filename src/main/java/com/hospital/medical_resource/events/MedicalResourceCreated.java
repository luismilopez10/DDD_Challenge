package com.hospital.medical_resource.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.Name;

public class MedicalResourceCreated extends DomainEvent {
    private final Name name;

    public MedicalResourceCreated(Name name) {
        super("hospital.medicalResource.medicalResourceCreated");
        this.name = name;
    }

    public Name name() {
        return name;
    }
}
