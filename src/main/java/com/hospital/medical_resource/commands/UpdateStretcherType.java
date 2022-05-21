package com.hospital.medical_resource.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_resource.values.MedicalResourceId;
import com.hospital.medical_resource.values.StretcherId;
import com.hospital.medical_resource.values.Type;

public class UpdateStretcherType extends Command {
    private MedicalResourceId medicalResourceId;
    private StretcherId entityId;
    private Type type;

    public UpdateStretcherType(MedicalResourceId medicalResourceId, StretcherId entityId, Type type) {
        this.medicalResourceId = medicalResourceId;
        this.entityId = entityId;
        this.type = type;
    }

    public MedicalResourceId getMedicalResourceId() {
        return medicalResourceId;
    }

    public StretcherId getEntityId() {
        return entityId;
    }

    public Type getType() {
        return type;
    }
}
