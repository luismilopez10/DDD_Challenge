package com.hospital.medical_resource.values;

import co.com.sofka.domain.generic.Identity;

public class StretcherId extends Identity {

    public StretcherId() {
    }

    private StretcherId(String id) {
        super(id);
    }

    public static StretcherId of(String id){
        return new StretcherId(id);
    }
}
