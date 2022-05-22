package com.hospital.medical_appointment.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_appointment.values.MedicalAppointmentId;
import com.hospital.medical_appointment.values.PacientId;
import com.hospital.medical_appointment.values.PhoneNumber;

public class UpdatePacientPhoneNumber extends Command {
    private final MedicalAppointmentId medicalAppointmentId;
    private final PacientId entityId;
    private final PhoneNumber phoneNumber;

    public UpdatePacientPhoneNumber(MedicalAppointmentId medicalAppointmentId, PacientId entityId, PhoneNumber phoneNumber) {
        this.medicalAppointmentId = medicalAppointmentId;
        this.entityId = entityId;
        this.phoneNumber = phoneNumber;
    }

    public MedicalAppointmentId getMedicalAppointmentId() {
        return medicalAppointmentId;
    }

    public PacientId getEntityId() {
        return entityId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
