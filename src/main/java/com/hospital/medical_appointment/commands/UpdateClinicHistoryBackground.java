package com.hospital.medical_appointment.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_appointment.values.Background;
import com.hospital.medical_appointment.values.ClinicHistoryId;
import com.hospital.medical_appointment.values.MedicalAppointmentId;

public class UpdateClinicHistoryBackground extends Command {
    private MedicalAppointmentId medicalAppointmentId;
    private ClinicHistoryId entityId;
    private Background background;

    public UpdateClinicHistoryBackground(MedicalAppointmentId medicalAppointmentId, ClinicHistoryId entityId, Background background) {
        this.medicalAppointmentId = medicalAppointmentId;
        this.entityId = entityId;
        this.background = background;
    }

    public MedicalAppointmentId getMedicalAppointmentId() {
        return medicalAppointmentId;
    }

    public ClinicHistoryId getEntityId() {
        return entityId;
    }

    public Background getBackground() {
        return background;
    }
}
