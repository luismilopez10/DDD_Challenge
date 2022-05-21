package com.hospital.medical_appointment.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_appointment.values.ClinicHistoryId;
import com.hospital.medical_appointment.values.Diagnosis;
import com.hospital.medical_appointment.values.MedicalAppointmentId;

public class UpdateClinicHistoryDiagnosis extends Command {
    private MedicalAppointmentId medicalAppointmentId;
    private ClinicHistoryId entityId;
    private Diagnosis diagnosis;

    public UpdateClinicHistoryDiagnosis(MedicalAppointmentId medicalAppointmentId, ClinicHistoryId entityId, Diagnosis diagnosis) {
        this.medicalAppointmentId = medicalAppointmentId;
        this.entityId = entityId;
        this.diagnosis = diagnosis;
    }

    public MedicalAppointmentId getMedicalAppointmentId() {
        return medicalAppointmentId;
    }

    public ClinicHistoryId getEntityId() {
        return entityId;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }
}
