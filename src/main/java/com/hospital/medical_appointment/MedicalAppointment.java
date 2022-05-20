package com.hospital.medical_appointment;

import co.com.sofka.domain.generic.AggregateEvent;
import com.hospital.medical_appointment.events.MedicalAppointmentCreated;
import com.hospital.medical_appointment.values.*;

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

    public MedicalAppointmentId medicalResourceId() {
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

    public Optional<Pacient> getPacientById(PacientId entityId) {
        return pacients()
                .stream()
                .filter(pacient -> pacient.identity().equals(entityId))
                .findFirst();
    }

    public void UpdatePacientName(PacientId entityId, Name name) {
        appendChange(new PacientNameUpdated(name)).apply();
    }

    public void UpdatePacientPhoneNumber(PacientId entityId, PhoneNumber phoneNumber) {
        appendChange(new PacientPhoneNumberUpdated(phoneNumber)).apply();
    }

    // Doctor Behaviors
    public void AddDoctor(DoctorId entityId, Name name, Email email) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        appendChange(new DoctorAdded(entityId, name, email)).apply();
    }

    public Optional<Doctor> getDoctorById(DoctorId entityId) {
        return doctors()
                .stream()
                .filter(doctor -> doctor.identity().equals(entityId))
                .findFirst();
    }

    public void UpdateDoctorName(DoctorId entityId, Name name) {
        appendChange(new DoctorNameUpdated(name)).apply();
    }

    public void UpdateDoctorEmail(DoctorId entityId, Email email) {
        appendChange(new DoctorEmailUpdated(email)).apply();
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

    public Optional<ClinicHistory> getClinicHistoryById(ClinicHistoryId entityId) {
        return clinicHistories()
                .stream()
                .filter(clinicHistory -> clinicHistory.identity().equals(entityId))
                .findFirst();
    }

    public void UpdateClinicHistoryConsultationReason(ClinicHistoryId entityId, ConsultationReason consultationReason) {
        appendChange(new ClinicHistoryConsultationReasonUpdated(consultationReason)).apply();
    }

    public void UpdateClinicHistoryBackground(ClinicHistoryId entityId, Background background) {
        appendChange(new ClinicHistoryBackgroundUpdated(background)).apply();
    }

    public void UpdateClinicHistoryDiagnosis(ClinicHistoryId entityId, Diagnosis diagnosis) {
        appendChange(new ClinicHistoryDiagnosisUpdated(diagnosis)).apply();
    }

    public void UpdateClinicHistoryTreatment(ClinicHistoryId entityId, Treatment treatment) {
        appendChange(new ClinicHistoryTreatmentUpdated(treatment)).apply();
    }
}
