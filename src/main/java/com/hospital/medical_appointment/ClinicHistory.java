package com.hospital.medical_appointment;

import co.com.sofka.domain.generic.Entity;
import com.hospital.medical_appointment.values.*;

import java.util.Objects;

public class ClinicHistory extends Entity<ClinicHistoryId> {

    private ConsultationReason consultationReason;
    private Background background;
    private Diagnosis diagnosis;
    private Treatment treatment;

    public ClinicHistory(ClinicHistoryId entityId, ConsultationReason consultationReason, Background background, Diagnosis diagnosis, Treatment treatment) {
        super(entityId);
        this.consultationReason = consultationReason;
        this.background = background;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    // Behaviors
    public void updateConsultationReason(ConsultationReason consultationReason){
        this.consultationReason = Objects.requireNonNull(consultationReason);
    }

    public void updateBackground(Background background){
        this.background = Objects.requireNonNull(background);
    }

    public void updateDiagnosis(Diagnosis diagnosis){
        this.diagnosis = Objects.requireNonNull(diagnosis);
    }

    public void updateTreatment(Treatment treatment){
        this.treatment = Objects.requireNonNull(treatment);
    }

    // Getters
    public ConsultationReason consultationReason() {
        return consultationReason;
    }

    public Background background() {
        return background;
    }

    public Diagnosis diagnosis() {
        return diagnosis;
    }

    public Treatment treatment() {
        return treatment;
    }
}
