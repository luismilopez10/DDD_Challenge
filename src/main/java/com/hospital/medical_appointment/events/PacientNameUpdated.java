package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.Name;
import com.hospital.medical_appointment.values.PacientId;

public class PacientNameUpdated extends DomainEvent {
    private PacientId entityId;
    private Name name;

    public PacientNameUpdated(PacientId entityId, Name name) {
        super("hospital.medicalAppointment.pacientNameUpdated");
        this.entityId = entityId;
        this.name = name;
    }

    public PacientId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
