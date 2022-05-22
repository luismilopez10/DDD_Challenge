package com.hospital.medical_appointment.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_appointment.values.ClinicHistoryId;
import com.hospital.medical_appointment.values.MedicalAppointmentId;
import com.hospital.medical_appointment.values.Treatment;

public class UpdateClinicHistoryTreatment extends Command {
    private final MedicalAppointmentId medicalAppointmentId;
    private final ClinicHistoryId entityId;
    private final Treatment treatment;

    public UpdateClinicHistoryTreatment(MedicalAppointmentId medicalAppointmentId, ClinicHistoryId entityId, Treatment treatment) {
        this.medicalAppointmentId = medicalAppointmentId;
        this.entityId = entityId;
        this.treatment = treatment;
    }

    public MedicalAppointmentId getMedicalAppointmentId() {
        return medicalAppointmentId;
    }

    public ClinicHistoryId getEntityId() {
        return entityId;
    }

    public Treatment getTreatment() {
        return treatment;
    }
}
