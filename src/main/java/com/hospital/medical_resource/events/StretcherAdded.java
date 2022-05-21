package com.hospital.medical_resource.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_resource.values.Reclining;
import com.hospital.medical_resource.values.StretcherId;
import com.hospital.medical_resource.values.Type;

public class StretcherAdded extends DomainEvent {
    private StretcherId stretcherId;
    private Type type;
    private Reclining reclining;

    public StretcherAdded(StretcherId entityId, Type type, Reclining reclining) {
        super("hospital.medicalAppointment.stretcherAdded");
        this.stretcherId = entityId;
        this.type = type;
        this.reclining = reclining;
    }

    public StretcherId getStretcherId() {
        return stretcherId;
    }

    public Type getType() {
        return type;
    }

    public Reclining getReclining() {
        return reclining;
    }
}
