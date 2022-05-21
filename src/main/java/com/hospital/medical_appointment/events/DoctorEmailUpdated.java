package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.DoctorId;
import com.hospital.medical_appointment.values.Email;

public class DoctorEmailUpdated extends DomainEvent {
    private DoctorId doctorId;
    private Email email;

    public DoctorEmailUpdated(DoctorId entityId, Email email) {
        super("hospital.medicalAppointment.doctorEmailUpdated");
        this.doctorId = entityId;
        this.email = email;
    }

    public DoctorId getDoctorId() {
        return doctorId;
    }

    public Email getEmail() {
        return email;
    }
}
