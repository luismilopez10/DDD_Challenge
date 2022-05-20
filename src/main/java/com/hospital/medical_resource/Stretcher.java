package com.hospital.medical_resource;

import co.com.sofka.domain.generic.Entity;
import com.hospital.medical_appointment.values.Name;
import com.hospital.medical_appointment.values.PhoneNumber;
import com.hospital.medical_resource.values.Reclining;
import com.hospital.medical_resource.values.StretcherId;
import com.hospital.medical_resource.values.Type;

import java.util.Objects;

public class Stretcher extends Entity<StretcherId> {

    private Type type;
    private Reclining reclining;

    public Stretcher(StretcherId entityId, Type type, Reclining reclining) {
        super(entityId);
        this.type = type;
        this.reclining = reclining;
    }

    // Getters
    public Type type() {
        return type;
    }

    public Reclining reclining() {
        return reclining;
    }

    // Behaviors
    public void updateType(Type type){
        this.type = Objects.requireNonNull(type);
    }

    public void updateReclining(Reclining reclining){
        this.reclining = Objects.requireNonNull(reclining);
    }
}
