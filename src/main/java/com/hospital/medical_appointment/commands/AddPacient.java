package com.hospital.medical_appointment.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_appointment.values.MedicalAppointmentId;
import com.hospital.medical_appointment.values.Name;
import com.hospital.medical_appointment.values.PacientId;
import com.hospital.medical_appointment.values.PhoneNumber;

public class AddPacient extends Command {
    private final MedicalAppointmentId medicalAppointmentId;
    private final PacientId entityId;
    private final Name name;
    private final PhoneNumber phoneNumber;

    public AddPacient(MedicalAppointmentId medicalAppointmentId, PacientId entityId, Name name, PhoneNumber phoneNumber) {
        this.medicalAppointmentId = medicalAppointmentId;
        this.entityId = entityId;
        this.name = name;
        this.phoneNumber = phoneNumber;
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

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
