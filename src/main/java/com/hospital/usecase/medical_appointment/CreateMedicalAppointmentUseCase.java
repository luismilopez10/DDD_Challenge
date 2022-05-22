package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.medical_appointment.MedicalAppointment;
import com.hospital.medical_appointment.commands.CreateMedicalAppointment;

public class CreateMedicalAppointmentUseCase extends UseCase<RequestCommand<CreateMedicalAppointment>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateMedicalAppointment> createMedicalAppointmentRequestCommand) {
        var command = createMedicalAppointmentRequestCommand.getCommand();
        var medicalAppointment = new MedicalAppointment(
                command.getMedicalAppointmentId(),
                command.getAppointmentDate());

        emit().onResponse(new ResponseEvents(medicalAppointment.getUncommittedChanges()));
    }
}
