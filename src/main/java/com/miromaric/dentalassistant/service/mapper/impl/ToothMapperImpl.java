package com.miromaric.dentalassistant.service.mapper.impl;

import com.miromaric.dentalassistant.service.mapper.*;
import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.model.Patient;
import com.miromaric.dentalassistant.model.Tooth;
import com.miromaric.dentalassistant.model.ToothLabel;
import com.miromaric.dentalassistant.model.dto.InterventionDto;
import com.miromaric.dentalassistant.model.dto.ToothDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-02T17:14:17+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
public class ToothMapperImpl implements ToothMapper {

    @Override
    public ToothDto toDtoModel(Tooth tooth) {
        if ( tooth == null ) {
            return null;
        }

        ToothDto toothDto = new ToothDto();

        toothDto.setPatientID( toothPatientPatientID( tooth ) );
        toothDto.setToothLabelID( toothToothLabelToothLabelID( tooth ) );

        return toothDto;
    }

    @Override
    public List<InterventionDto> toDtoModel(List<Intervention> interventions) {
        if ( interventions == null ) {
            return null;
        }

        List<InterventionDto> list = new ArrayList<>( interventions.size() );
        for ( Intervention intervention : interventions ) {
            list.add( interventionToInterventionDto( intervention ) );
        }

        return list;
    }

    @Override
    public Tooth toDataModel(ToothDto toothDto) {
        if ( toothDto == null ) {
            return null;
        }

        Tooth tooth = new Tooth();

        tooth.setPatient( toothDtoToPatient( toothDto ) );
        tooth.setToothLabel( toothDtoToToothLabel( toothDto ) );

        return tooth;
    }

    private Long toothPatientPatientID(Tooth tooth) {
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

    private Long toothToothLabelToothLabelID(Tooth tooth) {
        if ( tooth == null ) {
            return null;
        }
        ToothLabel toothLabel = tooth.getToothLabel();
        if ( toothLabel == null ) {
            return null;
        }
        Long toothLabelID = toothLabel.getToothLabelID();
        if ( toothLabelID == null ) {
            return null;
        }
        return toothLabelID;
    }

    protected InterventionDto interventionToInterventionDto(Intervention intervention) {
        if ( intervention == null ) {
            return null;
        }

        InterventionDto interventionDto = new InterventionDto();

        interventionDto.setDate( intervention.getDate() );
        interventionDto.setNote( intervention.getNote() );

        return interventionDto;
    }

    protected Patient toothDtoToPatient(ToothDto toothDto) {
        if ( toothDto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setPatientID( toothDto.getPatientID() );

        return patient;
    }

    protected ToothLabel toothDtoToToothLabel(ToothDto toothDto) {
        if ( toothDto == null ) {
            return null;
        }

        ToothLabel toothLabel = new ToothLabel();

        toothLabel.setToothLabelID( toothDto.getToothLabelID() );

        return toothLabel;
    }
}
