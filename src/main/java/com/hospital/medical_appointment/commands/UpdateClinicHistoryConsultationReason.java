package com.hospital.medical_appointment.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_appointment.values.ClinicHistoryId;
import com.hospital.medical_appointment.values.ConsultationReason;
import com.hospital.medical_appointment.values.MedicalAppointmentId;

public class UpdateClinicHistoryConsultationReason extends Command {
    private MedicalAppointmentId medicalAppointmentId;
    private ClinicHistoryId entityId;
    private ConsultationReason consultationReason;

    public UpdateClinicHistoryConsultationReason(MedicalAppointmentId medicalAppointmentId, ClinicHistoryId entityId, ConsultationReason consultationReason) {
        this.medicalAppointmentId = medicalAppointmentId;
        this.entityId = entityId;
        this.consultationReason = consultationReason;
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
}
