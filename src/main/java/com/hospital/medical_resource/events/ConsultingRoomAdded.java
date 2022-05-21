package com.hospital.medical_resource.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_resource.values.Address;
import com.hospital.medical_resource.values.ConsultingRoomId;

public class ConsultingRoomAdded extends DomainEvent {
    private ConsultingRoomId consultingRoomId;
    private Address address;

    public ConsultingRoomAdded(ConsultingRoomId entityId, Address address) {
        super("hospital.medicalAppointment.consultingRoomAdded");
        this.consultingRoomId = entityId;
        this.address = address;
    }

    public ConsultingRoomId getConsultingRoomId() {
        return consultingRoomId;
    }

    public Address getAddress() {
        return address;
    }
}
