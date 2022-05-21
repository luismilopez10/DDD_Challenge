package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.Name;

public class DoctorNameUpdated extends DomainEvent {
    private Name name;

    public DoctorNameUpdated(Name name) {
        super("hospital.medicalAppointment.doctorNameUpdated");
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
