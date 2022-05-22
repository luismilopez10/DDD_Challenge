package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.hospital.medical_appointment.commands.UpdatePacientPhoneNumber;
import com.hospital.medical_appointment.events.MedicalAppointmentCreated;
import com.hospital.medical_appointment.events.PacientAdded;
import com.hospital.medical_appointment.events.PacientNameUpdated;
import com.hospital.medical_appointment.events.PacientPhoneNumberUpdated;
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
class UpdatePacientPhoneNumberUseCaseTest {

    private final String ROOTID = "MA-0001";
    private final String PACIENT_ID = "PC-0001";

    @Mock
    private DomainEventRepository repository;

    @Test
    void updatePacientPhoneNumber() throws ParseException {

        // Arrange
        var command = new UpdatePacientPhoneNumber(
                MedicalAppointmentId.of(ROOTID),
                PacientId.of(PACIENT_ID),
                new PhoneNumber("314-568-7911"));

        var useCase = new UpdatePacientPhoneNumberUseCase();
        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new MedicalAppointmentCreated(
                        new AppointmentDate("04/12/2022")
                ),
                new PacientAdded(
                        PacientId.of(PACIENT_ID),
                        new Name("Mrs. White"),
                        new PhoneNumber("314-568-7912")
                )
        ));
        useCase.addRepository(repository);

        // Act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while updating the pacient's phone number"))
                .getDomainEvents();

        // Assert
        PacientPhoneNumberUpdated event = (PacientPhoneNumberUpdated) events.get(0);
        Assertions.assertEquals(command.getPhoneNumber().value(), event.getPhoneNumber().value());
    }
}