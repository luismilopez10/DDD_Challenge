package com.hospital.medical_resource;

import co.com.sofka.domain.generic.Entity;
import com.hospital.medical_resource.values.Address;
import com.hospital.medical_resource.values.ConsultingRoomId;

import java.util.Objects;

public class ConsultingRoom extends Entity<ConsultingRoomId> {

    private Address address;

    public ConsultingRoom(ConsultingRoomId entityId, Address address) {
        super(entityId);
        this.address = address;
    }

    // Getters
    public Address address() {
        return address;
    }

    // Behaviors
    public void updateAddress(Address address){
        this.address = Objects.requireNonNull(address);
    }
}
