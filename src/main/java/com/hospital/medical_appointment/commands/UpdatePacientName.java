package com.hospital.medical_appointment.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_appointment.values.MedicalAppointmentId;
import com.hospital.medical_appointment.values.Name;
import com.hospital.medical_appointment.values.PacientId;

public class UpdatePacientName extends Command {
    private final MedicalAppointmentId medicalAppointmentId;
    private final PacientId entityId;
    private final Name name;

    public UpdatePacientName(MedicalAppointmentId medicalAppointmentId, PacientId entityId, Name name) {
        this.medicalAppointmentId = medicalAppointmentId;
        this.entityId = entityId;
        this.name = name;
    }

    public MedicalAppointmentId getMedicalAppointmentId() {
        return medicalAppointmentId;
    }

    public PacientId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
