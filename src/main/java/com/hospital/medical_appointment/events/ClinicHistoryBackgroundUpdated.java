package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.Background;
import com.hospital.medical_appointment.values.ClinicHistoryId;

public class ClinicHistoryBackgroundUpdated extends DomainEvent {
    private ClinicHistoryId clinicHistoryId;
    private Background background;

    public ClinicHistoryBackgroundUpdated(ClinicHistoryId entityId, Background background) {
        super("hospital.medicalAppointment.clinicHistoryBackgroundUpdated");
        this.clinicHistoryId = entityId;
        this.background = background;
    }

    public ClinicHistoryId getClinicHistoryId() {
        return clinicHistoryId;
    }

    public Background getBackground() {
        return background;
    }
}
