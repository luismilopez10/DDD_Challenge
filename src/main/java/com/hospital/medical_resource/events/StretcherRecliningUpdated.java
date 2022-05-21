package com.hospital.medical_resource.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_resource.values.Reclining;
import com.hospital.medical_resource.values.StretcherId;

public class StretcherRecliningUpdated extends DomainEvent {
    private StretcherId stretcherId;
    private Reclining reclining;

    public StretcherRecliningUpdated(StretcherId entityId, Reclining reclining) {
        super("hospital.medicalAppointment.stretcherRecliningUpdated");
        this.stretcherId = entityId;
        this.reclining = reclining;
    }

    public StretcherId getStretcherId() {
        return stretcherId;
    }

    public Reclining getReclining() {
        return reclining;
    }
}
