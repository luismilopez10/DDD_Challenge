package com.hospital.medical_appointment.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_appointment.values.DoctorId;
import com.hospital.medical_appointment.values.Email;
import com.hospital.medical_appointment.values.MedicalAppointmentId;

public class UpdateDoctorEmail extends Command {
    private MedicalAppointmentId medicalAppointmentId;
    private DoctorId entityId;
    private Email email;

    public UpdateDoctorEmail(MedicalAppointmentId medicalAppointmentId, DoctorId entityId, Email email) {
        this.medicalAppointmentId = medicalAppointmentId;
        this.entityId = entityId;
        this.email = email;
    }

    public MedicalAppointmentId getMedicalAppointmentId() {
        return medicalAppointmentId;
    }

    public DoctorId getEntityId() {
        return entityId;
    }

    public Email getEmail() {
        return email;
    }
}
