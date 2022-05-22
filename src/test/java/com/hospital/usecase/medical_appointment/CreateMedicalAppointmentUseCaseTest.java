package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.commands.CreateMedicalAppointment;
import com.hospital.medical_appointment.events.MedicalAppointmentCreated;
import com.hospital.medical_appointment.values.AppointmentDate;
import com.hospital.medical_appointment.values.MedicalAppointmentId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.List;

class CreateMedicalAppointmentUseCaseTest {

    @Test
    void createMedicalAppointment() throws ParseException {

        // Arrange
        var command = new CreateMedicalAppointment(
                MedicalAppointmentId.of("MA-0001"),
                new AppointmentDate("04/12/2022"));

        var useCase = new CreateMedicalAppointmentUseCase();

        // Act
        List<DomainEvent> events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while creating the medical appointment"))
                .getDomainEvents();

        // Assert
        MedicalAppointmentCreated event = (MedicalAppointmentCreated) events.get(0);
        Assertions.assertEquals(command.getAppointmentDate().value(), event.getAppointmentDate().value());
    }
}