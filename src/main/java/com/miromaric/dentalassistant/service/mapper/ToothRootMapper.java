package com.miromaric.dentalassistant.service.mapper;

import com.miromaric.dentalassistant.model.ToothRoot;
import com.miromaric.dentalassistant.model.ToothSide;
import com.miromaric.dentalassistant.model.dto.ToothRootDto;
import com.miromaric.dentalassistant.model.dto.ToothSideDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ToothRootMapper {
    
    @Mappings({
        @Mapping(target = "toothID", source = "tooth.toothID"),
        @Mapping(target = "toothRootLabelID", source = "rootLabel.toothRootLabelID"),
        @Mapping(target = "patientID", source = "tooth.patient.patientID")
    })
    ToothRootDto toDtoModel(ToothRoot toothRoot);

    List<ToothRootDto> toDtoModel(List<ToothRoot> toothRoots);

    @Mappings({
        @Mapping(target = "tooth.toothID", source = "toothID"),
        @Mapping(target = "rootLabel.toothRootLabelID", source = "toothRootLabelID"),
        @Mapping(target = "tooth.patient.patientID", source = "patientID")
    })
    ToothRoot toDataModel(ToothRootDto toothRootDto);
    
}
