package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.hospital.medical_appointment.MedicalAppointment;
import com.hospital.medical_appointment.events.MedicalAppointmentCreated;
import com.hospital.medical_appointment.values.MedicalAppointmentId;

public class NotifyDoctorUseCase extends UseCase<TriggeredEvent<MedicalAppointmentCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<MedicalAppointmentCreated> medicalAppointmentCreatedTriggeredEvent) {
        var event = medicalAppointmentCreatedTriggeredEvent.getDomainEvent();
        var medicalAppointment = MedicalAppointment.from(
                MedicalAppointmentId.of(event.aggregateRootId()), this.retrieveEvents());
        medicalAppointment.notifyDoctor("A pacient just assigned a medical appointment with you");

        emit().onResponse(new ResponseEvents(medicalAppointment.getUncommittedChanges()));
    }
}
