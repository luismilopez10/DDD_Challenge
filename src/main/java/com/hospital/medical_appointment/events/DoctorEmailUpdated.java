package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.DoctorId;
import com.hospital.medical_appointment.values.Email;

public class DoctorEmailUpdated extends DomainEvent {
    private DoctorId entityId;
    private Email email;

    public DoctorEmailUpdated(DoctorId entityId, Email email) {
        super("hospital.medicalAppointment.doctorEmailUpdated");
        this.entityId = entityId;
        this.email = email;
    }

    public DoctorId getEntityId() {
        return entityId;
    }

    public Email getEmail() {
        return email;
    }
}
