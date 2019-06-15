package com.miromaric.dentalassistant.service.mapper.impl;

import com.miromaric.dentalassistant.service.mapper.*;
import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.model.Patient;
import com.miromaric.dentalassistant.model.Tooth;
import com.miromaric.dentalassistant.model.ToothIntervention;
import com.miromaric.dentalassistant.model.ToothState;
import com.miromaric.dentalassistant.model.dto.ToothInterventionDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-14T04:42:30+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class ToothInterventionMapperImpl implements ToothInterventionMapper {

    @Override
    public ToothInterventionDto toDtoModel(ToothIntervention toothIntervention) {
        if ( toothIntervention == null ) {
            return null;
        }

        ToothInterventionDto toothInterventionDto = new ToothInterventionDto();

        toothInterventionDto.setToothID( toothInterventionToothToothID( toothIntervention ) );
        toothInterventionDto.setPatientID( toothInterventionToothPatientPatientID( toothIntervention ) );
        toothInterventionDto.setToothStateID( toothInterventionToothStateToothStateID( toothIntervention ) );
        toothInterventionDto.setInterventionID( toothInterventionInterventionInterventionID( toothIntervention ) );
        toothInterventionDto.setNote( toothIntervention.getNote() );

        return toothInterventionDto;
    }

    @Override
    public List<ToothInterventionDto> toDtoModel(List<ToothIntervention> toothInterventions) {
        if ( toothInterventions == null ) {
            return null;
        }

        List<ToothInterventionDto> list = new ArrayList<ToothInterventionDto>( toothInterventions.size() );
        for ( ToothIntervention toothIntervention : toothInterventions ) {
            list.add( toDtoModel( toothIntervention ) );
        }

        return list;
    }

    @Override
    public ToothIntervention toDataModel(ToothInterventionDto toothInterventionDto) {
        if ( toothInterventionDto == null ) {
            return null;
        }

        ToothIntervention toothIntervention = new ToothIntervention();

        toothIntervention.setToothState( toothInterventionDtoToToothState( toothInterventionDto ) );
        toothIntervention.setIntervention( toothInterventionDtoToIntervention( toothInterventionDto ) );
        toothIntervention.setTooth( toothInterventionDtoToTooth( toothInterventionDto ) );
        toothIntervention.setNote( toothInterventionDto.getNote() );

        return toothIntervention;
    }

    private Long toothInterventionToothToothID(ToothIntervention toothIntervention) {
        if ( toothIntervention == null ) {
            return null;
        }
        Tooth tooth = toothIntervention.getTooth();
        if ( tooth == null ) {
            return null;
        }
        Long toothID = tooth.getToothID();
        if ( toothID == null ) {
            return null;
        }
        return toothID;
    }

    private Long toothInterventionToothPatientPatientID(ToothIntervention toothIntervention) {
        if ( toothIntervention == null ) {
            return null;
        }
        Tooth tooth = toothIntervention.getTooth();
        if ( tooth == null ) {
            return null;
        }
        Patient patient = tooth.getPatient();
        if ( patient == null ) {
            return null;
        }
        Long patientID = patient.getPatientID();
        if ( patientID == null ) {
            return null;
        }
        return patientID;
    }

    private Long toothInterventionToothStateToothStateID(ToothIntervention toothIntervention) {
        if ( toothIntervention == null ) {
            return null;
        }
        ToothState toothState = toothIntervention.getToothState();
        if ( toothState == null ) {
            return null;
        }
        Long toothStateID = toothState.getToothStateID();
        if ( toothStateID == null ) {
            return null;
        }
        return toothStateID;
    }

    private Long toothInterventionInterventionInterventionID(ToothIntervention toothIntervention) {
        if ( toothIntervention == null ) {
            return null;
        }
        Intervention intervention = toothIntervention.getIntervention();
        if ( intervention == null ) {
            return null;
        }
        Long interventionID = intervention.getInterventionID();
        if ( interventionID == null ) {
            return null;
        }
        return interventionID;
    }

    protected ToothState toothInterventionDtoToToothState(ToothInterventionDto toothInterventionDto) {
        if ( toothInterventionDto == null ) {
            return null;
        }

        ToothState toothState = new ToothState();

        toothState.setToothStateID( toothInterventionDto.getToothStateID() );

        return toothState;
    }

    protected Intervention toothInterventionDtoToIntervention(ToothInterventionDto toothInterventionDto) {
        if ( toothInterventionDto == null ) {
            return null;
        }

        Intervention intervention = new Intervention();

        intervention.setInterventionID( toothInterventionDto.getInterventionID() );

        return intervention;
    }

    protected Patient toothInterventionDtoToPatient(ToothInterventionDto toothInterventionDto) {
        if ( toothInterventionDto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setPatientID( toothInterventionDto.getPatientID() );

        return patient;
    }

    protected Tooth toothInterventionDtoToTooth(ToothInterventionDto toothInterventionDto) {
        if ( toothInterventionDto == null ) {
            return null;
        }

        Tooth tooth = new Tooth();

        tooth.setPatient( toothInterventionDtoToPatient( toothInterventionDto ) );
        tooth.setToothID( toothInterventionDto.getToothID() );

        return tooth;
    }
}
