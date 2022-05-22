package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.hospital.medical_appointment.commands.UpdateClinicHistoryConsultationReason;
import com.hospital.medical_appointment.events.ClinicHistoryAdded;
import com.hospital.medical_appointment.events.ClinicHistoryConsultationReasonUpdated;
import com.hospital.medical_appointment.events.MedicalAppointmentCreated;
import com.hospital.medical_appointment.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UpdateClinicHistoryConsultationReasonUseCaseTest {

    private final String ROOTID = "MA-0001";
    private final String CLINIC_HISTORY_ID = "CH-0001";

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateClinicHistoryConsultationReason() throws ParseException {

        // Arrange
        var command = new UpdateClinicHistoryConsultationReason(
                MedicalAppointmentId.of(ROOTID),
                ClinicHistoryId.of(CLINIC_HISTORY_ID),
                new ConsultationReason("I have a migraine episode"));

        var useCase = new UpdateClinicHistoryConsultationReasonUseCase();
        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new MedicalAppointmentCreated(
                        new AppointmentDate("04/12/2022")
                ),
                new ClinicHistoryAdded(
                        ClinicHistoryId.of(CLINIC_HISTORY_ID),
                        new ConsultationReason("I have a headache"),
                        new Background("The patient has constant episodes of migraine"),
                        new Diagnosis("Migraine episode with aura"),
                        new Treatment("Neosaldina 30mg")
                )
        ));
        useCase.addRepository(repository);

        // Act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while updating the clinic history consultation reason"))
                .getDomainEvents();

        // Assert
        ClinicHistoryConsultationReasonUpdated event = (ClinicHistoryConsultationReasonUpdated) events.get(0);
        Assertions.assertEquals(command.getConsultationReason().value(), event.getConsultationReason().value());
    }

}