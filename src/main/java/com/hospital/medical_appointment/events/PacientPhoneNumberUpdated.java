package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.PacientId;
import com.hospital.medical_appointment.values.PhoneNumber;

public class PacientPhoneNumberUpdated extends DomainEvent {
    private PacientId pacientId;
    private PhoneNumber phoneNumber;

    public PacientPhoneNumberUpdated(PacientId entityId, PhoneNumber phoneNumber) {
        super("hospital.medicalAppointment.pacientPhoneNumberUpdated");
        this.pacientId = entityId;
        this.phoneNumber = phoneNumber;
    }

    public PacientId getPacientId() {
        return pacientId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
