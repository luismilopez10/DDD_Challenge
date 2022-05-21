package com.hospital.medical_resource.values;

import co.com.sofka.domain.generic.Identity;
import com.hospital.medical_appointment.values.ClinicHistoryId;

public class ConsultingRoomId extends Identity {

    public ConsultingRoomId() {
    }

    private ConsultingRoomId(String id) {
        super(id);
    }

    public static ConsultingRoomId of(String id){
        return new ConsultingRoomId(id);
    }
}
