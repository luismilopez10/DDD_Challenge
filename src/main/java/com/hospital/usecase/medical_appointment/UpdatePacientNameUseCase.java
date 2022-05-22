package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.medical_appointment.MedicalAppointment;
import com.hospital.medical_appointment.commands.UpdatePacientName;

public class UpdatePacientNameUseCase extends UseCase<RequestCommand<UpdatePacientName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdatePacientName> updatePacientNameRequestCommand) {
        var command = updatePacientNameRequestCommand.getCommand();
        var medicalAppointment = MedicalAppointment.from(
                command.getMedicalAppointmentId(),
                repository().getEventsBy(command.getMedicalAppointmentId().value()));

        medicalAppointment.UpdatePacientName(
                command.getEntityId(),
                command.getName());

        emit().onResponse(new ResponseEvents(medicalAppointment.getUncommittedChanges()));
    }
}
