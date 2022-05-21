package com.hospital.medical_resource;

import co.com.sofka.domain.generic.AggregateEvent;
import com.hospital.medical_appointment.values.Name;
import com.hospital.medical_resource.events.*;
import com.hospital.medical_resource.values.*;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class MedicalResource extends AggregateEvent<MedicalResourceId> {

    protected Name name;
    protected Set<ConsultingRoom> consultingRooms;
    protected Set<Stretcher> stretchers;
    protected Set<Phonendoscope> phonendoscopes;

    public MedicalResource(MedicalResourceId entityId, Name name) {
        super(entityId);
        appendChange(new MedicalResourceCreated(name)).apply();
    }

    private MedicalResource(MedicalResourceId entityId) {
        super(entityId);
        subscribe(new MedicalResourceChange(this));
    }

    // Getters
    public MedicalResourceId medicalResourceId() {
        return entityId;
    }

    public Name name() {
        return name;
    }

    public Set<ConsultingRoom> consultingRooms() {
        return consultingRooms;
    }

    public Set<Stretcher> stretchers() {
        return stretchers;
    }

    public Set<Phonendoscope> phonendoscopes() {
        return phonendoscopes;
    }

    // ConsultingRoom Behaviors
    public void AddConsultingRoom(ConsultingRoomId entityId, Address address) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(address);
        appendChange(new ConsultingRoomAdded(entityId, address)).apply();
    }

    public Optional<ConsultingRoom> getConsultingRoomById(ConsultingRoomId entityId) {
        return consultingRooms()
                .stream()
                .filter(consultingRoom -> consultingRoom.identity().equals(entityId))
                .findFirst();
    }

    public void UpdateConsultingRoomAddress(ConsultingRoomId entityId, Address address) {
        appendChange(new ConsultingRoomAddressUpdated(entityId, address)).apply();
    }

    // Stretcher Behaviors
    public void AddStretcher(StretcherId entityId, Type type, Reclining reclining) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(type);
        Objects.requireNonNull(reclining);
        appendChange(new StretcherAdded(entityId, type, reclining)).apply();
    }

    public Optional<Stretcher> getStretcherById(StretcherId entityId) {
        return stretchers()
                .stream()
                .filter(stretcher -> stretcher.identity().equals(entityId))
                .findFirst();
    }

    public void UpdateStretcherType(StretcherId entityId, Type type) {
        appendChange(new StretcherTypeUpdated(entityId, type)).apply();
    }

    public void UpdateStretcherReclining(StretcherId entityId, Reclining reclining) {
        appendChange(new StretcherRecliningUpdated(entityId, reclining)).apply();
    }

    // Phonendoscope Behaviors
    public void AddPhonendoscope(PhonendoscopeId entityId, Brand brand) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(brand);
        appendChange(new PhonendoscopeAdded(entityId, brand)).apply();
    }

    public Optional<Phonendoscope> getPhonendoscopeById(PhonendoscopeId entityId) {
        return phonendoscopes()
                .stream()
                .filter(phonendoscope -> phonendoscope.identity().equals(entityId))
                .findFirst();
    }

    public void UpdatePhonendoscopeBrand(PhonendoscopeId entityId, Brand brand) {
        appendChange(new PhonendoscopeBrandUpdated(entityId, brand)).apply();
    }
}
