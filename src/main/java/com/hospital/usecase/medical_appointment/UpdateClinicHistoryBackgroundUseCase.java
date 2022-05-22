package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.medical_appointment.MedicalAppointment;
import com.hospital.medical_appointment.commands.UpdateClinicHistoryBackground;

public class UpdateClinicHistoryBackgroundUseCase extends UseCase<RequestCommand<UpdateClinicHistoryBackground>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateClinicHistoryBackground> updateClinicHistoryBackgroundRequestCommand) {
        var command = updateClinicHistoryBackgroundRequestCommand.getCommand();
        var medicalAppointment = MedicalAppointment.from(
                command.getMedicalAppointmentId(),
                repository().getEventsBy(command.getMedicalAppointmentId().value()));

        medicalAppointment.UpdateClinicHistoryBackground(
                command.getEntityId(),
                command.getBackground());

        emit().onResponse(new ResponseEvents(medicalAppointment.getUncommittedChanges()));
    }
}
