package com.miromaric.dentalassistant.service.mapper.impl;

import com.miromaric.dentalassistant.service.mapper.*;
import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.model.Patient;
import com.miromaric.dentalassistant.model.SideIntervention;
import com.miromaric.dentalassistant.model.Tooth;
import com.miromaric.dentalassistant.model.ToothSide;
import com.miromaric.dentalassistant.model.ToothSideState;
import com.miromaric.dentalassistant.model.dto.SideInterventionDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-09T17:01:42+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class SideInterventionMapperImpl implements SideInterventionMapper {

    @Override
    public SideInterventionDto toDtoModel(SideIntervention sideIntervention) {
        if ( sideIntervention == null ) {
            return null;
        }

        SideInterventionDto sideInterventionDto = new SideInterventionDto();

        sideInterventionDto.setToothSideStateID( sideInterventionToothSideStateToothSideStateID( sideIntervention ) );
        sideInterventionDto.setToothSideID( sideInterventionToothSideToothSideID( sideIntervention ) );
        sideInterventionDto.setToothID( sideInterventionToothSideToothToothID( sideIntervention ) );
        sideInterventionDto.setPatientID( sideInterventionToothSideToothPatientPatientID( sideIntervention ) );
        sideInterventionDto.setInterventionID( sideInterventionInterventionInterventionID( sideIntervention ) );
        sideInterventionDto.setNote( sideIntervention.getNote() );

        return sideInterventionDto;
    }

    @Override
    public List<SideInterventionDto> toDtoModel(List<SideIntervention> sideInterventions) {
        if ( sideInterventions == null ) {
            return null;
        }

        List<SideInterventionDto> list = new ArrayList<SideInterventionDto>( sideInterventions.size() );
        for ( SideIntervention sideIntervention : sideInterventions ) {
            list.add( toDtoModel( sideIntervention ) );
        }

        return list;
    }

    @Override
    public SideIntervention toDataModel(SideInterventionDto sideInterventionDto) {
        if ( sideInterventionDto == null ) {
            return null;
        }

        SideIntervention sideIntervention = new SideIntervention();

        sideIntervention.setToothSide( sideInterventionDtoToToothSide( sideInterventionDto ) );
        sideIntervention.setIntervention( sideInterventionDtoToIntervention( sideInterventionDto ) );
        sideIntervention.setToothSideState( sideInterventionDtoToToothSideState( sideInterventionDto ) );
        sideIntervention.setNote( sideInterventionDto.getNote() );

        return sideIntervention;
    }

    private Long sideInterventionToothSideStateToothSideStateID(SideIntervention sideIntervention) {
        if ( sideIntervention == null ) {
            return null;
        }
        ToothSideState toothSideState = sideIntervention.getToothSideState();
        if ( toothSideState == null ) {
            return null;
        }
        Long toothSideStateID = toothSideState.getToothSideStateID();
        if ( toothSideStateID == null ) {
            return null;
        }
        return toothSideStateID;
    }

    private Long sideInterventionToothSideToothSideID(SideIntervention sideIntervention) {
        if ( sideIntervention == null ) {
            return null;
        }
        ToothSide toothSide = sideIntervention.getToothSide();
        if ( toothSide == null ) {
            return null;
        }
        Long toothSideID = toothSide.getToothSideID();
        if ( toothSideID == null ) {
            return null;
        }
        return toothSideID;
    }

    private Long sideInterventionToothSideToothToothID(SideIntervention sideIntervention) {
        if ( sideIntervention == null ) {
            return null;
        }
        ToothSide toothSide = sideIntervention.getToothSide();
        if ( toothSide == null ) {
            return null;
        }
        Tooth tooth = toothSide.getTooth();
        if ( tooth == null ) {
            return null;
        }
        Long toothID = tooth.getToothID();
        if ( toothID == null ) {
            return null;
        }
        return toothID;
    }

    private Long sideInterventionToothSideToothPatientPatientID(SideIntervention sideIntervention) {
        if ( sideIntervention == null ) {
            return null;
        }
        ToothSide toothSide = sideIntervention.getToothSide();
        if ( toothSide == null ) {
            return null;
        }
        Tooth tooth = toothSide.getTooth();
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

    private Long sideInterventionInterventionInterventionID(SideIntervention sideIntervention) {
        if ( sideIntervention == null ) {
            return null;
        }
        Intervention intervention = sideIntervention.getIntervention();
        if ( intervention == null ) {
            return null;
        }
        Long interventionID = intervention.getInterventionID();
        if ( interventionID == null ) {
            return null;
        }
        return interventionID;
    }

    protected Patient sideInterventionDtoToPatient(SideInterventionDto sideInterventionDto) {
        if ( sideInterventionDto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setPatientID( sideInterventionDto.getPatientID() );

        return patient;
    }

    protected Tooth sideInterventionDtoToTooth(SideInterventionDto sideInterventionDto) {
        if ( sideInterventionDto == null ) {
            return null;
        }

        Tooth tooth = new Tooth();

        tooth.setPatient( sideInterventionDtoToPatient( sideInterventionDto ) );
        tooth.setToothID( sideInterventionDto.getToothID() );

        return tooth;
    }

    protected ToothSide sideInterventionDtoToToothSide(SideInterventionDto sideInterventionDto) {
        if ( sideInterventionDto == null ) {
            return null;
        }

        ToothSide toothSide = new ToothSide();

        toothSide.setTooth( sideInterventionDtoToTooth( sideInterventionDto ) );
        toothSide.setToothSideID( sideInterventionDto.getToothSideID() );

        return toothSide;
    }

    protected Intervention sideInterventionDtoToIntervention(SideInterventionDto sideInterventionDto) {
        if ( sideInterventionDto == null ) {
            return null;
        }

        Intervention intervention = new Intervention();

        intervention.setInterventionID( sideInterventionDto.getInterventionID() );

        return intervention;
    }

    protected ToothSideState sideInterventionDtoToToothSideState(SideInterventionDto sideInterventionDto) {
        if ( sideInterventionDto == null ) {
            return null;
        }

        ToothSideState toothSideState = new ToothSideState();

        toothSideState.setToothSideStateID( sideInterventionDto.getToothSideStateID() );

        return toothSideState;
    }
}
