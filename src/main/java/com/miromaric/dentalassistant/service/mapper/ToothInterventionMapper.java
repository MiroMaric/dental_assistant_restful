package com.miromaric.dentalassistant.service.mapper;
import com.miromaric.dentalassistant.model.ToothIntervention;
import com.miromaric.dentalassistant.model.dto.ToothInterventionDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ToothInterventionMapper {
    
    @Mappings({
        @Mapping(target = "patientID", source = "tooth.patient.patientID"),
        @Mapping(target = "toothID", source = "tooth.toothID"),
        @Mapping(target = "interventionID", source = "intervention.interventionID"),
        @Mapping(target = "toothStateID", source = "toothState.toothStateID")
    })
    ToothInterventionDto toDtoModel(ToothIntervention toothIntervention);

    List<ToothInterventionDto> toDtoModel(List<ToothIntervention> toothInterventions);

    @Mappings({
        @Mapping(target = "tooth.patient.patientID", source = "patientID"),
        @Mapping(target = "tooth.toothID", source = "toothID"),
        @Mapping(target = "intervention.interventionID", source = "interventionID"),
        @Mapping(target = "toothState.toothStateID", source = "toothStateID")
    })
    ToothIntervention toDataModel(ToothInterventionDto toothInterventionDto);
    
}
