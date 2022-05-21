package com.hospital.medical_appointment;

import co.com.sofka.domain.generic.EventChange;
import com.hospital.medical_appointment.events.*;

import java.util.HashSet;

public class MedicalAppointmentChange extends EventChange {
    public MedicalAppointmentChange(MedicalAppointment medicalAppointment) {

        apply((MedicalAppointmentCreated event) -> {
            medicalAppointment.appointmentDate = event.getAppointmentDate();
            medicalAppointment.pacients = new HashSet<>();
            medicalAppointment.doctors = new HashSet<>();
            medicalAppointment.clinicHistories = new HashSet<>();
        });


        // Pacient events
        apply((PacientAdded event) -> {
            var numPacients = medicalAppointment.pacients().size();

            if (numPacients == 1) {
                throw new IllegalArgumentException("The medical appointment can only have one pacient");
            }

            medicalAppointment.pacients.add(new Pacient(
                    event.getPacientId(),
                    event.getName(),
                    event.getPhoneNumber()
            ));
        });

        apply((PacientNameUpdated event) -> {
            var pacient = medicalAppointment.getPacientById(event.getPacientId())
                    .orElseThrow(() -> new IllegalArgumentException("Pacient not found in the current medical appointment"));

            pacient.updateName(event.getName());
        });

        apply((PacientPhoneNumberUpdated event) -> {
            var pacient = medicalAppointment.getPacientById(event.getPacientId())
                    .orElseThrow(() -> new IllegalArgumentException("Pacient not found in the current medical appointment"));

            pacient.updatePhoneNumber(event.getPhoneNumber());
        });


        // Doctor events
        apply((DoctorAdded event) -> {
            var numDoctors = medicalAppointment.doctors().size();

            if (numDoctors == 1) {
                throw new IllegalArgumentException("The medical appointment can only have one doctor");
            }

            medicalAppointment.doctors.add(new Doctor(
                    event.getDoctorId(),
                    event.getName(),
                    event.getEmail()
            ));
        });

        apply((DoctorNameUpdated event) -> {
            var doctor = medicalAppointment.getDoctorById(event.getDoctorId())
                    .orElseThrow(() -> new IllegalArgumentException("Doctor not found in the current medical appointment"));

            doctor.updateName(event.getName());
        });

        apply((DoctorEmailUpdated event) -> {
            var doctor = medicalAppointment.getDoctorById(event.getDoctorId())
                    .orElseThrow(() -> new IllegalArgumentException("Doctor not found in the current medical appointment"));

            doctor.updateEmail(event.getEmail());
        });


        // ClinicHistory events
        apply((ClinicHistoryAdded event) -> {
            var numClinicHistories = medicalAppointment.clinicHistories().size();

            if (numClinicHistories == 1) {
                throw new IllegalArgumentException("The medical appointment can only have one clinic history");
            }

            medicalAppointment.clinicHistories.add(new ClinicHistory(
                    event.getClinicHistoryId(),
                    event.getConsultationReason(),
                    event.getBackground(),
                    event.getDiagnosis(),
                    event.getTreatment()
            ));
        });

        apply((ClinicHistoryConsultationReasonUpdated event) -> {
            var clinicHistory = medicalAppointment.getClinicHistoryById(event.getClinicHistoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Clinic history not found in the current medical appointment"));

            clinicHistory.updateConsultationReason(event.getConsultationReason());
        });

        apply((ClinicHistoryBackgroundUpdated event) -> {
            var clinicHistory = medicalAppointment.getClinicHistoryById(event.getClinicHistoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Clinic history not found in the current medical appointment"));

            clinicHistory.updateBackground(event.getBackground());
        });

        apply((ClinicHistoryDiagnosisUpdated event) -> {
            var clinicHistory = medicalAppointment.getClinicHistoryById(event.getClinicHistoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Clinic history not found in the current medical appointment"));

            clinicHistory.updateDiagnosis(event.getDiagnosis());
        });

        apply((ClinicHistoryTreatmentUpdated event) -> {
            var clinicHistory = medicalAppointment.getClinicHistoryById(event.getClinicHistoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Clinic history not found in the current medical appointment"));

            clinicHistory.updateTreatment(event.getTreatment());
        });
    }
}
