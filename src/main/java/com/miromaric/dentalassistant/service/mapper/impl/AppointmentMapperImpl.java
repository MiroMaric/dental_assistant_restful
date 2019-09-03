package com.miromaric.dentalassistant.service.mapper.impl;

import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.model.dto.AppointmentDto;
import com.miromaric.dentalassistant.service.mapper.AppointmentMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-08-16T22:11:06+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public AppointmentDto toDtoModel(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        AppointmentDto appointmentDto = new AppointmentDto();

        appointmentDto.setStartTime( appointment.getStartTime() );
        appointmentDto.setEndTime( appointment.getEndTime() );
        appointmentDto.setDescription( appointment.getDescription() );

        return appointmentDto;
    }

    @Override
    public List<AppointmentDto> toDtoModel(List<Appointment> appointments) {
        if ( appointments == null ) {
            return null;
        }

        List<AppointmentDto> list = new ArrayList<AppointmentDto>( appointments.size() );
        for ( Appointment appointment : appointments ) {
            list.add( toDtoModel( appointment ) );
        }

        return list;
    }

    @Override
    public Appointment toDataModel(AppointmentDto appointmentDto) {
        if ( appointmentDto == null ) {
            return null;
        }

        Appointment appointment = new Appointment();

        appointment.setStartTime( appointmentDto.getStartTime() );
        appointment.setEndTime( appointmentDto.getEndTime() );
        appointment.setDescription( appointmentDto.getDescription() );

        return appointment;
    }
}
