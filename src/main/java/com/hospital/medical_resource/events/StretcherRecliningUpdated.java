package com.hospital.medical_resource.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_resource.values.Reclining;
import com.hospital.medical_resource.values.StretcherId;

public class StretcherRecliningUpdated extends DomainEvent {
    private StretcherId entityId;
    private Reclining reclining;

    public StretcherRecliningUpdated(StretcherId entityId, Reclining reclining) {
        super("hospital.medicalAppointment.stretcherRecliningUpdated");
        this.entityId = entityId;
        this.reclining = reclining;
    }

    public StretcherId getEntityId() {
        return entityId;
    }

    public Reclining getReclining() {
        return reclining;
    }
}
