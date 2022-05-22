package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.hospital.medical_appointment.commands.AddDoctor;
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
class AddDoctorUseCaseTest {

    private final String ROOTID = "MA-0001";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addDoctor() throws ParseException {

        // Arrange
        var command = new AddDoctor(
                MedicalAppointmentId.of(ROOTID),
                DoctorId.of("DR-0001"),
                new Name("Dr. Nobody"),
                new Email("doctor@gmail.com"));

        var useCase = new AddDoctorUseCase();
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
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while adding the doctor"))
                .getDomainEvents();

        // Assert
        DoctorAdded event = (DoctorAdded) events.get(0);
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getEmail().value(), event.getEmail().value());
    }
}