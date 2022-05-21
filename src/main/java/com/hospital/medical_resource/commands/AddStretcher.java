package com.hospital.medical_resource.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_resource.values.MedicalResourceId;
import com.hospital.medical_resource.values.Reclining;
import com.hospital.medical_resource.values.StretcherId;
import com.hospital.medical_resource.values.Type;

public class AddStretcher extends Command {
    private MedicalResourceId medicalResourceId;
    private StretcherId entityId;
    private Type type;
    private Reclining reclining;

    public AddStretcher(MedicalResourceId medicalResourceId, StretcherId entityId, Type type, Reclining reclining) {
        this.medicalResourceId = medicalResourceId;
        this.entityId = entityId;
        this.type = type;
        this.reclining = reclining;
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

    public Reclining getReclining() {
        return reclining;
    }
}
