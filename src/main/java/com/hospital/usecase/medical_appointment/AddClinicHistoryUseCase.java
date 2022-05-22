package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hospital.medical_appointment.MedicalAppointment;
import com.hospital.medical_appointment.commands.AddClinicHistory;

public class AddClinicHistoryUseCase extends UseCase<RequestCommand<AddClinicHistory>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddClinicHistory> addClinicHistoryRequestCommand) {
        var command = addClinicHistoryRequestCommand.getCommand();
        var medicalAppointment = MedicalAppointment.from(
                command.getMedicalAppointmentId(),
                repository().getEventsBy(command.getMedicalAppointmentId().value()));

        medicalAppointment.AddClinicHistory(
                command.getEntityId(),
                command.getConsultationReason(),
                command.getBackground(),
                command.getDiagnosis(),
                command.getTreatment());

        emit().onResponse(new ResponseEvents(medicalAppointment.getUncommittedChanges()));
    }
}
