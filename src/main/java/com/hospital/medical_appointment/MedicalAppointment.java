package com.hospital.medical_appointment;

import co.com.sofka.domain.generic.AggregateEvent;
import com.hospital.medical_appointment.events.MedicalAppointmentCreated;
import com.hospital.medical_appointment.values.AppointmentDate;
import com.hospital.medical_resource.values.MedicalResourceId;

import java.util.Set;

public class MedicalAppointment extends AggregateEvent<MedicalResourceId> {
    protected AppointmentDate appointmentDate;
    protected Set<Pacient> pacients;
    protected Set<Doctor> doctors;
    protected Set<ClinicHistory> clinicHistories;

    public MedicalAppointment(MedicalResourceId entityId, AppointmentDate appointmentDate) {
        super(entityId);
        appendChange(new MedicalAppointmentCreated(appointmentDate)).apply();
    }
}
