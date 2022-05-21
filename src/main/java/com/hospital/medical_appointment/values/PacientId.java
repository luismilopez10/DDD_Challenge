package com.hospital.medical_appointment.values;

import co.com.sofka.domain.generic.Identity;

public class PacientId extends Identity {

    public PacientId() {
    }

    private PacientId(String id) {
        super(id);
    }

    public static PacientId of(String id){
        return new PacientId(id);
    }
}
