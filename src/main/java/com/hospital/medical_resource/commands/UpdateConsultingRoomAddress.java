package com.hospital.medical_resource.commands;

import co.com.sofka.domain.generic.Command;
import com.hospital.medical_resource.values.Address;
import com.hospital.medical_resource.values.ConsultingRoomId;
import com.hospital.medical_resource.values.MedicalResourceId;

public class UpdateConsultingRoomAddress extends Command {
    private MedicalResourceId medicalResourceId;
    private ConsultingRoomId entityId;
    private Address address;

    public UpdateConsultingRoomAddress(MedicalResourceId medicalResourceId, ConsultingRoomId entityId, Address address) {
        this.medicalResourceId = medicalResourceId;
        this.entityId = entityId;
        this.address = address;
    }

    public MedicalResourceId getMedicalResourceId() {
        return medicalResourceId;
    }

    public ConsultingRoomId getEntityId() {
        return entityId;
    }

    public Address getAddress() {
        return address;
    }
}
