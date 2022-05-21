package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.ClinicHistoryId;
import com.hospital.medical_appointment.values.ConsultationReason;

public class ClinicHistoryConsultationReasonUpdated extends DomainEvent {
    private ClinicHistoryId entityId;
    private ConsultationReason consultationReason;

    public ClinicHistoryConsultationReasonUpdated(ClinicHistoryId entityId, ConsultationReason consultationReason) {
        super("hospital.medicalAppointment.clinicHistoryConsultationReasonUpdated");
        this.entityId = entityId;
        this.consultationReason = consultationReason;
    }

    public ClinicHistoryId getEntityId() {
        return entityId;
    }

    public ConsultationReason getConsultationReason() {
        return consultationReason;
    }
}
