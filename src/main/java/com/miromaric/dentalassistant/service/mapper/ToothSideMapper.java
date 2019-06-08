package com.miromaric.dentalassistant.service.mapper;

import com.miromaric.dentalassistant.model.ToothSide;
import com.miromaric.dentalassistant.model.dto.ToothSideDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ToothSideMapper {
    
    @Mappings({
        @Mapping(target = "toothID", source = "tooth.toothID"),
        @Mapping(target = "toothSideLabelID", source = "sideLabel.toothSideLabelID"),
        @Mapping(target = "patientID", source = "tooth.patient.patientID")
    })
    ToothSideDto toDtoModel(ToothSide toothSide);

    List<ToothSideDto> toDtoModel(List<ToothSide> toothSides);

    @Mappings({
        @Mapping(target = "tooth.toothID", source = "toothID"),
        @Mapping(target = "sideLabel.toothSideLabelID", source = "toothSideLabelID"),
        @Mapping(target = "tooth.patient.patientID", source = "patientID")
    })
    ToothSide toDataModel(ToothSideDto toothSideDto);
    
}
