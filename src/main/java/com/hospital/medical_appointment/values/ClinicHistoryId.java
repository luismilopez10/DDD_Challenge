package com.hospital.medical_appointment.values;

import co.com.sofka.domain.generic.Identity;

public class ClinicHistoryId extends Identity {

    public ClinicHistoryId() {
    }

    private ClinicHistoryId(String id) {
        super(id);
    }

    public static ClinicHistoryId of(String id){
        return new ClinicHistoryId(id);
    }
}
