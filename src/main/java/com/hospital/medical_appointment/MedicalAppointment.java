package com.hospital.medical_appointment;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.hospital.medical_appointment.events.*;
import com.hospital.medical_appointment.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class MedicalAppointment extends AggregateEvent<MedicalAppointmentId> {
    protected AppointmentDate appointmentDate;
    protected Set<Pacient> pacients;
    protected Set<Doctor> doctors;
    protected Set<ClinicHistory> clinicHistories;

    public MedicalAppointment(MedicalAppointmentId entityId, AppointmentDate appointmentDate) {
        super(entityId);
        appendChange(new MedicalAppointmentCreated(appointmentDate)).apply();
    }

    private MedicalAppointment(MedicalAppointmentId entityId) {
        super(entityId);
        subscribe(new MedicalAppointmentChange(this));
    }

    public static MedicalAppointment from(MedicalAppointmentId medicalAppointmentId, List<DomainEvent> events) {
        var medicalAppointment = new MedicalAppointment(medicalAppointmentId);
        events.forEach(medicalAppointment::applyEvent);
        return medicalAppointment;
    }

    // Getters
    public MedicalAppointmentId medicalAppointmentId() {
        return entityId;
    }

    public AppointmentDate appointmentDate() {
        return appointmentDate;
    }

    public Set<Pacient> pacients() {
        return pacients;
    }

    public Set<Doctor> doctors() {
        return doctors;
    }

    public Set<ClinicHistory> clinicHistories() {
        return clinicHistories;
    }

    // Pacient Behaviors
    public void AddPacient(PacientId entityId, Name name, PhoneNumber phoneNumber) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(phoneNumber);
        appendChange(new PacientAdded(entityId, name, phoneNumber)).apply();
    }

    protected Optional<Pacient> getPacientById(PacientId entityId) {
        return pacients()
                .stream()
                .filter(pacient -> pacient.identity().equals(entityId))
                .findFirst();
    }

    public void UpdatePacientName(PacientId entityId, Name name) {
        appendChange(new PacientNameUpdated(entityId, name)).apply();
    }

    public void UpdatePacientPhoneNumber(PacientId entityId, PhoneNumber phoneNumber) {
        appendChange(new PacientPhoneNumberUpdated(entityId, phoneNumber)).apply();
    }

    // Doctor Behaviors
    public void AddDoctor(DoctorId entityId, Name name, Email email) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        appendChange(new DoctorAdded(entityId, name, email)).apply();
    }

    protected Optional<Doctor> getDoctorById(DoctorId entityId) {
        return doctors()
                .stream()
                .filter(doctor -> doctor.identity().equals(entityId))
                .findFirst();
    }

    public void UpdateDoctorName(DoctorId entityId, Name name) {
        appendChange(new DoctorNameUpdated(entityId, name)).apply();
    }

    public void UpdateDoctorEmail(DoctorId entityId, Email email) {
        appendChange(new DoctorEmailUpdated(entityId, email)).apply();
    }

    // ClinicHistory Behaviors
    public void AddClinicHistory(ClinicHistoryId entityId, ConsultationReason consultationReason, Background background, Diagnosis diagnosis, Treatment treatment) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(consultationReason);
        Objects.requireNonNull(background);
        Objects.requireNonNull(diagnosis);
        Objects.requireNonNull(treatment);
        appendChange(new ClinicHistoryAdded(entityId, consultationReason, background, diagnosis, treatment)).apply();
    }

    protected Optional<ClinicHistory> getClinicHistoryById(ClinicHistoryId entityId) {
        return clinicHistories()
                .stream()
                .filter(clinicHistory -> clinicHistory.identity().equals(entityId))
                .findFirst();
    }

    public void UpdateClinicHistoryConsultationReason(ClinicHistoryId entityId, ConsultationReason consultationReason) {
        appendChange(new ClinicHistoryConsultationReasonUpdated(entityId, consultationReason)).apply();
    }

    public void UpdateClinicHistoryBackground(ClinicHistoryId entityId, Background background) {
        appendChange(new ClinicHistoryBackgroundUpdated(entityId, background)).apply();
    }

    public void UpdateClinicHistoryDiagnosis(ClinicHistoryId entityId, Diagnosis diagnosis) {
        appendChange(new ClinicHistoryDiagnosisUpdated(entityId, diagnosis)).apply();
    }

    public void UpdateClinicHistoryTreatment(ClinicHistoryId entityId, Treatment treatment) {
        appendChange(new ClinicHistoryTreatmentUpdated(entityId, treatment)).apply();
    }
}
