package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.PacientId;
import com.hospital.medical_appointment.values.PhoneNumber;

public class PacientPhoneNumberUpdated extends DomainEvent {
    private PacientId entityId;
    private PhoneNumber phoneNumber;

    public PacientPhoneNumberUpdated(PacientId entityId, PhoneNumber phoneNumber) {
        super("hospital.medicalAppointment.pacientPhoneNumberUpdated");
        this.entityId = entityId;
        this.phoneNumber = phoneNumber;
    }

    public PacientId getEntityId() {
        return entityId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
