package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.medical_appointment.MedicalAppointment;
import com.hospital.medical_appointment.commands.UpdateClinicHistoryTreatment;

public class UpdateClinicHistoryTreatmentUseCase extends UseCase<RequestCommand<UpdateClinicHistoryTreatment>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateClinicHistoryTreatment> updateClinicHistoryTreatmentRequestCommand) {
        var command = updateClinicHistoryTreatmentRequestCommand.getCommand();
        var medicalAppointment = MedicalAppointment.from(
                command.getMedicalAppointmentId(),
                repository().getEventsBy(command.getMedicalAppointmentId().value()));

        medicalAppointment.UpdateClinicHistoryTreatment(
                command.getEntityId(),
                command.getTreatment());

        emit().onResponse(new ResponseEvents(medicalAppointment.getUncommittedChanges()));
    }
}
