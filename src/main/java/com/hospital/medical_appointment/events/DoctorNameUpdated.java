package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.DoctorId;
import com.hospital.medical_appointment.values.Name;

public class DoctorNameUpdated extends DomainEvent {
    private DoctorId doctorId;
    private Name name;

    public DoctorNameUpdated(DoctorId entityId, Name name) {
        super("hospital.medicalAppointment.doctorNameUpdated");
        this.doctorId = entityId;
        this.name = name;
    }

    public DoctorId getDoctorId() {
        return doctorId;
    }

    public Name getName() {
        return name;
    }
}
