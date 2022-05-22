package com.hospital.medical_appointment.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_appointment.values.DoctorId;
import com.hospital.medical_appointment.values.Email;
import com.hospital.medical_appointment.values.MedicalAppointmentId;
import com.hospital.medical_appointment.values.Name;

public class AddDoctor extends Command {
    private final MedicalAppointmentId medicalAppointmentId;
    private final DoctorId entityId;
    private final Name name;
    private final Email email;

    public AddDoctor(MedicalAppointmentId medicalAppointmentId, DoctorId entityId, Name name, Email email) {
        this.medicalAppointmentId = medicalAppointmentId;
        this.entityId = entityId;
        this.name = name;
        this.email = email;
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

    public Email getEmail() {
        return email;
    }
}
