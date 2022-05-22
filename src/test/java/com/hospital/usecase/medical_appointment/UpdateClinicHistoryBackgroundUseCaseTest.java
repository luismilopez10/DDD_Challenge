package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.hospital.medical_appointment.commands.AddClinicHistory;
import com.hospital.medical_appointment.commands.UpdateClinicHistoryBackground;
import com.hospital.medical_appointment.events.ClinicHistoryAdded;
import com.hospital.medical_appointment.events.ClinicHistoryBackgroundUpdated;
import com.hospital.medical_appointment.events.DoctorAdded;
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
class UpdateClinicHistoryBackgroundUseCaseTest {

    private final String ROOTID = "MA-0001";
    private final String CLINIC_HISTORYID = "CH-0001";

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateClinicHistoryBackground() throws ParseException {

        // Arrange
        var command = new UpdateClinicHistoryBackground(
                MedicalAppointmentId.of(ROOTID),
                ClinicHistoryId.of(CLINIC_HISTORYID),
                new Background("The patient has constant episodes of migraine and headaches"));

        var useCase = new UpdateClinicHistoryBackgroundUseCase();
        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new MedicalAppointmentCreated(
                        new AppointmentDate("04/12/2022")
                ),
                new ClinicHistoryAdded(
                        ClinicHistoryId.of(CLINIC_HISTORYID),
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
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while updating the clinic history background"))
                .getDomainEvents();

        // Assert
        ClinicHistoryBackgroundUpdated event = (ClinicHistoryBackgroundUpdated) events.get(0);
        Assertions.assertEquals(command.getBackground().value(), event.getBackground().value());
    }

}