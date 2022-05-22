package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.medical_appointment.MedicalAppointment;
import com.hospital.medical_appointment.commands.UpdateClinicHistoryConsultationReason;

public class UpdateClinicHistoryConsultationReasonUseCase extends UseCase<RequestCommand<UpdateClinicHistoryConsultationReason>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateClinicHistoryConsultationReason> updateClinicHistoryConsultationReasonRequestCommand) {
        var command = updateClinicHistoryConsultationReasonRequestCommand.getCommand();
        var medicalAppointment = MedicalAppointment.from(
                command.getMedicalAppointmentId(),
                repository().getEventsBy(command.getMedicalAppointmentId().value()));

        medicalAppointment.UpdateClinicHistoryConsultationReason(
                command.getEntityId(),
                command.getConsultationReason());

        emit().onResponse(new ResponseEvents(medicalAppointment.getUncommittedChanges()));
    }
}
