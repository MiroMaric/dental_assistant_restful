package com.miromaric.dentalassistant.service.mapper;

import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.model.dto.InterventionDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author MikoPC
 */
@Mapper
public interface InterventionMapper {

    @Mapping(target = "username", source = "user.username")
    InterventionDto toDtoModel(Intervention intervention);

    List<InterventionDto> toDtoModel(List<Intervention> interventions);

    @Mapping(target = "user.username", source = "username")
    Intervention toDataModel(InterventionDto interventionDto);

}
