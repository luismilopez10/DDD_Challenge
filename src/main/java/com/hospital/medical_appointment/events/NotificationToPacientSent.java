package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;

public class NotificationToPacientSent extends DomainEvent {
    private String message;

    public NotificationToPacientSent(String message) {
        super("hospital.medicalAppointment.notificationToPacientSent");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
