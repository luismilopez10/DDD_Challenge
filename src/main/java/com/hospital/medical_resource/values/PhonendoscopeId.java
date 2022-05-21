package com.hospital.medical_resource.values;

import co.com.sofka.domain.generic.Identity;

public class PhonendoscopeId extends Identity {

    public PhonendoscopeId() {
    }

    private PhonendoscopeId(String id) {
        super(id);
    }

    public static PhonendoscopeId of(String id){
        return new PhonendoscopeId(id);
    }
}
