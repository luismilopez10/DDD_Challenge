package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.Name;
import com.hospital.medical_appointment.values.PacientId;
import com.hospital.medical_appointment.values.PhoneNumber;

public class PacientAdded extends DomainEvent {
    private final PacientId entityId;
    private final Name name;
    private final PhoneNumber phoneNumber;

    public PacientAdded(PacientId entityId, Name name, PhoneNumber phoneNumber) {
        super("hospital.medicalAppointment.pacientAdded");
        this.entityId = entityId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public PacientId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
