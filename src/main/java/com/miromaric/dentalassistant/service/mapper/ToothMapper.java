package com.miromaric.dentalassistant.service.mapper;

import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.model.Tooth;
import com.miromaric.dentalassistant.model.dto.InterventionDto;
import com.miromaric.dentalassistant.model.dto.ToothDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author MikoPC
 */
@Mapper
public interface ToothMapper {

    @Mappings({
        @Mapping(target = "patientID", source = "patient.patientID"),
        @Mapping(target = "toothLabelID", source = "toothLabel.toothLabelID")
    })
    ToothDto toDtoModel(Tooth tooth);

    List<InterventionDto> toDtoModel(List<Intervention> interventions);

    @Mappings({
        @Mapping(target = "patient.patientID", source = "patientID"),
        @Mapping(target = "toothLabel.toothLabelID", source = "toothLabelID")
    })
    Tooth toDataModel(ToothDto toothDto);

}
