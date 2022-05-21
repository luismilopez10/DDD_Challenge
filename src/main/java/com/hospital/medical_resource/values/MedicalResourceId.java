package com.hospital.medical_resource.values;

import co.com.sofka.domain.generic.Identity;

public class MedicalResourceId extends Identity {

    public MedicalResourceId() {
    }

    private MedicalResourceId(String id) {
        super(id);
    }

    public static MedicalResourceId of(String id){
        return new MedicalResourceId(id);
    }
}
