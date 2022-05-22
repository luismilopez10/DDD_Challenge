package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.hospital.medical_appointment.commands.UpdateDoctorName;
import com.hospital.medical_appointment.events.DoctorAdded;
import com.hospital.medical_appointment.events.DoctorNameUpdated;
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
class UpdateDoctorNameUseCaseTest {

    private final String ROOTID = "MA-0001";
    private final String DOCTOR_ID = "DR-0001";

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateDoctorName() throws ParseException {

        // Arrange
        var command = new UpdateDoctorName(
                MedicalAppointmentId.of(ROOTID),
                DoctorId.of(DOCTOR_ID),
                new Name("Dr. Nobody Who"));

        var useCase = new UpdateDoctorNameUseCase();
        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new MedicalAppointmentCreated(
                        new AppointmentDate("04/12/2022")
                ),
                new DoctorAdded(
                        DoctorId.of(DOCTOR_ID),
                        new Name("Dr. Nobody"),
                        new Email("doctor@gmail.com")
                )
        ));
        useCase.addRepository(repository);

        // Act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while updating the doctor's name"))
                .getDomainEvents();

        // Assert
        DoctorNameUpdated event = (DoctorNameUpdated) events.get(0);
        Assertions.assertEquals(command.getName().value(), event.getName().value());
    }
}