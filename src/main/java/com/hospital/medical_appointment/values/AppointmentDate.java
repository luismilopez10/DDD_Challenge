package com.hospital.medical_appointment.values;

import co.com.sofka.domain.generic.ValueObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class AppointmentDate implements ValueObject<String> {
    private final String value;

    public AppointmentDate(String value) throws ParseException {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("The appointment date can not be empty");
        }

        DateTimeFormatter dtmFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String strDateNow = dtmFormatter.format(LocalDateTime.now());

        Date dateNow = new SimpleDateFormat("dd/MM/yyyy").parse(strDateNow);
        Date appointmentDate = new SimpleDateFormat("dd/MM/yyyy").parse(value);

        if (dateNow.after(appointmentDate)){
            throw new IllegalArgumentException("The appointment date must be after the actual date");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentDate that = (AppointmentDate) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
