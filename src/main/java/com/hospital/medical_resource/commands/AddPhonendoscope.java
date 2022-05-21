package com.hospital.medical_resource.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_resource.values.Brand;
import com.hospital.medical_resource.values.MedicalResourceId;
import com.hospital.medical_resource.values.PhonendoscopeId;

public class AddPhonendoscope extends Command {
    private MedicalResourceId medicalResourceId;
    private PhonendoscopeId entityId;
    private Brand brand;

    public AddPhonendoscope(MedicalResourceId medicalResourceId, PhonendoscopeId entityId, Brand brand) {
        this.medicalResourceId = medicalResourceId;
        this.entityId = entityId;
        this.brand = brand;
    }

    public MedicalResourceId getMedicalResourceId() {
        return medicalResourceId;
    }

    public PhonendoscopeId getEntityId() {
        return entityId;
    }

    public Brand getBrand() {
        return brand;
    }
}
