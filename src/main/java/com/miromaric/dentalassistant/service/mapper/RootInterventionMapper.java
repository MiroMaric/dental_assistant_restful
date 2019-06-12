package com.miromaric.dentalassistant.service.mapper;

import com.miromaric.dentalassistant.model.RootIntervention;
import com.miromaric.dentalassistant.model.dto.RootInterventionDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface RootInterventionMapper {
    
    @Mappings({
        @Mapping(target = "patientID", source = "toothRoot.tooth.patient.patientID"),
        @Mapping(target = "toothID", source = "toothRoot.tooth.toothID"),
        @Mapping(target = "toothRootID", source = "toothRoot.toothRootID"),
        @Mapping(target = "interventionID", source = "intervention.interventionID"),
        @Mapping(target = "toothRootStateID", source = "toothRootState.toothRootStateID")
    })
    RootInterventionDto toDtoModel(RootIntervention rootIntervention);

    List<RootInterventionDto> toDtoModel(List<RootIntervention> rootInterventions);

    @Mappings({
        @Mapping(target = "toothRoot.tooth.patient.patientID", source = "patientID"),
        @Mapping(target = "toothRoot.tooth.toothID", source = "toothID"),
        @Mapping(target = "toothRoot.toothRootID", source = "toothRootID"),
        @Mapping(target = "intervention.interventionID", source = "interventionID"),
        @Mapping(target = "toothRootState.toothRootStateID", source = "toothRootStateID")
    })
    RootIntervention toDataModel(RootInterventionDto rootInterventionDto);
    
}
