package com.hospital.medical_resource.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_resource.values.MedicalResourceId;
import com.hospital.medical_resource.values.Reclining;
import com.hospital.medical_resource.values.StretcherId;

public class UpdateStretcherReclining extends Command {
    private MedicalResourceId medicalResourceId;
    private StretcherId entityId;
    private Reclining reclining;

    public UpdateStretcherReclining(MedicalResourceId medicalResourceId, StretcherId entityId, Reclining reclining) {
        this.medicalResourceId = medicalResourceId;
        this.entityId = entityId;
        this.reclining = reclining;
    }

    public MedicalResourceId getMedicalResourceId() {
        return medicalResourceId;
    }

    public StretcherId getEntityId() {
        return entityId;
    }

    public Reclining getReclining() {
        return reclining;
    }
}
