package com.hospital.medical_resource.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_resource.values.Address;
import com.hospital.medical_resource.values.ConsultingRoomId;

public class ConsultingRoomAddressUpdated extends DomainEvent {
    private ConsultingRoomId entityId;
    private Address address;

    public ConsultingRoomAddressUpdated(ConsultingRoomId entityId, Address address) {
        super("hospital.medicalAppointment.consultingRoomAddressUpdated");
        this.entityId = entityId;
        this.address = address;
    }

    public ConsultingRoomId getEntityId() {
        return entityId;
    }

    public Address getAddress() {
        return address;
    }
}
