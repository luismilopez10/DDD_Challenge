package com.hospital.medical_appointment.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_appointment.values.AppointmentDate;
import com.hospital.medical_appointment.values.MedicalAppointmentId;

public class CreateMedicalAppointment extends Command {

    private MedicalAppointmentId medicalAppointmentId;
    private AppointmentDate appointmentDate;

    public CreateMedicalAppointment(MedicalAppointmentId entityId, AppointmentDate appointmentDate) {
        medicalAppointmentId = entityId;
        this.appointmentDate = appointmentDate;
    }

    public MedicalAppointmentId getMedicalAppointmentId() {
        return medicalAppointmentId;
    }

    public AppointmentDate getAppointmentDate() {
        return appointmentDate;
    }
}
