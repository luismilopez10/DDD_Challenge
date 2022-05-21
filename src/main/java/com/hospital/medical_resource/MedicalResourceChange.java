package com.hospital.medical_resource;

import co.com.sofka.domain.generic.EventChange;
import com.hospital.medical_appointment.Pacient;
import com.hospital.medical_appointment.events.PacientAdded;
import com.hospital.medical_appointment.events.PacientNameUpdated;
import com.hospital.medical_appointment.events.PacientPhoneNumberUpdated;
import com.hospital.medical_resource.events.*;

import java.util.HashSet;

public class MedicalResourceChange extends EventChange {
    public MedicalResourceChange(MedicalResource medicalResource) {

        apply((MedicalResourceCreated event) -> {
            medicalResource.name = event.getName();
            medicalResource.consultingRooms = new HashSet<>();
            medicalResource.stretchers = new HashSet<>();
            medicalResource.phonendoscopes = new HashSet<>();
        });


        // ConsultingRoom events
        apply((ConsultingRoomAdded event) -> {
            var numConsultingRooms = medicalResource.consultingRooms().size();

            if (numConsultingRooms == 1) {
                throw new IllegalArgumentException("The medical resource can only have one consulting room");
            }

            medicalResource.consultingRooms.add(new ConsultingRoom(
                    event.getConsultingRoomId(),
                    event.getAddress()
            ));
        });

        apply((ConsultingRoomAddressUpdated event) -> {
            var consultingRoom = medicalResource.getConsultingRoomById(event.getConsultingRoomId())
                    .orElseThrow(() -> new IllegalArgumentException("Consulting room not found in the current medical resource"));

            consultingRoom.updateAddress(event.getAddress());
        });


        // Stretcher events
        apply((StretcherAdded event) -> {
            var numStretchers = medicalResource.stretchers().size();

            if (numStretchers == 1) {
                throw new IllegalArgumentException("The medical resource can only have one stretcher");
            }

            medicalResource.stretchers.add(new Stretcher(
                    event.getStretcherId(),
                    event.getType(),
                    event.getReclining()
            ));
        });

        apply((StretcherTypeUpdated event) -> {
            var stretcher = medicalResource.getStretcherById(event.getStretcherId())
                    .orElseThrow(() -> new IllegalArgumentException("Stretcher not found in the current medical resource"));

            stretcher.updateType(event.getType());
        });

        apply((StretcherRecliningUpdated event) -> {
            var stretcher = medicalResource.getStretcherById(event.getStretcherId())
                    .orElseThrow(() -> new IllegalArgumentException("Stretcher not found in the current medical resource"));

            stretcher.updateReclining(event.getReclining());
        });


        // Phonendoscope events
        apply((PhonendoscopeAdded event) -> {
            var numPhonendoscopes = medicalResource.phonendoscopes().size();

            if (numPhonendoscopes == 1) {
                throw new IllegalArgumentException("The medical resource can only have one phonendoscope");
            }

            medicalResource.phonendoscopes.add(new Phonendoscope(
                    event.getPhonendoscopeId(),
                    event.getBrand()
            ));
        });

        apply((PhonendoscopeBrandUpdated event) -> {
            var phonendoscope = medicalResource.getPhonendoscopeById(event.getPhonendoscopeId())
                    .orElseThrow(() -> new IllegalArgumentException("Phonendoscope not found in the current medical resource"));

            phonendoscope.updateBrand(event.getBrand());
        });
    }
}
