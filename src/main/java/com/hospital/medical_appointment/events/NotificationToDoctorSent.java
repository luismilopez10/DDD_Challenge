package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;

public class NotificationToDoctorSent extends DomainEvent {
    private String message;

    public NotificationToDoctorSent(String message) {
        super("hospital.medicalAppointment.notificationToDoctorSent");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
