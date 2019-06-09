
package com.miromaric.dentalassistant.service.mapper;

import com.miromaric.dentalassistant.model.SideIntervention;
import com.miromaric.dentalassistant.model.dto.SideInterventionDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface SideInterventionMapper {
    
    @Mappings({
        @Mapping(target = "patientID", source = "toothSide.tooth.patient.patientID"),
        @Mapping(target = "toothID", source = "toothSide.tooth.toothID"),
        @Mapping(target = "toothSideID", source = "toothSide.toothSideID"),
        @Mapping(target = "interventionID", source = "intervention.interventionID"),
        @Mapping(target = "toothSideStateID", source = "toothSideState.toothSideStateID")
    })
    SideInterventionDto toDtoModel(SideIntervention sideIntervention);

    List<SideInterventionDto> toDtoModel(List<SideIntervention> sideInterventions);

    @Mappings({
        @Mapping(target = "toothSide.tooth.patient.patientID", source = "patientID"),
        @Mapping(target = "toothSide.tooth.toothID", source = "toothID"),
        @Mapping(target = "toothSide.toothSideID", source = "toothSideID"),
        @Mapping(target = "intervention.interventionID", source = "interventionID"),
        @Mapping(target = "toothSideState.toothSideStateID", source = "toothSideStateID")
    })
    SideIntervention toDataModel(SideInterventionDto sideInterventionDto);
    
}
