package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.ClinicHistoryId;
import com.hospital.medical_appointment.values.Diagnosis;

public class ClinicHistoryDiagnosisUpdated extends DomainEvent {
    private ClinicHistoryId entityId;
    private Diagnosis diagnosis;

    public ClinicHistoryDiagnosisUpdated(ClinicHistoryId entityId, Diagnosis diagnosis) {
        super("hospital.medicalAppointment.clinicHistoryDiagnosisUpdated");
        this.entityId = entityId;
        this.diagnosis = diagnosis;
    }

    public ClinicHistoryId getEntityId() {
        return entityId;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }
}
