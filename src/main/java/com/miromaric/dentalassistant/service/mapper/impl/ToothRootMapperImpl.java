package com.miromaric.dentalassistant.service.mapper.impl;

import com.miromaric.dentalassistant.service.mapper.*;
import com.miromaric.dentalassistant.model.Patient;
import com.miromaric.dentalassistant.model.Tooth;
import com.miromaric.dentalassistant.model.ToothRoot;
import com.miromaric.dentalassistant.model.ToothRootLabel;
import com.miromaric.dentalassistant.model.dto.ToothRootDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-08T21:37:18+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class ToothRootMapperImpl implements ToothRootMapper {

    @Override
    public ToothRootDto toDtoModel(ToothRoot toothRoot) {
        if ( toothRoot == null ) {
            return null;
        }

        ToothRootDto toothRootDto = new ToothRootDto();

        toothRootDto.setToothID( toothRootToothToothID( toothRoot ) );
        toothRootDto.setPatientID( toothRootToothPatientPatientID( toothRoot ) );
        toothRootDto.setToothRootLabelID( toothRootRootLabelToothRootLabelID( toothRoot ) );

        return toothRootDto;
    }

    @Override
    public List<ToothRootDto> toDtoModel(List<ToothRoot> toothRoots) {
        if ( toothRoots == null ) {
            return null;
        }

        List<ToothRootDto> list = new ArrayList<ToothRootDto>( toothRoots.size() );
        for ( ToothRoot toothRoot : toothRoots ) {
            list.add( toDtoModel( toothRoot ) );
        }

        return list;
    }

    @Override
    public ToothRoot toDataModel(ToothRootDto toothRootDto) {
        if ( toothRootDto == null ) {
            return null;
        }

        ToothRoot toothRoot = new ToothRoot();

        toothRoot.setTooth( toothRootDtoToTooth( toothRootDto ) );
        toothRoot.setRootLabel( toothRootDtoToToothRootLabel( toothRootDto ) );

        return toothRoot;
    }

    private Long toothRootToothToothID(ToothRoot toothRoot) {
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

    private Long toothRootToothPatientPatientID(ToothRoot toothRoot) {
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

    private Long toothRootRootLabelToothRootLabelID(ToothRoot toothRoot) {
        if ( toothRoot == null ) {
            return null;
        }
        ToothRootLabel rootLabel = toothRoot.getRootLabel();
        if ( rootLabel == null ) {
            return null;
        }
        Long toothRootLabelID = rootLabel.getToothRootLabelID();
        if ( toothRootLabelID == null ) {
            return null;
        }
        return toothRootLabelID;
    }

    protected Patient toothRootDtoToPatient(ToothRootDto toothRootDto) {
        if ( toothRootDto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setPatientID( toothRootDto.getPatientID() );

        return patient;
    }

    protected Tooth toothRootDtoToTooth(ToothRootDto toothRootDto) {
        if ( toothRootDto == null ) {
            return null;
        }

        Tooth tooth = new Tooth();

        tooth.setPatient( toothRootDtoToPatient( toothRootDto ) );
        tooth.setToothID( toothRootDto.getToothID() );

        return tooth;
    }

    protected ToothRootLabel toothRootDtoToToothRootLabel(ToothRootDto toothRootDto) {
        if ( toothRootDto == null ) {
            return null;
        }

        ToothRootLabel toothRootLabel = new ToothRootLabel();

        toothRootLabel.setToothRootLabelID( toothRootDto.getToothRootLabelID() );

        return toothRootLabel;
    }
}
