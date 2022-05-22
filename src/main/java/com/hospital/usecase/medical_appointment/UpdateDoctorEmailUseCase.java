package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.medical_appointment.MedicalAppointment;
import com.hospital.medical_appointment.commands.UpdateDoctorEmail;

public class UpdateDoctorEmailUseCase extends UseCase<RequestCommand<UpdateDoctorEmail>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateDoctorEmail> updateDoctorEmailRequestCommand) {
        var command = updateDoctorEmailRequestCommand.getCommand();
        var medicalAppointment = MedicalAppointment.from(
                command.getMedicalAppointmentId(),
                repository().getEventsBy(command.getMedicalAppointmentId().value()));

        medicalAppointment.UpdateDoctorEmail(
                command.getEntityId(),
                command.getEmail());

        emit().onResponse(new ResponseEvents(medicalAppointment.getUncommittedChanges()));
    }
}
