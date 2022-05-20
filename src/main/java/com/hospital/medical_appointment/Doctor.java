package com.hospital.medical_appointment;

import co.com.sofka.domain.generic.Entity;
import com.hospital.medical_appointment.values.DoctorId;
import com.hospital.medical_appointment.values.Name;
import com.hospital.medical_appointment.values.Email;

import java.util.Objects;

public class Doctor extends Entity<DoctorId> {

    private Name name;
    private Email email;

    public Doctor(DoctorId entityId, Name name, Email email) {
        super(entityId);
        this.name = name;
        this.email = email;
    }

    // Behaviors
    public void updateName(Name name){
        this.name = Objects.requireNonNull(name);
    }

    public void updateEmail(Email email){
        this.email = Objects.requireNonNull(email);
    }

    // Getters
    public Name name() {
        return name;
    }

    public Email email() {
        return email;
    }

}
