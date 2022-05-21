package com.hospital.medical_appointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.values.ClinicHistoryId;
import com.hospital.medical_appointment.values.ConsultationReason;

public class ClinicHistoryConsultationReasonUpdated extends DomainEvent {
    private ClinicHistoryId clinicHistoryId;
    private ConsultationReason consultationReason;

    public ClinicHistoryConsultationReasonUpdated(ClinicHistoryId entityId, ConsultationReason consultationReason) {
        super("hospital.medicalAppointment.clinicHistoryConsultationReasonUpdated");
        this.clinicHistoryId = entityId;
        this.consultationReason = consultationReason;
    }

    public ClinicHistoryId getClinicHistoryId() {
        return clinicHistoryId;
    }

    public ConsultationReason getConsultationReason() {
        return consultationReason;
    }
}
