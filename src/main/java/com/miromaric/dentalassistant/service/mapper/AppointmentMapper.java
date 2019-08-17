package com.miromaric.dentalassistant.service.mapper;

import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.model.dto.AppointmentDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface AppointmentMapper {

    AppointmentDto toDtoModel(Appointment appointment);

    List<AppointmentDto> toDtoModel(List<Appointment> appointments);

    Appointment toDataModel(AppointmentDto appointmentDto);
    
}
