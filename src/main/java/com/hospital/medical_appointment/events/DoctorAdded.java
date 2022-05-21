package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.DoctorId;
import com.hospital.medical_appointment.values.Email;
import com.hospital.medical_appointment.values.Name;

public class DoctorAdded extends DomainEvent {
    private DoctorId doctorId;
    private Name name;
    private Email email;

    public DoctorAdded(DoctorId entityId, Name name, Email email) {
        super("hospital.medicalAppointment.doctorAdded");
        this.doctorId = entityId;
        this.name = name;
        this.email = email;
    }

    public DoctorId getDoctorId() {
        return doctorId;
    }

    public Name getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }
}
