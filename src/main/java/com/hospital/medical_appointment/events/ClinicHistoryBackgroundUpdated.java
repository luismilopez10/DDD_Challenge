package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.Background;
import com.hospital.medical_appointment.values.ClinicHistoryId;

public class ClinicHistoryBackgroundUpdated extends DomainEvent {
    private ClinicHistoryId entityId;
    private Background background;

    public ClinicHistoryBackgroundUpdated(ClinicHistoryId entityId, Background background) {
        super("hospital.medicalAppointment.clinicHistoryBackgroundUpdated");
        this.entityId = entityId;
        this.background = background;
    }

    public ClinicHistoryId getEntityId() {
        return entityId;
    }

    public Background getBackground() {
        return background;
    }
}
