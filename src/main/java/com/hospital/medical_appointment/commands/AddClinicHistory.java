package com.hospital.medical_appointment.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_appointment.values.*;

public class AddClinicHistory extends Command {
    private MedicalAppointmentId medicalAppointmentId;
    private ClinicHistoryId entityId;
    private ConsultationReason consultationReason;
    private Background background;
    private Diagnosis diagnosis;
    private Treatment treatment;

    public AddClinicHistory(MedicalAppointmentId medicalAppointmentId, ClinicHistoryId entityId, ConsultationReason consultationReason, Background background, Diagnosis diagnosis, Treatment treatment) {
        this.medicalAppointmentId = medicalAppointmentId;
        this.entityId = entityId;
        this.consultationReason = consultationReason;
        this.background = background;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public MedicalAppointmentId getMedicalAppointmentId() {
        return medicalAppointmentId;
    }

    public ClinicHistoryId getEntityId() {
        return entityId;
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
