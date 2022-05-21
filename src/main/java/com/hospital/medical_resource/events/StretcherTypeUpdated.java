package com.hospital.medical_resource.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_resource.values.StretcherId;
import com.hospital.medical_resource.values.Type;

public class StretcherTypeUpdated extends DomainEvent {
    private StretcherId stretcherId;
    private Type type;

    public StretcherTypeUpdated(StretcherId entityId, Type type) {
        super("hospital.medicalAppointment.stretcherTypeUpdated");
        this.stretcherId = entityId;
        this.type = type;
    }

    public StretcherId getStretcherId() {
        return stretcherId;
    }

    public Type getType() {
        return type;
    }
}
