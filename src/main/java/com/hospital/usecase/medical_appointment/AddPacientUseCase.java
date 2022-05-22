package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.medical_appointment.MedicalAppointment;
import com.hospital.medical_appointment.commands.AddPacient;

public class AddPacientUseCase extends UseCase<RequestCommand<AddPacient>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddPacient> addPacientRequestCommand) {
        var command = addPacientRequestCommand.getCommand();
        var medicalAppointment = MedicalAppointment.from(
                command.getMedicalAppointmentId(),
                repository().getEventsBy(command.getMedicalAppointmentId().value()));

        medicalAppointment.AddPacient(
                command.getEntityId(),
                command.getName(),
                command.getPhoneNumber());

        emit().onResponse(new ResponseEvents(medicalAppointment.getUncommittedChanges()));
    }
}
