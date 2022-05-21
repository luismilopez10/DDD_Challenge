package com.hospital.medical_appointment.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_appointment.values.DoctorId;
import com.hospital.medical_appointment.values.MedicalAppointmentId;
import com.hospital.medical_appointment.values.Name;

public class UpdateDoctorName extends Command {
    private MedicalAppointmentId medicalAppointmentId;
    private DoctorId entityId;
    private Name name;

    public UpdateDoctorName(MedicalAppointmentId medicalAppointmentId, DoctorId entityId, Name name) {
        this.medicalAppointmentId = medicalAppointmentId;
        this.entityId = entityId;
        this.name = name;
    }

    public MedicalAppointmentId getMedicalAppointmentId() {
        return medicalAppointmentId;
    }

    public DoctorId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
