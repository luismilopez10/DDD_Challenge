package com.hospital.medical_resource.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_resource.values.StretcherId;
import com.hospital.medical_resource.values.Type;

public class StretcherTypeUpdated extends DomainEvent {
    private StretcherId entityId;
    private Type type;

    public StretcherTypeUpdated(StretcherId entityId, Type type) {
        super("hospital.medicalAppointment.stretcherTypeUpdated");
        this.entityId = entityId;
        this.type = type;
    }

    public StretcherId getEntityId() {
        return entityId;
    }

    public Type getType() {
        return type;
    }
}
