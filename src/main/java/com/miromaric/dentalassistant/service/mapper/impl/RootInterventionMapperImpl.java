package com.miromaric.dentalassistant.service.mapper.impl;

import com.miromaric.dentalassistant.service.mapper.*;
import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.model.Patient;
import com.miromaric.dentalassistant.model.RootIntervention;
import com.miromaric.dentalassistant.model.Tooth;
import com.miromaric.dentalassistant.model.ToothRoot;
import com.miromaric.dentalassistant.model.ToothRootState;
import com.miromaric.dentalassistant.model.dto.RootInterventionDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-09T19:42:48+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class RootInterventionMapperImpl implements RootInterventionMapper {

    @Override
    public RootInterventionDto toDtoModel(RootIntervention rootIntervention) {
        if ( rootIntervention == null ) {
            return null;
        }

        RootInterventionDto rootInterventionDto = new RootInterventionDto();

        rootInterventionDto.setToothRootStateID( rootInterventionToothRootStateToothRootStateID( rootIntervention ) );
        rootInterventionDto.setToothID( rootInterventionToothRootToothToothID( rootIntervention ) );
        rootInterventionDto.setPatientID( rootInterventionToothRootToothPatientPatientID( rootIntervention ) );
        rootInterventionDto.setInterventionID( rootInterventionInterventionInterventionID( rootIntervention ) );
        rootInterventionDto.setToothRootID( rootInterventionToothRootToothRootID( rootIntervention ) );
        rootInterventionDto.setNote( rootIntervention.getNote() );

        return rootInterventionDto;
    }

    @Override
    public List<RootInterventionDto> toDtoModel(List<RootIntervention> rootInterventions) {
        if ( rootInterventions == null ) {
            return null;
        }

        List<RootInterventionDto> list = new ArrayList<RootInterventionDto>( rootInterventions.size() );
        for ( RootIntervention rootIntervention : rootInterventions ) {
            list.add( toDtoModel( rootIntervention ) );
        }

        return list;
    }

    @Override
    public RootIntervention toDataModel(RootInterventionDto rootInterventionDto) {
        if ( rootInterventionDto == null ) {
            return null;
        }

        RootIntervention rootIntervention = new RootIntervention();

        rootIntervention.setIntervention( rootInterventionDtoToIntervention( rootInterventionDto ) );
        rootIntervention.setToothRoot( rootInterventionDtoToToothRoot( rootInterventionDto ) );
        rootIntervention.setToothRootState( rootInterventionDtoToToothRootState( rootInterventionDto ) );
        rootIntervention.setNote( rootInterventionDto.getNote() );

        return rootIntervention;
    }

    private Long rootInterventionToothRootStateToothRootStateID(RootIntervention rootIntervention) {
        if ( rootIntervention == null ) {
            return null;
        }
        ToothRootState toothRootState = rootIntervention.getToothRootState();
        if ( toothRootState == null ) {
            return null;
        }
        Long toothRootStateID = toothRootState.getToothRootStateID();
        if ( toothRootStateID == null ) {
            return null;
        }
        return toothRootStateID;
    }

    private Long rootInterventionToothRootToothToothID(RootIntervention rootIntervention) {
        if ( rootIntervention == null ) {
            return null;
        }
        ToothRoot toothRoot = rootIntervention.getToothRoot();
        if ( toothRoot == null ) {
            return null;
        }
        Tooth tooth = toothRoot.getTooth();
        if ( tooth == null ) {
            return null;
        }
        Long toothID = tooth.getToothID();
        if ( toothID == null ) {
            return null;
        }
        return toothID;
    }

    private Long rootInterventionToothRootToothPatientPatientID(RootIntervention rootIntervention) {
        if ( rootIntervention == null ) {
            return null;
        }
        ToothRoot toothRoot = rootIntervention.getToothRoot();
        if ( toothRoot == null ) {
            return null;
        }
        Tooth tooth = toothRoot.getTooth();
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

    private Long rootInterventionInterventionInterventionID(RootIntervention rootIntervention) {
        if ( rootIntervention == null ) {
            return null;
        }
        Intervention intervention = rootIntervention.getIntervention();
        if ( intervention == null ) {
            return null;
        }
        Long interventionID = intervention.getInterventionID();
        if ( interventionID == null ) {
            return null;
        }
        return interventionID;
    }

    private Long rootInterventionToothRootToothRootID(RootIntervention rootIntervention) {
        if ( rootIntervention == null ) {
            return null;
        }
        ToothRoot toothRoot = rootIntervention.getToothRoot();
        if ( toothRoot == null ) {
            return null;
        }
        Long toothRootID = toothRoot.getToothRootID();
        if ( toothRootID == null ) {
            return null;
        }
        return toothRootID;
    }

    protected Intervention rootInterventionDtoToIntervention(RootInterventionDto rootInterventionDto) {
        if ( rootInterventionDto == null ) {
            return null;
        }

        Intervention intervention = new Intervention();

        intervention.setInterventionID( rootInterventionDto.getInterventionID() );

        return intervention;
    }

    protected Patient rootInterventionDtoToPatient(RootInterventionDto rootInterventionDto) {
        if ( rootInterventionDto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setPatientID( rootInterventionDto.getPatientID() );

        return patient;
    }

    protected Tooth rootInterventionDtoToTooth(RootInterventionDto rootInterventionDto) {
        if ( rootInterventionDto == null ) {
            return null;
        }

        Tooth tooth = new Tooth();

        tooth.setPatient( rootInterventionDtoToPatient( rootInterventionDto ) );
        tooth.setToothID( rootInterventionDto.getToothID() );

        return tooth;
    }

    protected ToothRoot rootInterventionDtoToToothRoot(RootInterventionDto rootInterventionDto) {
        if ( rootInterventionDto == null ) {
            return null;
        }

        ToothRoot toothRoot = new ToothRoot();

        toothRoot.setTooth( rootInterventionDtoToTooth( rootInterventionDto ) );
        toothRoot.setToothRootID( rootInterventionDto.getToothRootID() );

        return toothRoot;
    }

    protected ToothRootState rootInterventionDtoToToothRootState(RootInterventionDto rootInterventionDto) {
        if ( rootInterventionDto == null ) {
            return null;
        }

        ToothRootState toothRootState = new ToothRootState();

        toothRootState.setToothRootStateID( rootInterventionDto.getToothRootStateID() );

        return toothRootState;
    }
}
