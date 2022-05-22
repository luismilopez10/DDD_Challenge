package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.medical_appointment.MedicalAppointment;
import com.hospital.medical_appointment.commands.AddDoctor;

public class AddDoctorUseCase extends UseCase<RequestCommand<AddDoctor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddDoctor> addDoctorRequestCommand) {
        var command = addDoctorRequestCommand.getCommand();
        var medicalAppointment = MedicalAppointment.from(
                command.getMedicalAppointmentId(),
                repository().getEventsBy(command.getMedicalAppointmentId().value()));

        medicalAppointment.AddDoctor(
                command.getEntityId(),
                command.getName(),
                command.getEmail());

        emit().onResponse(new ResponseEvents(medicalAppointment.getUncommittedChanges()));
    }
}
