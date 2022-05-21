package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.ClinicHistoryId;
import com.hospital.medical_appointment.values.Treatment;

public class ClinicHistoryTreatmentUpdated extends DomainEvent {
    private ClinicHistoryId entityId;
    private Treatment treatment;

    public ClinicHistoryTreatmentUpdated(ClinicHistoryId entityId, Treatment treatment) {
        super("hospital.medicalAppointment.clinicHistoryTreatmentUpdated");
        this.entityId = entityId;
        this.treatment = treatment;
    }

    public ClinicHistoryId getEntityId() {
        return entityId;
    }

    public Treatment getTreatment() {
        return treatment;
    }
}
