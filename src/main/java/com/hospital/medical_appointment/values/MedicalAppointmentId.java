package com.hospital.medical_appointment.values;

import co.com.sofka.domain.generic.Identity;

public class MedicalAppointmentId extends Identity {

    public MedicalAppointmentId() {
    }

    private MedicalAppointmentId(String id) {
        super(id);
    }

    public static MedicalAppointmentId of(String id){
        return new MedicalAppointmentId(id);
    }
}
