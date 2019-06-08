package com.miromaric.dentalassistant.service.mapper.impl;

import com.miromaric.dentalassistant.service.mapper.*;
import com.miromaric.dentalassistant.model.Patient;
import com.miromaric.dentalassistant.model.Tooth;
import com.miromaric.dentalassistant.model.ToothSide;
import com.miromaric.dentalassistant.model.ToothSideLabel;
import com.miromaric.dentalassistant.model.dto.ToothSideDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-08T18:50:51+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class ToothSideMapperImpl implements ToothSideMapper {

    @Override
    public ToothSideDto toDtoModel(ToothSide toothSide) {
        if ( toothSide == null ) {
            return null;
        }

        ToothSideDto toothSideDto = new ToothSideDto();

        toothSideDto.setToothSideLabelID( toothSideSideLabelToothSideLabelID( toothSide ) );
        toothSideDto.setToothID( toothSideToothToothID( toothSide ) );
        toothSideDto.setPatientID( toothSideToothPatientPatientID( toothSide ) );

        return toothSideDto;
    }

    @Override
    public List<ToothSideDto> toDtoModel(List<ToothSide> toothSides) {
        if ( toothSides == null ) {
            return null;
        }

        List<ToothSideDto> list = new ArrayList<ToothSideDto>( toothSides.size() );
        for ( ToothSide toothSide : toothSides ) {
            list.add( toDtoModel( toothSide ) );
        }

        return list;
    }

    @Override
    public ToothSide toDataModel(ToothSideDto toothSideDto) {
        if ( toothSideDto == null ) {
            return null;
        }

        ToothSide toothSide = new ToothSide();

        toothSide.setTooth( toothSideDtoToTooth( toothSideDto ) );
        toothSide.setSideLabel( toothSideDtoToToothSideLabel( toothSideDto ) );
        return toothSide;
    }

    private Long toothSideSideLabelToothSideLabelID(ToothSide toothSide) {
        if ( toothSide == null ) {
            return null;
        }
        ToothSideLabel sideLabel = toothSide.getSideLabel();
        if ( sideLabel == null ) {
            return null;
        }
        Long toothSideLabelID = sideLabel.getToothSideLabelID();
        if ( toothSideLabelID == null ) {
            return null;
        }
        return toothSideLabelID;
    }

    private Long toothSideToothToothID(ToothSide toothSide) {
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

    private Long toothSideToothPatientPatientID(ToothSide toothSide) {
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

    protected Patient toothSideDtoToPatient(ToothSideDto toothSideDto) {
        if ( toothSideDto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setPatientID( toothSideDto.getPatientID() );

        return patient;
    }

    protected Tooth toothSideDtoToTooth(ToothSideDto toothSideDto) {
        if ( toothSideDto == null ) {
            return null;
        }

        Tooth tooth = new Tooth();

        tooth.setPatient( toothSideDtoToPatient( toothSideDto ) );
        tooth.setToothID( toothSideDto.getToothID() );

        return tooth;
    }

    protected ToothSideLabel toothSideDtoToToothSideLabel(ToothSideDto toothSideDto) {
        if ( toothSideDto == null ) {
            return null;
        }

        ToothSideLabel toothSideLabel = new ToothSideLabel();

        toothSideLabel.setToothSideLabelID( toothSideDto.getToothSideLabelID() );

        return toothSideLabel;
    }
}
