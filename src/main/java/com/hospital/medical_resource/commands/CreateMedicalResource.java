package com.hospital.medical_resource.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_appointment.values.Name;
import com.hospital.medical_resource.values.MedicalResourceId;

public class CreateMedicalResource extends Command {
    private MedicalResourceId medicalResourceId;
    private Name name;

    public CreateMedicalResource(MedicalResourceId entityId, Name name) {
        medicalResourceId = entityId;
        this.name = name;
    }

    public MedicalResourceId getMedicalResourceId() {
        return medicalResourceId;
    }

    public Name getName() {
        return name;
    }
}
