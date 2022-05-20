package com.hospital.medical_appointment;

import co.com.sofka.domain.generic.Entity;
import com.hospital.medical_appointment.values.Name;
import com.hospital.medical_appointment.values.PacientId;
import com.hospital.medical_appointment.values.PhoneNumber;

import java.util.Objects;

public class Pacient extends Entity<PacientId> {

    private Name name;
    private PhoneNumber phoneNumber;

    public Pacient(PacientId entityId, Name name, PhoneNumber phoneNumber) {
        super(entityId);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public Name name() {
        return name;
    }

    public PhoneNumber phoneNumber() {
        return phoneNumber;
    }

    // Behaviors
    public void updateName(Name name){
        this.name = Objects.requireNonNull(name);
    }

    public void updatePhoneNumber(PhoneNumber phoneNumber){
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
    }
}
