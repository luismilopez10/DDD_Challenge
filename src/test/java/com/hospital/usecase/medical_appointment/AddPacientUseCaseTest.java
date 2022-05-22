package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.hospital.medical_appointment.commands.AddPacient;
import com.hospital.medical_appointment.events.DoctorAdded;
import com.hospital.medical_appointment.events.MedicalAppointmentCreated;
import com.hospital.medical_appointment.events.PacientAdded;
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
class AddPacientUseCaseTest {

    private final String ROOTID = "MA-0001";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addPacient() throws ParseException {

        // Arrange
        var command = new AddPacient(
                MedicalAppointmentId.of(ROOTID),
                PacientId.of("PC-0001"),
                new Name("Mrs. White"),
                new PhoneNumber("314-568-7912"));

        var useCase = new AddPacientUseCase();
        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new MedicalAppointmentCreated(
                        new AppointmentDate("04/12/2022")
                )
        ));
        useCase.addRepository(repository);

        // Act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while adding the pacient"))
                .getDomainEvents();

        // Assert
        PacientAdded event = (PacientAdded) events.get(0);
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getPhoneNumber().value(), event.getPhoneNumber().value());
    }
}