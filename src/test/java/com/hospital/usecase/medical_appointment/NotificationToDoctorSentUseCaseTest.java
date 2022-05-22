package com.hospital.usecase.medical_appointment;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.hospital.medical_appointment.events.MedicalAppointmentCreated;
import com.hospital.medical_appointment.events.NotificationToDoctorSent;
import com.hospital.medical_appointment.events.NotificationToPacientSent;
import com.hospital.medical_appointment.values.AppointmentDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class NotificationToDoctorSentUseCaseTest {

    private final String ROOTID = "MA-0001";

    @Mock
    private DomainEventRepository repository;

    @Test
    void notifyDoctor() throws ParseException {

        // Arrange
        var event = new MedicalAppointmentCreated(
                new AppointmentDate("04/12/2022")
        );
        event.setAggregateRootId(ROOTID);

        var useCase = new NotifyDoctorUseCase();
        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                event
        ));
        useCase.addRepository(repository);

        // Act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        NotificationToDoctorSent message = (NotificationToDoctorSent) events.get(0);
        Assertions.assertEquals("A pacient just assigned a medical appointment with you", message.getMessage());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}