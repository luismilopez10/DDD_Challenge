package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.Name;
import com.hospital.medical_appointment.values.PacientId;

public class PacientNameUpdated extends DomainEvent {
    private PacientId pacientId;
    private Name name;

    public PacientNameUpdated(PacientId entityId, Name name) {
        super("hospital.medicalAppointment.pacientNameUpdated");
        this.pacientId = entityId;
        this.name = name;
    }

    public PacientId getPacientId() {
        return pacientId;
    }

    public Name getName() {
        return name;
    }
}
