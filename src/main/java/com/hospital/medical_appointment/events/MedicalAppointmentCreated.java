package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.AppointmentDate;

public class MedicalAppointmentCreated extends DomainEvent {
    private final AppointmentDate appointmentDate;

    public MedicalAppointmentCreated(AppointmentDate appointmentDate) {
        super("hospital.medicalAppointment.medicalAppointmentCreated");
        this.appointmentDate = appointmentDate;
    }

    public AppointmentDate getAppointmentDate() {
        return appointmentDate;
    }
}
