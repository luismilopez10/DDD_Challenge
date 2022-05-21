package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.*;

public class ClinicHistoryAdded extends DomainEvent {
    private ClinicHistoryId clinicHistoryId;
    private ConsultationReason consultationReason;
    private Background background;
    private Diagnosis diagnosis;
    private Treatment treatment;

    public ClinicHistoryAdded(ClinicHistoryId entityId, ConsultationReason consultationReason, Background background, Diagnosis diagnosis, Treatment treatment) {
        super("hospital.medicalAppointment.clinicHistoryAdded");
        this.clinicHistoryId = entityId;
        this.consultationReason = consultationReason;
        this.background = background;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public ClinicHistoryId getClinicHistoryId() {
        return clinicHistoryId;
    }

    public ConsultationReason getConsultationReason() {
        return consultationReason;
    }

    public Background getBackground() {
        return background;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public Treatment getTreatment() {
        return treatment;
    }
}
